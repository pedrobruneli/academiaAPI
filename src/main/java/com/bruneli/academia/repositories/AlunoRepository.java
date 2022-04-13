package com.bruneli.academia.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruneli.academia.data.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	 List<Aluno> findByDataNascimento(LocalDate dataDeNascimento);
	

}
