package com.bruneli.academia.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruneli.academia.entities.Matricula;
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
	public Matricula create(MatriculaDTO matriculaDTO) {
		Matricula matricula = new Matricula();
		matricula.setDataMatricula(LocalDateTime.now());
		matricula.setAluno(alunoRepository.findById(matriculaDTO.getAluno_id()).get());
		
		return matriculaRepository.save(matricula);
	}

	@Override
	public Matricula get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matricula> getAllByBairro(String bairro) {
		if(bairro != null) return matriculaRepository.findByAlunoBairro(bairro);
		return matriculaRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
