package br.com.fiap.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.spring.dao.DisciplinaDAO;
import br.com.fiap.spring.dao.ProvaDAO;
import br.com.fiap.spring.model.Prova;
import br.com.fiap.spring.model.Tipo;

@Controller
@RequestMapping("prova")
public class ProvaController {

	@Autowired
	private ProvaDAO dao;
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	@GetMapping("listar")
	public ModelAndView listar() {
		return new ModelAndView("prova/lista").addObject("lista",dao.listar());
	}
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Prova prova) {
		return new ModelAndView("prova/cadastro").addObject("tipos",Tipo.values()).addObject("churros",disciplinaDAO.listar());
	}
	
	@Transactional
	@PostMapping("cadastrar")
	public ModelAndView cadastrar(@Valid Prova prova, BindingResult result, RedirectAttributes r) {
		if(result.hasErrors()) {
			return cadastrar(prova);
		}
		dao.cadastrar(prova);
		r.addFlashAttribute("msg","Prova cadastrada");
		return new ModelAndView("redirect:/prova/cadastrar");
	}
}
