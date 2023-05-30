package br.com.theuzstore.dao.impl;

import br.com.theuzstore.dao.CompraDao;
import br.com.theuzstore.model.entities.Cliente;
import br.com.theuzstore.model.entities.Compra;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CompraDaoImpl implements CompraDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(Compra compra) {

    }

    @Override
    public void update(Compra compra) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Compra findById(Integer id) {
        return null;
    }

    @Override
    public List<Compra> findByCliente(Cliente cliente) {
        return null;
    }

    @Override
    public List<Compra> findAll() {
        return null;
    }
}
