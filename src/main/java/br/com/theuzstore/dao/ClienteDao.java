package br.com.theuzstore.dao;

import br.com.theuzstore.model.entities.Cliente;

import java.util.List;

public interface ClienteDao {
    void insert(Cliente cliente);

    void update(Cliente cliente);

    void delete(Integer id);

    Cliente findById(Integer id);

    List<Cliente> findAll();
}
