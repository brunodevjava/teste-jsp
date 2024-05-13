package br.com.sinerji.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import br.com.sinerji.model.Endereco;
import br.com.sinerji.service.EnderecoService;

@RunWith(MockitoJUnitRunner.class)
public class crudEndereco {

    @InjectMocks
    private EnderecoService enderecoService;

    @Mock
    private DAO<Endereco> dao;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSalvarEndereco() {
        Endereco endereco = new Endereco();
        endereco.setRua("Euclides da Cunha");
        endereco.setCidade("Bilac");
        endereco.setEstado("SP");
        endereco.setComplemento("Complemento Teste");
        endereco.setCep("16210000");
        endereco.setNumero("450");
        endereco.setPessoaId(1L);

        enderecoService.salvar(endereco);

        // Verifica se o método salvar foi chamado no DAO
        Mockito.verify(dao).salvar(endereco);
    }

    @Test
    public void testRemoverEndereco() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);

        enderecoService.remover(endereco);

        // Verifica se o método remover foi chamado no DAO
        Mockito.verify(dao).remover(Endereco.class, endereco.getId());
    }

    @Test
    public void testTodosOsEnderecos() {
        // Simula uma lista de endereços retornada pelo DAO
        List<Endereco> enderecos = new ArrayList<>();
        enderecos.add(new Endereco());
        enderecos.add(new Endereco());

        Mockito.when(dao.buscarTodos("select e from Endereco e", Endereco.class)).thenReturn(enderecos);

        List<Endereco> resultado = enderecoService.todosOsEnderecos();

        // Verifica se a lista retornada não está vazia e possui o mesmo tamanho da lista simulada
        assertNotNull(resultado);
        assertEquals(enderecos.size(), resultado.size());
    }

    @Test
    public void testBuscarEnderecoPorId() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);

        Mockito.when(dao.buscarPorId(Endereco.class, 1L)).thenReturn(endereco);

        Endereco resultado = enderecoService.buscarEnderecoId(1L);

        // Verifica se o endereço retornado possui o mesmo ID
        assertNotNull(resultado);
        assertEquals(endereco.getId(), resultado.getId());
    }


}
