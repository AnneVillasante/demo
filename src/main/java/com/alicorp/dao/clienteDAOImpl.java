package com.alicorp.dao;
import java.sql.*;
import java.util.*;
import com.alicorp.util.conexionDB;
import com.alicorp.model.cliente;
public class clienteDAOImpl implements clienteDAO {
    @Override
    public void registrar(cliente c) {
        String sql = "INSERT INTO cliente (idcliente, nombre, ruc, direccion, email) VALUES (?,?,?,?,?)";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, c.getIdcliente());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getRuc());
            ps.setString(4, c.getDireccion());
            ps.setString(5, c.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public List<cliente> listar() {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clientes.add(new cliente(
                    rs.getInt("idcliente"),
                    rs.getString("nombre"),
                    rs.getString("ruc"),
                    rs.getString("direccion"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return clientes;
    }
}
