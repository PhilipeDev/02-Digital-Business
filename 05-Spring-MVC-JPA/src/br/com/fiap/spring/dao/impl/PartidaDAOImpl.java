package br.com.fiap.spring.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring.dao.PartidaDAO;
import br.com.fiap.spring.model.Partida;

@Repository
public class PartidaDAOImpl extends GenericDAOImpl<Partida, Integer> implements PartidaDAO{

	@Override
	public List<Partida> buscarPorTime(String time) {
		// TODO Auto-generated method stub
		return em.createQuery("from Partida p where "
				+ "upper(p.timeA) like upper(:churros) or "
				+ "upper(p.timeB) like upper(:churros)", Partida.class)
				.setParameter("churros", "%"+time+"%").getResultList();
	}

	@Override
	public void realizar(int codigo, int golsA, int golsB) {
		Partida partida = buscar(codigo);
		partida.setGolsTimeA(golsA);
		partida.setGolsTimeB(golsB);
		partida.setRealizado(true);
		atualizar(partida);
	}
}
