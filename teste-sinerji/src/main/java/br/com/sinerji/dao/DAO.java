package br.com.sinerji.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.sinerji.configuration.ConnectionFactory;
import br.com.sinerji.model.Base;
import br.com.sinerji.model.Endereco;
import br.com.sinerji.model.Pessoa;

public class DAO<T extends Base> implements Serializable {

    private static final long serialVersionUID = 1L;
    private static EntityManager manager;

    static {
        try {
            manager = ConnectionFactory.getEntityManager();
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize EntityManager", e);
        }
    }

    public T buscarPorId(Class<T> clazz, Long id) {
        return manager.find(clazz, id);
    }

    public void salvar(T t) {
        try {
            manager.getTransaction().begin();

            System.out.println("Pessoa edit "+t);
            if (t.getId() == null) {
                manager.persist(t);
            } else {
                manager.merge(t);
            }
            manager.getTransaction().commit();

        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }
    public void salvarEndereco(Endereco t, Pessoa p) {
        try {
            manager.getTransaction().begin();

            System.out.println("Endereço edit: " + t);
            System.out.println("Pessoa associada: " + p);

            if (t.getId() == null) {
                // Se o ID do endereço for nulo, persista o endereço e a pessoa associada a ele
                manager.persist(t);
                manager.persist(p); // Persista a pessoa associada ao endereço
            } else {
                // Se o ID do endereço não for nulo, faça o merge
                manager.merge(t);
                manager.persist(p); // Persista a pessoa associada ao endereço
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }

    public void remover(Class<T> clazz, Long id) {
        T t = buscarPorId(clazz, id);
        try {
            manager.getTransaction().begin();
            manager.remove(t);
            manager.getTransaction().commit();

        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            manager.getTransaction().rollback();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> buscarTodos(String jpql, Class<T> clazz) {
        Query query = manager.createQuery(jpql, clazz);
        return query.getResultList();
    }
}
