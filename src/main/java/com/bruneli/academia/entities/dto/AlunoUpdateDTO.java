package com.bruneli.academia.entities.dto;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AlunoUpdateDTO {
	
	@Size(min = 2, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;
	
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String bairro;
	
	@Past(message = "Data: '${validatedValue}' é invalida.")
	private LocalDate dataNascimento;

}
