package com.bruneli.academia.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruneli.academia.converter.DozerConverter;
import com.bruneli.academia.data.entities.Aluno;
import com.bruneli.academia.data.entities.Matricula;
import com.bruneli.academia.data.vo.MatriculaVO;
import com.bruneli.academia.entities.dto.MatriculaDTO;
import com.bruneli.academia.repositories.AlunoRepository;
import com.bruneli.academia.repositories.MatriculaRepository;
import com.bruneli.academia.services.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService{

	@Autowired
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Override
	public MatriculaVO create(MatriculaDTO matriculaDTO) {
		MatriculaVO matricula = new MatriculaVO();
		matricula.setDataMatricula(LocalDateTime.now());
		Aluno al = alunoRepository.findById(matriculaDTO.getAluno_id()).get();
		matricula.setAluno(al);
		var entity = DozerConverter.parseObject(matricula, Matricula.class);
		var vo = DozerConverter.parseObject(matriculaRepository.save(entity), MatriculaVO.class);
		return vo;
	}

	@Override
	public MatriculaVO get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MatriculaVO> getAllByBairro(String bairro) {
		if(bairro != null) return DozerConverter.parseListObjects(matriculaRepository.findByAlunoBairro(bairro), MatriculaVO.class);
		return DozerConverter.parseListObjects(matriculaRepository.findAll(), MatriculaVO.class);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
