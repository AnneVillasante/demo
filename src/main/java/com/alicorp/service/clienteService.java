package com.alicorp.service;
import com.alicorp.dao.clienteDAO;
import com.alicorp.dao.clienteDAOImpl;
import com.alicorp.model.cliente;

public class clienteService {
    private clienteDAO dao = new clienteDAOImpl();
    public void registrarcliente(cliente c) throws Exception {
        if(c.getRuc().length() != 11) {
            throw new Exception("El RUC debe tener 11 dígitos.");
        }
           
        dao.registrar(c);
    }
}
