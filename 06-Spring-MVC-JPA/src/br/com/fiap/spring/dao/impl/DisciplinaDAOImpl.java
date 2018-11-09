package br.com.fiap.spring.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.fiap.spring.dao.DisciplinaDAO;
import br.com.fiap.spring.model.Disciplina;

@Repository
public class DisciplinaDAOImpl extends GenericDAOImpl<Disciplina,Integer> implements DisciplinaDAO{
}
