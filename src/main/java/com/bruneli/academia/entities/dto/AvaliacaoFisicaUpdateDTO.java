package com.bruneli.academia.entities.dto;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoFisicaUpdateDTO {
	
	@Positive(message = "O peso precisa ser um numero positivo.")
	private Double peso;
	
	@Positive(message = "A altura precisa ser um numero positivo.")
	private Double altura;

}
