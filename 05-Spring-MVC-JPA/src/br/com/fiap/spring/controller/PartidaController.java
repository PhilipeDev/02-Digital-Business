package br.com.fiap.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.jpa.exception.IdNotFoundException;
import br.com.fiap.spring.dao.PartidaDAO;
import br.com.fiap.spring.model.Partida;

@Controller
@RequestMapping("partida")
public class PartidaController {

	@Autowired
	private PartidaDAO dao;
	
	@Transactional
	@PostMapping("realizar")
	public String realizarPartida(int golsA, int golsB, int codigo, RedirectAttributes r) {
		dao.realizar(codigo, golsA, golsB);
		r.addFlashAttribute("msg", "Partida realizada");
		return "redirect:/partida/listar";
	}
	
	@GetMapping("buscar")
	public ModelAndView buscar(String nome) {
		return new ModelAndView("partida/lista").addObject("partidas",dao.buscarPorTime(nome));
	}
	
	@GetMapping("cadastrar")
	public String abrirForm(Partida partida) {
		return "partida/cadastro";
	}
	
	
	
	@Transactional
	@PostMapping("cadastrar")
	public String processarForm(Partida partida, RedirectAttributes r) {
		dao.cadastrar(partida);
		r.addFlashAttribute("msg","Partida cadastrada");
		return "redirect:/partida/cadastrar"; //URL
	}
	
	
	@GetMapping("listar")
	public ModelAndView abrirLista() {
		return new ModelAndView("partida/lista")
				.addObject("partidas",dao.listar());
	}
	


	@GetMapping("editar/{id}")
	public ModelAndView abrirEdicao(@PathVariable("id")int codigo) {
		return new ModelAndView("partida/edicao")
				.addObject("partida", dao.buscar(codigo));
	}
	
	@Transactional
	@PostMapping("editar")
	public String processarEdicao(Partida partida, RedirectAttributes r) {
		dao.atualizar(partida);
		r.addFlashAttribute("msg","Partida atualizada");
		return "redirect:/partida/listar";
	}
	
	@Transactional
	@PostMapping("excluir")
	public String processarExcluir(int codigo, RedirectAttributes r) {
		try {
			dao.remover(codigo);
			r.addFlashAttribute("msg", "Partida removida");
		} catch (IdNotFoundException e) {
			e.printStackTrace();
			r.addFlashAttribute("msg", "Erro ao remover");
		}
		return "redirect:/partida/listar";
	}
	
}
