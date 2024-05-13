package br.com.sinerji.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sinerji.model.Pessoa;
import br.com.sinerji.service.PessoaService;

@Named
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pessoa pessoa;

	@Inject
	private PessoaService service;

	private List<Pessoa> pessoas;

	private Boolean editando = false;

	@PostConstruct
	public void carregar() {
		pessoas = service.todosAsPessoa();
	}

	public void adicionar() {
	    try {
	        if (pessoa != null) {
	            if (editando) {
	                service.salvar(pessoa);
	                editando = false;
	            } else {
	                service.salvar(pessoa);
	            }
	            pessoa = new Pessoa();
	            carregar();
	        }
	    } catch (Exception e) {
	        System.out.println("ERROR ADD PESSOA " + e.getMessage());
	    }
	}

	public void onGeneroChange() {
	    // Se o gênero selecionado for "Outro", limpa o campo "outroGenero"
	    if ("Outro".equals(pessoa.getGenero())) {
	        pessoa.setGenero("");
	    }
	}

	public void editar(Pessoa pessoa) {
	    if (pessoa != null) {
	        this.pessoa = pessoa;
	        editando = true;
	    }
	}

	public void limpar() {
		this.pessoa = new Pessoa();
		editando = false;
	}

	public void excluir() {
		try {
			service.remover(pessoa);
			carregar();

		} catch (Exception e) {

			System.out.println("ERROR exclud PESSOA " + e.getMessage());
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public boolean isEditando() {
		return editando;
	}

}
