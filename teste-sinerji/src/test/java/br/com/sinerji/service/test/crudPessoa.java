package br.com.sinerji.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.sinerji.dao.DAO;
import br.com.sinerji.model.Pessoa;
import br.com.sinerji.service.PessoaService;

@RunWith(MockitoJUnitRunner.class)
public class crudPessoa {

    @InjectMocks
    private PessoaService pessoaService;

    @Mock
    private DAO<Pessoa> dao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Bruno Sversutti");
        pessoa.setEmail("sversuttibruno@gmail.com");
        pessoa.setCpf("46070952812");
        pessoa.setTelefone("(00) 1234-5678");
        pessoa.setDataNascimento(java.sql.Date.valueOf("2000-01-01"));
        pessoa.setDataCriacao(LocalDateTime.now());
        pessoa.setAtivo(true);
        pessoa.setGenero("Masculino");
        pessoa.setEstadoCivil("Solteiro");
        pessoa.setProfissao("Engenheiro");
        pessoa.setRg("123456789");

        pessoaService.salvar(pessoa);

        // Verifica se o método salvar foi chamado no DAO
        Mockito.verify(dao).salvar(pessoa);
    }

    @Test
    public void testRemoverPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);

        pessoaService.remover(pessoa);

        // Verifica se o método remover foi chamado no DAO
        Mockito.verify(dao).remover(Pessoa.class, pessoa.getId());
    }

    @Test
    public void testTodosAsPessoa() {
        // Simula uma lista de pessoas retornada pelo DAO
        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa());
        pessoas.add(new Pessoa());

        Mockito.when(dao.buscarTodos("select p from Pessoa p", Pessoa.class)).thenReturn(pessoas);

        List<Pessoa> resultado = pessoaService.todosAsPessoa();

        // Verifica se a lista retornada não está vazia e possui o mesmo tamanho da lista simulada
        assertNotNull(resultado);
        assertEquals(pessoas.size(), resultado.size());
    }

    @Test
    public void testBuscarPessoaPorId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);

        Mockito.when(dao.buscarPorId(Pessoa.class, 1L)).thenReturn(pessoa);

        Pessoa resultado = pessoaService.buscarPessoaId(1L);

        // Verifica se a pessoa retornada possui o mesmo ID
        assertNotNull(resultado);
        assertEquals(pessoa.getId(), resultado.getId());
    }
}
