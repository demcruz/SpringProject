package br.com.myprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.myprojeto.domain.Professor;
import br.com.myprojeto.service.ProfessorService;

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
	
	

}
