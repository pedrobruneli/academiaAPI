package com.bruneli.academia.entities.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoDTO {
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 2, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String nome;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@CPF(message = "'${validatedValue} é invalido.'")
	private String cpf;
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
	private String bairro;
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Past(message = "Data: '${validatedValue}' é invalida.")
	private LocalDate dataNascimento;

}