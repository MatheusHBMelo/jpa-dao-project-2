package br.com.theuzstore.dao;

import br.com.theuzstore.model.entities.Cliente;
import br.com.theuzstore.model.entities.Compra;

import java.util.List;

public interface CompraDao {
    void insert(Compra compra);

    void update(Compra compra);

    void delete(Integer id);

    Compra findById(Integer id);

    List<Compra> findByCliente(Cliente cliente);

    List<Compra> findAll();
}
