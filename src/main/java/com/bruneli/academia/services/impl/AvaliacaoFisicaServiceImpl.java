package com.bruneli.academia.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruneli.academia.entities.Aluno;
import com.bruneli.academia.entities.AvaliacaoFisica;
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
	public AvaliacaoFisica create(AvaliacaoFisicaDTO avaliacaoDTO) {
		AvaliacaoFisica fisica = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(avaliacaoDTO.getAlunoId()).get();
		fisica.setAluno(aluno);
		fisica.setAltura(avaliacaoDTO.getAltura());
		fisica.setPeso(avaliacaoDTO.getPeso());
		
		return avaliacaoFisicaRepository.save(fisica);
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO avaliacaoUpdateDTO) {
		Optional<AvaliacaoFisica> av = avaliacaoFisicaRepository.findById(id);
		if (av.isPresent()) {
			av.get().setAltura(avaliacaoUpdateDTO.getAltura() != null ? avaliacaoUpdateDTO.getAltura() : av.get().getAltura());
			av.get().setPeso(avaliacaoUpdateDTO.getPeso() != null ? avaliacaoUpdateDTO.getPeso() : av.get().getPeso());
			return avaliacaoFisicaRepository.save(av.get());
		}
		return null;
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		return avaliacaoFisicaRepository.findAll();
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
