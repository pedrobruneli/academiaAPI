package com.bruneli.academia.entities.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaDTO {
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O id do aluno precisa ser um numero positivo.")
	private Long alunoId;
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O peso precisa ser um numero positivo.")
	private Double peso;
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "A altura precisa ser um numero positivo.")
	@DecimalMin(value = "150", message = "'${validatedValue}' precisa ser no minimo {value}.")
	private Double altura;
	

}
