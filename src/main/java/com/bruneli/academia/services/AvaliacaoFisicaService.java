package com.bruneli.academia.services;

import java.util.List;

import com.bruneli.academia.data.vo.AvaliacaoFisicaVO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaDTO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaUpdateDTO;

public interface AvaliacaoFisicaService {
	
	AvaliacaoFisicaVO create(AvaliacaoFisicaDTO avaliacaoDTO);
	
	AvaliacaoFisicaVO update(Long id, AvaliacaoFisicaUpdateDTO avaliacaoUpdateDTO);
	
	AvaliacaoFisicaVO get(Long id);
	
	List<AvaliacaoFisicaVO> getAll();
	
	boolean delete(Long id);

}
