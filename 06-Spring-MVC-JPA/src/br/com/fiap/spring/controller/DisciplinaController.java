package br.com.fiap.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.DisciplinaDAO;
import br.com.fiap.spring.model.Disciplina;

@Controller
@RequestMapping("disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaDAO dao;

	@GetMapping("cadastrar")
	public String cadastrar(Disciplina disciplina) {
		return "disciplina/cadastro"; //pasta + jsp
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public String cadastrar(@Valid Disciplina disciplina, BindingResult result, RedirectAttributes r) {
		if(result.hasErrors()) {
			return cadastrar(disciplina);
		}
		dao.cadastrar(disciplina);
		r.addFlashAttribute("msg", "Cadastro!");
		return "redirect:/disciplina/cadastrar"; //url
	}
}
