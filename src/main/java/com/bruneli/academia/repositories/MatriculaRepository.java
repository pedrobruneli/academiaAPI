package com.bruneli.academia.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bruneli.academia.entities.Aluno;
import com.bruneli.academia.entities.Matricula;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long>{
	
	List<Matricula> findByAlunoBairro(String bairro);
	
	List<Matricula> findByAluno(Aluno aluno);
 
}
