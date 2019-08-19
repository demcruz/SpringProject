package br.com.myprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.myprojeto.domain.Professor;
import br.com.myprojeto.service.ProfessorService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@GetMapping("/listarProfessores")
	public ModelAndView listarTodosProfessores() {
		ModelAndView mv = new ModelAndView("professor/paginaListaProfessores");
		mv.addObject("professores", professorService.buscarTodosProfessores());
		return mv;
	}
	
	@GetMapping("/cadastrar")
	private ModelAndView cadastrarProfessor() {
		ModelAndView mv = new ModelAndView("professor/cadastraProfessor");
		mv.addObject("professor", new Professor());
		return mv;
		
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProfessor(Professor professor) {
		professorService.salvar(professor);
		return listarTodosProfessores();
	}
	
	
	@GetMapping ("/alterar/{id}")
	public ModelAndView alterarProfessor(@PathVariable("id")Integer idProfessor) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("aluno/alteraProfessor");
		mv.addObject("professor", professorService.buscarporId(idProfessor));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Professor professorAlterado) throws ObjectNotFoundException{
		professorService.salvarAlteracao(professorAlterado);
		return listarTodosProfessores();
	}
	
	
	

}
