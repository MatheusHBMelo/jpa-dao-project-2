package br.com.theuzstore.dao.impl;

import br.com.theuzstore.dao.ClienteDao;
import br.com.theuzstore.exceptions.ClienteNotFoundException;
import br.com.theuzstore.exceptions.ForeignKeyConstraintException;
import br.com.theuzstore.exceptions.NullArgumentException;
import br.com.theuzstore.model.entities.Cliente;

import javax.persistence.*;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
    private EntityManager entityManager;

    public ClienteDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        entityManager = emf.createEntityManager();
    }

    @Override
    public void insert(Cliente cliente) {
        if (cliente == null) {
            throw new NullArgumentException("[Erro ao inserir] O objeto cliente não pode ser nulo.");
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void update(Cliente cliente) {
        if (cliente == null) {
            throw new NullArgumentException("[Erro ao atualizar] O Objeto cliente não pode ser nulo.");
        }
        try {
            Cliente clientePersistido = entityManager.find(Cliente.class, cliente.getId());

            if (clientePersistido == null) {
                throw new ClienteNotFoundException("[Erro ao atualizar] O cliente especificado não existe no banco de dados.");
            }

            if (cliente.getNome() == null) {
                cliente.setNome(clientePersistido.getNome());
            }

            if (cliente.getLogin() == null) {
                cliente.setLogin(clientePersistido.getLogin());
            }

            if (cliente.getEmail() == null) {
                cliente.setEmail(clientePersistido.getEmail());
            }

            if (cliente.getSenha() == null) {
                cliente.setSenha(clientePersistido.getSenha());
            }

            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new NullArgumentException("[Erro ao excluir] O Id especificado não pode ser nulo.");
        }

        try {
            Cliente clientePersistido = entityManager.find(Cliente.class, id);
            if (clientePersistido == null) {
                throw new ClienteNotFoundException("[Erro ao excluir] O cliente especificado não existe no banco de dados.");
            }

            entityManager.getTransaction().begin();
            entityManager.remove(clientePersistido);
            entityManager.getTransaction().commit();
        } catch (ForeignKeyConstraintException fk) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw fk;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Cliente findById(Integer id) {
        if (id == null) {
            throw new NullArgumentException("[Erro ao buscar] O Id não pode ser nulo.");
        }

        Cliente clientePersistido = entityManager.find(Cliente.class, id);
        if (clientePersistido == null) {
            throw new ClienteNotFoundException("[Erro ao buscar] O cliente buscado não existe no banco de dados.");
        }

        return clientePersistido;
    }

    @Override
    public List<Cliente> findAll() {
        TypedQuery<Cliente> query = entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> clientes = query.getResultList();
        if (clientes.isEmpty()) {
            throw new NoResultException("[Erro ao buscar] Não existem clientes registrados.");
        }

        return clientes;
    }
}
