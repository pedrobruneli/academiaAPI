package com.bruneli.academia.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruneli.academia.data.entities.AvaliacaoFisica;
import com.bruneli.academia.data.vo.AvaliacaoFisicaVO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaDTO;
import com.bruneli.academia.entities.dto.AvaliacaoFisicaUpdateDTO;
import com.bruneli.academia.services.impl.AvaliacaoFisicaServiceImpl;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaServiceImpl service;

	@PostMapping
	public AvaliacaoFisicaVO create(@Valid @RequestBody AvaliacaoFisicaDTO dto) {
		return service.create(dto);
	}

	@GetMapping
	public List<AvaliacaoFisicaVO> getAll() {
		return service.getAll();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisica> delete(@PathVariable Long id) {
		return (service.delete(id) ? new ResponseEntity<AvaliacaoFisica>(HttpStatus.OK) : new ResponseEntity<AvaliacaoFisica>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoFisicaVO> update(@PathVariable Long id, @Valid @RequestBody AvaliacaoFisicaUpdateDTO dto) {
		AvaliacaoFisicaVO av = service.update(id, dto);
		if(av != null) return new ResponseEntity<AvaliacaoFisicaVO>(HttpStatus.ACCEPTED);
		return new ResponseEntity<AvaliacaoFisicaVO>(HttpStatus.NOT_FOUND);
	}

}
