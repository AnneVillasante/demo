package com.alicorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alicorp.model.usuario;
import com.alicorp.util.conexionDB;

public class usuarioDAOImpl implements usuarioDAO {

    @Override
    public usuario login(String username, String password) {
        usuario u = null;
        // Corrección: Tabla Usuario, columnas nombre y clave según database.sql
        String sql = "SELECT * FROM Usuario WHERE nombre = ? AND clave = ?";
        
        try (Connection con = conexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new usuario(
                    rs.getInt("idUsuario"),
                    rs.getString("nombre"),
                    rs.getString("clave"),
                    rs.getString("rol")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
}