package com.bruneli.academia.converter.mocks;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bruneli.academia.data.entities.Aluno;
import com.bruneli.academia.data.entities.AvaliacaoFisica;
import com.bruneli.academia.data.vo.AlunoVO;

public class MockAluno {

	public Aluno mockEntity() {
		return mockEntity(0);
	}

	public AlunoVO mockVO() {
		return mockVO(0);
	}

	public List<Aluno> mockEntityList() {
		List<Aluno> alunos = new ArrayList<Aluno>();
		for (int i = 0; i < 14; i++) {
			alunos.add(mockEntity(i));
		}
		return alunos;
	}

	public List<AlunoVO> mockVOList() {
		List<AlunoVO> alunos = new ArrayList<AlunoVO>();
		for (int i = 0; i < 14; i++) {
			alunos.add(mockVO(i));
		}
		return alunos;
	}

	public Aluno mockEntity(Integer number) {
		Aluno aluno = new Aluno();
		aluno.setBairro("Bairro " + number);
		aluno.setCpf("CPF " + number);
		aluno.setDataNascimento(LocalDate.now().plusDays(number.longValue()));
		aluno.setNome("Nome " + number);
		aluno.setId(number.longValue());
		return aluno;
	}

	public AlunoVO mockVO(Integer number) {
		AlunoVO aluno = new AlunoVO();
		List<AvaliacaoFisica> fisic = new ArrayList<AvaliacaoFisica>(Arrays.asList(new AvaliacaoFisica()));

		aluno.setAvaliacoes(fisic);
		aluno.setBairro("Bairro " + number);
		aluno.setCpf("CPF " + number);
		aluno.setDataNascimento(LocalDate.now().plusDays(number.longValue()));
		aluno.setNome("Nome " + number);
		aluno.setId(number.longValue());
		return aluno;
	}

}
