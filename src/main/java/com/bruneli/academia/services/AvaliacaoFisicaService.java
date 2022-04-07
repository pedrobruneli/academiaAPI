package com.bruneli.academia.services;

import java.util.List;

import com.bruneli.academia.entities.AvaliacaoFisica;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaDTO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaUpdateDTO;

public interface AvaliacaoFisicaService {
	
	AvaliacaoFisica create(AvaliacaoFisicaDTO avaliacaoDTO);
	
	AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateDTO avaliacaoUpdateDTO);
	
	AvaliacaoFisica get(Long id);
	
	List<AvaliacaoFisica> getAll();
	
	boolean delete(Long id);

}
