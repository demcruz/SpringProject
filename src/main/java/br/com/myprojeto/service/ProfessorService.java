package br.com.myprojeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.myprojeto.domain.Professor;
import br.com.myprojeto.repository.ProfessorRepository;

@Service
public class ProfessorService {

	
	@Autowired
	ProfessorRepository repoProfessor;
	
	public List<Professor> buscarTodosProfessores(){
		return repoProfessor.findAll();
	}
	
	public Professor salvar (Professor professor) {
		return repoProfessor.save(professor);
	}
}
