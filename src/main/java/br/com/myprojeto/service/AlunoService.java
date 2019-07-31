package br.com.myprojeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.myprojeto.domain.Aluno;
import br.com.myprojeto.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository repoAluno;
	
	public List<Aluno> buscarTodosAlunos(){
		return repoAluno.findAll();
	}
	
	public Aluno salvar (Aluno aluno) {
		return repoAluno.save(aluno);
	}
	
	

}
