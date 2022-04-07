package com.bruneli.academia.entities.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDTO {
	
	@NotNull(message = "Preencha o campo corretamente.")
	@Positive(message = "O ID precisa ser um numero positivo.")
	private Long aluno_id;

}
