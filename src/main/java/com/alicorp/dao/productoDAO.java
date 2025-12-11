package com.alicorp.dao;
import java.util.List;

import com.alicorp.model.producto;

public interface productoDAO {
    producto obtenerPorId(int id);
    void actualizarStock(int idproducto, int cantidadComprada) throws Exception;
    List<producto> listarTodos();
}
