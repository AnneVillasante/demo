package com.alicorp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alicorp.model.cliente;
import com.alicorp.util.conexionDB;
public class clienteDAOImpl implements clienteDAO {
    @Override
    public void registrar(cliente c) {
        // Corrección: Tabla Cliente y se omite idcliente (es AUTO_INCREMENT)
        String sql = "INSERT INTO Cliente (nombre, ruc, direccion, email) VALUES (?,?,?,?)";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getRuc());
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public List<cliente> listar() {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
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
    @Override
    public void actualizar(cliente c) {
        String sql = "UPDATE Cliente SET nombre=?, ruc=?, direccion=?, email=? WHERE idcliente=?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, c.getNombre());
            ps.setString(2, c.getRuc());            
            ps.setString(3, c.getDireccion());
            ps.setString(4, c.getEmail());
            ps.setInt(5, c.getIdcliente());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public void eliminar(cliente c) {
        int idcliente = c.getIdcliente();
        String sql = "DELETE FROM Cliente WHERE idcliente=?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idcliente);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
    @Override
    public cliente obtenerPorId(int id) {
        cliente c = null;
        String sql = "SELECT * FROM Cliente WHERE idcliente=?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c = new cliente(
                    rs.getInt("idcliente"),
                    rs.getString("nombre"),
                    rs.getString("ruc"),
                    rs.getString("direccion"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return c;
    }
    @Override
    public List<cliente> buscarPorRuc(String ruc) {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE ruc LIKE ?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + ruc + "%");
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
    @Override
    public List<cliente> buscarPorNombre(String nombre) {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE nombre LIKE ?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
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
    @Override
    public List<cliente> buscarPorDireccion(String direccion) {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE direccion LIKE ?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + direccion + "%");
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
    @Override
    public List<cliente> buscarPorEmail(String email) {
        List<cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente WHERE email LIKE ?";
        try (Connection con = conexionDB.conectar(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + email + "%");
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
