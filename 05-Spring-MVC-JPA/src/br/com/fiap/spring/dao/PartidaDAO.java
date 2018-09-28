package br.com.fiap.spring.dao;

import java.util.List;

import br.com.fiap.spring.model.Partida;

public interface PartidaDAO extends GenericDAO<Partida,Integer>{

	List<Partida> buscarPorTime(String time);
	void realizar(int codigo, int golsA, int golsB);
}
