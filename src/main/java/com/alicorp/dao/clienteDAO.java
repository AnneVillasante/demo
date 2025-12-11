package com.alicorp.dao;
import java.util.List;

import com.alicorp.model.cliente;

public interface clienteDAO {
    void registrar(cliente c);
    List<cliente> listar();
    void actualizar(cliente c);
    void eliminar(cliente c);
    cliente obtenerPorId(int id);
    List<cliente> buscarPorRuc(String ruc);
    List<cliente> buscarPorNombre(String nombre);
    List<cliente> buscarPorDireccion(String direccion);
    List<cliente> buscarPorEmail(String email);
}
