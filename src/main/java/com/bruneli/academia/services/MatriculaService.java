package com.bruneli.academia.services;

import java.util.List;

import com.bruneli.academia.entities.Matricula;
import com.bruneli.academia.entities.dto.MatriculaDTO;

public interface MatriculaService {
	
	Matricula create(MatriculaDTO matriculaDTO);
	
	Matricula get(Long id);
	
	List<Matricula> getAllByBairro(String bairro);
	
	void delete(Long id);

}
