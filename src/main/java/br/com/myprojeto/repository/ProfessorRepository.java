package br.com.myprojeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.myprojeto.domain.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
	
	
}
