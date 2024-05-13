package br.com.sinerji.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.sinerji.dao.DAO;
import br.com.sinerji.model.Endereco;
import br.com.sinerji.model.Pessoa;

public class EnderecoService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private DAO<Endereco> dao;
	
	public void salvar(Endereco p){
		dao.salvar(p);
	}
	public void salvarEnderecoPessoa(Endereco e, Pessoa p){
		dao.salvarEndereco(e,p);
	}

	public void remover(Endereco p){
		dao.remover(Endereco.class, p.getId());
	}
	
	public List<Endereco> todosOsEnderecos() {
		return dao.buscarTodos("select e from Endereco e",Endereco.class);
	}

	public Endereco buscarEnderecoId(Long id){
		return dao.buscarPorId(Endereco.class,id);
	}


}
