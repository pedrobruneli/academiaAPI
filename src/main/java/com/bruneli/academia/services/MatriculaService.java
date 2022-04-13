package com.bruneli.academia.services;

import java.util.List;

import com.bruneli.academia.data.vo.MatriculaVO;
import com.bruneli.academia.entities.dto.MatriculaDTO;

public interface MatriculaService {
	
	MatriculaVO create(MatriculaDTO matriculaDTO);
	
	MatriculaVO get(Long id);
	
	List<MatriculaVO> getAllByBairro(String bairro);
	
	void delete(Long id);

}
