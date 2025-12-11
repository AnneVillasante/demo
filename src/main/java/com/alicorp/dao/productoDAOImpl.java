package com.alicorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alicorp.model.producto;
import com.alicorp.util.conexionDB;

public class productoDAOImpl implements productoDAO {

    @Override
    public producto obtenerPorId(int id) {
        producto p = null;
        String sql = "SELECT * FROM producto WHERE idproducto = ?";
        try (Connection con = conexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new producto(
                    rs.getInt("idproducto"),
                    rs.getString("nombre"),
                    rs.getDouble("precio"),
                    rs.getInt("stock")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return p;
    }

    @Override
    public void actualizarStock(int idproducto, int cantidadVendida) throws Exception {
        String sql = "UPDATE producto SET stock = stock - ? WHERE idproducto = ?";
        try (Connection con = conexionDB.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, cantidadVendida);
            ps.setInt(2, idproducto);

            ps.executeUpdate();
        }
    }
    
    @Override
    public List<producto> listarTodos() {
        // Lógica para obtener todos los productos        
        return new ArrayList<>(); 
    }
}
