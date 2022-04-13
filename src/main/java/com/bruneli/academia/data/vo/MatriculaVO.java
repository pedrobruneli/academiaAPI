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

public class MatriculaVO {
	
	private Long id;
	
	private Aluno aluno;
	
	private LocalDateTime dataMatricula;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaVO other = (MatriculaVO) obj;
		return Objects.equals(aluno, other.aluno) && Objects.equals(dataMatricula, other.dataMatricula)
				&& Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, dataMatricula, id);
	}
	
	

}
