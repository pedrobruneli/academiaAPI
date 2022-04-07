package com.bruneli.academia.services;

import java.util.List;

import com.bruneli.academia.entities.Aluno;
import com.bruneli.academia.entities.AvaliacaoFisica;
import com.bruneli.academia.entities.dto.AlunoDTO;
import com.bruneli.academia.entities.dto.AlunoUpdateDTO;

public interface AlunoService {
	
	Aluno create(AlunoDTO dto);
	
	Aluno get(Long id);
	
	List<Aluno> getAll(String dataNascimento);

	Aluno update(Long id, AlunoUpdateDTO updatedto);
	
	boolean delete(Long id);
	
	List<AvaliacaoFisica> getAllAvaliacaoFisicasID(Long id);

	
}
