package com.bruneli.academia.data.vo;

import java.time.LocalDateTime;
import java.util.Objects;

import com.bruneli.academia.data.entities.Aluno;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaVO {

	private Long id;
	
	private Aluno aluno;
	
	private LocalDateTime dataAvaliacao = LocalDateTime.now();

	private Double peso;
	
	private Double altura;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AvaliacaoFisicaVO other = (AvaliacaoFisicaVO) obj;
		return Objects.equals(altura, other.altura) && Objects.equals(aluno, other.aluno)
				&& Objects.equals(dataAvaliacao, other.dataAvaliacao) && Objects.equals(id, other.id)
				&& Objects.equals(peso, other.peso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, aluno, dataAvaliacao, id, peso);
	}
	

	
	


}
