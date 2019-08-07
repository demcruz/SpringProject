package br.com.myprojeto.inicializacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.myprojeto.domain.Aluno;
import br.com.myprojeto.domain.Professor;
import br.com.myprojeto.service.AlunoService;
import br.com.myprojeto.service.ProfessorService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	ProfessorService professorService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		alunoService.salvar(aluno1);

		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		alunoService.salvar(aluno2);

		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		alunoService.salvar(aluno3);
		
		
		Professor professor1 = new Professor();
		professor1.setNome("Estruc");
		professorService.salvar(professor1);
		
		Professor professor2 = new Professor();
		professor2.setNome("Johonny");
		professorService.salvar(professor2);
		

		Professor professor3 = new Professor();
		professor3.setNome("Raul");
		professorService.salvar(professor3);
		
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		
		
		for (Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());
		}
		
		List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		for(Professor professor: listaProfessores) {
			System.out.println(professor.getNome());
		}
	}

}
