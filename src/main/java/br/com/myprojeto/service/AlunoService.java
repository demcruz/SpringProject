package br.com.myprojeto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.myprojeto.domain.Aluno;
import br.com.myprojeto.repository.AlunoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

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
	
	public Aluno buscarporId(Integer id) throws ObjectNotFoundException {
		Optional<Aluno> aluno = repoAluno.findById(id);
		return aluno.orElseThrow(() ->new  ObjectNotFoundException("Aluno não Encontrado. Id:" + id));
	}
	
	public Aluno salvarAlteracao(Aluno alunoAlterado) throws ObjectNotFoundException{
		Aluno aluno = buscarporId(alunoAlterado.getId());
		aluno.setId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		return salvar(aluno);
	}
	
	public void excluir (Integer id) {
		repoAluno.deleteById(id);
	}
	
	

}
