package br.com.sinerji.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.sinerji.dao.DAO;
import br.com.sinerji.model.Pessoa;

public class PessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Pessoa> dao;
	
	public void salvar(Pessoa p) {
		dao.salvar(p);
	}

	public void remover(Pessoa p) {
		dao.remover(Pessoa.class, p.getId());
	}
	
	public List<Pessoa> todosAsPessoa(){
		return dao.buscarTodos("select p from Pessoa p",Pessoa.class);
	}
	
	public Pessoa buscarPessoaId(Long id){
		return dao.buscarPorId(Pessoa.class,id);
	}


}
