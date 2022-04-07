package com.bruneli.academia.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_aluno")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(unique = true, nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private LocalDate dataNascimento;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno", fetch = FetchType.LAZY)
	@Cascade(value = {org.hibernate.annotations.CascadeType.REMOVE, org.hibernate.annotations.CascadeType.PERSIST})
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
	
}	
