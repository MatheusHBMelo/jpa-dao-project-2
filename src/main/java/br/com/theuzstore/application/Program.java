package br.com.theuzstore.application;

import br.com.theuzstore.dao.ClienteDao;
import br.com.theuzstore.dao.DaoFactory;
import br.com.theuzstore.model.entities.Cliente;

import java.util.List;

public class Program {
    public static void main(String[] args) {
        ClienteDao cd = DaoFactory.createInstanceCliente();

        // FindAll
        List<Cliente> clientes = cd.findAll();
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        // Insert
        Cliente cliente1 = new Cliente(null, "Maria Luiza", "Isa", "luiza@email.com", "15243");
        cd.insert(cliente1);

        // FindById
        Cliente cliente2 = cd.findById(3);
        System.out.println(cliente2);

        // Update
        Cliente cliente3 = new Cliente(1, null, null, null, "33335");
        cd.update(cliente3);

        //Delete
        cd.delete(5);
    }
}
