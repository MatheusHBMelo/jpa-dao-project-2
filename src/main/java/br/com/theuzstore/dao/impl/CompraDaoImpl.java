package br.com.theuzstore.dao.impl;

import br.com.theuzstore.dao.CompraDao;
import br.com.theuzstore.exceptions.ClienteNotFoundException;
import br.com.theuzstore.exceptions.CompraNotFoundException;
import br.com.theuzstore.exceptions.ForeignKeyConstraintException;
import br.com.theuzstore.exceptions.NullArgumentException;
import br.com.theuzstore.model.entities.Cliente;
import br.com.theuzstore.model.entities.Compra;

import javax.persistence.*;
import java.util.List;

public class CompraDaoImpl implements CompraDao {
    private EntityManager entityManager;

    public CompraDaoImpl() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        entityManager = emf.createEntityManager();
    }

    @Override
    public void insert(Compra compra) {
        if (compra == null) {
            throw new NullArgumentException("[Erro ao inserir] O objeto compra não pode ser nulo.");
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(compra);
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
    public void update(Compra compra) {
        if (compra == null) {
            throw new NullArgumentException("[Erro ao atualizar] O Objeto cliente não pode ser nulo.");
        }

        try {
            Compra compraPersistida = entityManager.find(Compra.class, compra.getId());

            if (compraPersistida == null) {
                throw new CompraNotFoundException("[Erro ao atualizar] A compra especificada não existe no banco de dados.");
            }

            if (compra.getValor() == null) {
                compra.setValor(compraPersistida.getValor());
            }

            if (compra.getData() == null) {
                compra.setData(compraPersistida.getData());
            }

            if (compra.getObservacao() == null) {
                compra.setObservacao(compraPersistida.getObservacao());
            }

            if (compra.getCliente() == null) {
                compra.setCliente(compraPersistida.getCliente());
            }

            entityManager.getTransaction().begin();
            entityManager.merge(compra);
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
            Compra compraPersistida = entityManager.find(Compra.class, id);

            if (compraPersistida == null) {
                throw new CompraNotFoundException("[Erro ao excluir] A compra especificada não existe no banco de dados.");
            }

            entityManager.getTransaction().begin();
            entityManager.remove(compraPersistida);
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
    public Compra findById(Integer id) {
        if (id == null) {
            throw new NullArgumentException("[Erro ao buscar] O Id não pode ser nulo.");
        }

        Compra compraPersistida = entityManager.find(Compra.class, id);
        if (compraPersistida == null) {
            throw new CompraNotFoundException("[Erro ao buscar] A compra buscada não existe no banco de dados.");
        }

        return compraPersistida;
    }

    @Override
    public List<Compra> findByCliente(Cliente cliente) {
        if (cliente == null) {
            throw new NullArgumentException("[Erro ao buscar] O Objeto cliente não pode ser nulo.");
        }

        TypedQuery<Compra> query = entityManager.createQuery("SELECT c FROM Compra c WHERE cliente_id_cliente = :id", Compra.class);
        query.setParameter("id", cliente.getId());
        List<Compra> compras = query.getResultList();
        if (compras.isEmpty()){
            throw new NoResultException("[Erro ao buscar] Não existem compras registradas.");
        }

        return compras;
    }

    @Override
    public List<Compra> findAll() {
        TypedQuery<Compra> query = entityManager.createQuery("SELECT c FROM Compra c", Compra.class);
        List<Compra> compras = query.getResultList();
        if (compras.isEmpty()) {
            throw new NoResultException("[Erro ao buscar] Não existem compras registradas.");
        }

        return compras;
    }
}
