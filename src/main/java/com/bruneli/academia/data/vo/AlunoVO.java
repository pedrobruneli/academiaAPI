package com.bruneli.academia.data.vo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.bruneli.academia.data.entities.AvaliacaoFisica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoVO {

	private Long id;

	private String nome;
	
	private String cpf;
	
	private String bairro;
	
	@Override
	public int hashCode() {
		return Objects.hash(avaliacoes, bairro, cpf, dataNascimento, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AlunoVO other = (AlunoVO) obj;
		return Objects.equals(avaliacoes, other.avaliacoes) && Objects.equals(bairro, other.bairro)
				&& Objects.equals(cpf, other.cpf) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	private LocalDate dataNascimento;

	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
	
}	
