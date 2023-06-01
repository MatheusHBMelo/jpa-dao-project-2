package br.com.theuzstore.application;

import br.com.theuzstore.dao.ClienteDao;
import br.com.theuzstore.dao.CompraDao;
import br.com.theuzstore.dao.DaoFactory;
import br.com.theuzstore.model.entities.Cliente;
import br.com.theuzstore.model.entities.Compra;

import java.time.LocalDateTime;
import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        ClienteDao clienteDao = DaoFactory.createInstanceCliente();
        CompraDao compraDao = DaoFactory.createInstanceCompra();

        // Insert
        LocalDateTime data = LocalDateTime.of(2023, 6, 1, 5, 40);
        Cliente cliente1 = clienteDao.findById(1);
        Compra compra1 = new Compra(null, 200.00, data, "Foi comprado com Dinheiro", cliente1);
        compraDao.insert(compra1);

        // FindById
        Compra compra2 = compraDao.findById(3);
        System.out.println(compra2);

        // FindByCliente
        Cliente cliente2 = new Cliente(1, null, null, null, null);
        List<Compra> compras1 = compraDao.findByCliente(cliente2);
        for (Compra c1 : compras1) {
            System.out.println(c1);
        }

        // Update
        Compra compra3 = new Compra(1, 100.00, null, null, null);
        compraDao.update(compra3);

        // Delete
        compraDao.delete(1);

        // FindAll
        List<Compra> compras2 = compraDao.findAll();
        for (Compra c2 : compras2) {
            System.out.println(c2);
        }
    }
}
