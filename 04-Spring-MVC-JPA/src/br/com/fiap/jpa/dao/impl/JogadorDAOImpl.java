package br.com.fiap.jpa.dao.impl;

import org.springframework.stereotype.Repository;
import br.com.fiap.jpa.dao.JogadorDAO;
import br.com.fiap.jpa.model.Jogador;

@Repository
public class JogadorDAOImpl 
		extends GenericDAOImpl<Jogador, Integer> implements JogadorDAO{
	
}