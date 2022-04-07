package com.bruneli.academia.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruneli.academia.entities.Aluno;
import com.bruneli.academia.entities.AvaliacaoFisica;
import com.bruneli.academia.entities.Matricula;
import com.bruneli.academia.entities.dto.AlunoDTO;
import com.bruneli.academia.entities.dto.AlunoUpdateDTO;
import com.bruneli.academia.repositories.AlunoRepository;
import com.bruneli.academia.repositories.MatriculaRepository;
import com.bruneli.academia.services.AlunoService;

@Service
public class AlunoServiceImpl implements AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private MatriculaRepository mRepository;

	@Override
	public Aluno create(AlunoDTO dto) {
		Aluno aluno = new Aluno();

		aluno.setNome(dto.getNome());
		aluno.setCpf(dto.getCpf());
		aluno.setBairro(dto.getBairro());
		aluno.setDataNascimento(dto.getDataNascimento());

		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		return repository.getById(id);
	}

	@Override
	public List<Aluno> getAll(String dataNascimento) {
		if (dataNascimento != null) {
			LocalDate date = LocalDate.parse(dataNascimento);
			return repository.findByDataNascimento(date);
		}
		return repository.findAll();

	}

	@Override
	public Aluno update(Long id, AlunoUpdateDTO updatedto) {
		Optional<Aluno> al = repository.findById(id);
		if (al.isPresent()) {
			al.get().setBairro(updatedto.getBairro() != null ? updatedto.getBairro() : al.get().getBairro());
			al.get().setDataNascimento(updatedto.getDataNascimento() != null ? updatedto.getDataNascimento()
					: al.get().getDataNascimento());
			al.get().setNome(updatedto.getNome() != null ? updatedto.getNome() : al.get().getNome());
			return repository.save(al.get());
		}
		return null;
	}

	@Override
	public boolean delete(Long id) {
		Optional<Aluno> aluno = repository.findById(id);
		if (aluno.isPresent()) {
			for (Matricula m : mRepository.findByAluno(aluno.get())) {
				mRepository.deleteById(m.getId());
			}
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicasID(Long id) {
		return repository.findById(id).get().getAvaliacoes();
	}

}
