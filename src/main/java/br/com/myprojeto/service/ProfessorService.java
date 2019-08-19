package br.com.myprojeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.myprojeto.domain.Professor;
import br.com.myprojeto.repository.ProfessorRepository;
import javassist.tools.rmi.ObjectNotFoundException;

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
	
	public Professor buscarporId(Integer id) throws ObjectNotFoundException{
		Optional<Professor> professor = repoProfessor.findById(id);
		return professor.orElseThrow(() -> new ObjectNotFoundException("Professor não Encontrado. Id:" + id));
	}
	
	public Professor salvarAlteracao(Professor professorAlterado) throws ObjectNotFoundException{
		Professor professor = buscarporId(professorAlterado.getId());
		professor.setId(professorAlterado.getId());
		professor.setNome(professorAlterado.getNome());
		return salvar(professor);
	}
	
}
 