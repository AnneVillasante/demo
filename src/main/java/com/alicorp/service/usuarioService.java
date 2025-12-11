package com.alicorp.service;

import com.alicorp.dao.usuarioDAO;
import com.alicorp.dao.usuarioDAOImpl;
import com.alicorp.model.usuario;

public class usuarioService {
    
    private usuarioDAO usuarioDAO = new usuarioDAOImpl();

    public usuario autenticar(String username, String password) throws Exception {
        usuario user = usuarioDAO.login(username, password);
        if (user == null) {
            throw new Exception("Usuario o contraseña incorrectos.");
        }
        return user;
    }
}