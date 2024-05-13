package br.com.sinerji.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sinerji.model.Endereco;
import br.com.sinerji.model.Pessoa;
import br.com.sinerji.service.EnderecoService;
import br.com.sinerji.service.PessoaService;
import br.com.sinerji.util.Message;
import br.com.sinerji.util.NegocioException;

@Named
@ViewScoped
public class EnderecoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Endereco endereco;


	@Inject
	private Pessoa pessoa;

	@Inject
	private EnderecoService service;

	@Inject
	private PessoaService servicePessoa;

	private List<Endereco> enderecos;

	private Boolean editando = false;

	private List<String> estados;
	private List<String> cidades;
	private String estadoSelecionado;
	private String cidadeSelecionada;
	private List<Pessoa> pessoas;
	private Pessoa pessoaSelecionada;

	@PostConstruct
	public void carregar() {
		enderecos = service.todosOsEnderecos();
		pessoas = servicePessoa.todosAsPessoa();

	}
	public String buscarPessoaPorId(Long id) {
		return servicePessoa.buscarPessoaId(id).getNome();
	}

	public void adicionar() {
	    try {
	        if (endereco != null) {
	            if (editando) {
	                service.salvar(endereco);
	                editando = false;
	            } else {
	                service.salvar(endereco);
	            }
	            endereco = new Endereco();
	            carregar();
	        }
	    } catch (Exception e) {
	        System.out.println("ERROR ADD ENDERECO: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
	public void editar(Endereco endereco) {
	    if (endereco != null) {
	        this.endereco = endereco;
	        editando = true;
	    }
	}

	public void limpar() {
		this.endereco = new Endereco();
		editando = false;
	}

	public void excluir() {
		try {
			service.remover(endereco);
			carregar();

		} catch (Exception e) {
			Message.erro(e.getMessage());
		}
	}



	// getters and setters

	public List<String> getEstados() {
		return estados;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public String getEstadoSelecionado() {
		return estadoSelecionado;
	}

	public void setEstadoSelecionado(String estadoSelecionado) {
		this.estadoSelecionado = estadoSelecionado;
	}

	public String getCidadeSelecionada() {
		return cidadeSelecionada;
	}

	public void setCidadeSelecionada(String cidadeSelecionada) {
		this.cidadeSelecionada = cidadeSelecionada;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public boolean isEditando() {
		return editando;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa getPessoaSelecionada() {
		return pessoaSelecionada;
	}

	public void setPessoaSelecionada(Pessoa pessoaSelecionada) {
		this.pessoaSelecionada = pessoaSelecionada;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
