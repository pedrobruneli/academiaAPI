package com.bruneli.academia.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruneli.academia.converter.DozerConverter;
import com.bruneli.academia.data.entities.Aluno;
import com.bruneli.academia.data.entities.AvaliacaoFisica;
import com.bruneli.academia.data.vo.AvaliacaoFisicaVO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaDTO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaUpdateDTO;
import com.bruneli.academia.repositories.AlunoRepository;
import com.bruneli.academia.repositories.AvaliacaoFisicaRepository;
import com.bruneli.academia.services.AvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaServiceImpl implements AvaliacaoFisicaService{
	
	@Autowired
	private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public AvaliacaoFisicaVO create(AvaliacaoFisicaDTO avaliacaoDTO) {
		AvaliacaoFisicaVO fisica = new AvaliacaoFisicaVO();
		Aluno aluno = alunoRepository.findById(avaliacaoDTO.getAlunoId()).get();
		fisica.setAluno(aluno);
		fisica.setAltura(avaliacaoDTO.getAltura());
		fisica.setPeso(avaliacaoDTO.getPeso());
		var entity = DozerConverter.parseObject(fisica, AvaliacaoFisica.class);
		var vo = DozerConverter.parseObject(avaliacaoFisicaRepository.save(entity), AvaliacaoFisicaVO.class);
		return vo;
	}

	@Override
	public AvaliacaoFisicaVO update(Long id, AvaliacaoFisicaUpdateDTO avaliacaoUpdateDTO) {
		Optional<AvaliacaoFisica> av = avaliacaoFisicaRepository.findById(id);
		if (av.isPresent()) {
			av.get().setAltura(avaliacaoUpdateDTO.getAltura() != null ? avaliacaoUpdateDTO.getAltura() : av.get().getAltura());
			av.get().setPeso(avaliacaoUpdateDTO.getPeso() != null ? avaliacaoUpdateDTO.getPeso() : av.get().getPeso());
			var vo = DozerConverter.parseObject(avaliacaoFisicaRepository.save(av.get()), AvaliacaoFisicaVO.class);
			return vo;
		}
		return null;
	}

	@Override
	public AvaliacaoFisicaVO get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvaliacaoFisicaVO> getAll() {
		return DozerConverter.parseListObjects(avaliacaoFisicaRepository.findAll(), AvaliacaoFisicaVO.class);
	}

	@Override
	public boolean delete(Long id) {
		Optional<AvaliacaoFisica> fisica = avaliacaoFisicaRepository.findById(id);
		if(fisica.isPresent()) {
			avaliacaoFisicaRepository.delete(fisica.get());
			return true;
		}
		return false;
	}
	
	

}
