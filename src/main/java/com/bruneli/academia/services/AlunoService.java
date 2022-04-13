package com.bruneli.academia.services;

import java.util.List;

import com.bruneli.academia.data.entities.AvaliacaoFisica;
import com.bruneli.academia.data.vo.AlunoVO;
import com.bruneli.academia.entities.dto.AlunoDTO;
import com.bruneli.academia.entities.dto.AlunoUpdateDTO;

public interface AlunoService {
	
	AlunoVO create(AlunoDTO dto);
	
	AlunoVO get(Long id);
	
	List<AlunoVO> getAll(String dataNascimento);

	AlunoVO update(Long id, AlunoUpdateDTO updatedto);
	
	boolean delete(Long id);
	
	List<AvaliacaoFisica> getAllAvaliacaoFisicasID(Long id);

	
}
