package com.bruneli.academia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bruneli.academia.data.vo.MatriculaVO;
import com.bruneli.academia.entities.dto.MatriculaDTO;
import com.bruneli.academia.services.impl.MatriculaServiceImpl;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	private MatriculaServiceImpl service;
	
	@PostMapping
	public MatriculaVO create(@Valid @RequestBody MatriculaDTO dto) {
		return service.create(dto);
	}
	
	@GetMapping
	public List<MatriculaVO> getAll(@RequestParam(value = "bairro",required = false) String bairro) {
		return service.getAllByBairro(bairro);
	}

}
