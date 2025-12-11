package com.alicorp.dao;

import com.alicorp.model.usuario;

public interface usuarioDAO {
    usuario login(String username, String password);
}