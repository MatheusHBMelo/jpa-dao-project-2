package br.com.theuzstore.dao.impl;

import br.com.theuzstore.dao.ClienteDao;
import br.com.theuzstore.model.entities.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Cliente cliente) {

    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Cliente findById(Integer id) {
        return null;
    }

    @Override
    public List<Cliente> findAll() {
        return null;
    }
}
