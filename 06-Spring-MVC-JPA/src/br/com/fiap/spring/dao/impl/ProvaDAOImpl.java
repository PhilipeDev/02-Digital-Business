package br.com.fiap.spring.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring.dao.ProvaDAO;
import br.com.fiap.spring.model.Prova;

@Repository
public class ProvaDAOImpl extends GenericDAOImpl<Prova, Integer> implements ProvaDAO{

}
