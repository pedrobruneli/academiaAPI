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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bruneli.academia.data.entities.AvaliacaoFisica;
import com.bruneli.academia.data.vo.AlunoVO;
import com.bruneli.academia.entities.dto.AlunoDTO;
import com.bruneli.academia.entities.dto.AlunoUpdateDTO;
import com.bruneli.academia.services.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoServiceImpl service;

	@GetMapping
	public List<AlunoVO> getAll(@RequestParam(value = "dataNascimento", required = false) String dataNascimento) {
		return service.getAll(dataNascimento);
	}

	@GetMapping(value = "/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvalicaoesFisica(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicasID(id);
	}

	@PostMapping() 	
	public AlunoVO create(@Valid @RequestBody AlunoDTO alunoDTO) {
		return service.create(alunoDTO);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<AlunoVO> delete(@PathVariable Long id) {
		return (service.delete(id) ? new ResponseEntity<AlunoVO>(HttpStatus.ACCEPTED) : new ResponseEntity<AlunoVO>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoVO> update(@PathVariable Long id, @Valid @RequestBody AlunoUpdateDTO alunoDTO) {
		AlunoVO al = service.update(id, alunoDTO);
		if(al != null) return new ResponseEntity<AlunoVO>(HttpStatus.ACCEPTED);
		return new ResponseEntity<AlunoVO>(HttpStatus.NOT_FOUND);
	}
	

}
