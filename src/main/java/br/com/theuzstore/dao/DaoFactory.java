package br.com.theuzstore.dao;

import br.com.theuzstore.dao.impl.ClienteDaoImpl;
import br.com.theuzstore.dao.impl.CompraDaoImpl;

public class DaoFactory {
    public static ClienteDao createInstanceCliente(){
        return new ClienteDaoImpl();
    }

    public static CompraDao createInstanceCompra(){
        return new CompraDaoImpl();
    }
}
