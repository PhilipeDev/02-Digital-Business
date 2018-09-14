package br.com.fiap.jpa.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import br.com.fiap.jpa.dao.JogadorDAO;
import br.com.fiap.jpa.model.Jogador;

@Repository
public class JogadorDAOImpl 
		extends GenericDAOImpl<Jogador, Integer> implements JogadorDAO{

	
	@Override
	public List<Jogador> buscarPorNome(String nome) {
		// FROM (Nome da classe)
		return em.createQuery("from Jogador j where upper(j.nome) like  upper(:churros)",Jogador.class)
		.setParameter("churros", "%"+nome+"%").getResultList();
	}

	
}