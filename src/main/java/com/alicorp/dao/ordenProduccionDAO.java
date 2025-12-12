package com.alicorp.dao;

import java.sql.SQLException;

import com.alicorp.model.lote;
import com.alicorp.model.ordenProduccion;

public interface ordenProduccionDAO {

    void finalizarProduccionTransaccional(ordenProduccion orden, lote loteGenerado) throws SQLException;
    // Métodos para CRUD de ordenProduccion
    void crearOrden(ordenProduccion orden);
    ordenProduccion obtenerOrdenPorId(int idOrden);
    void actualizarOrden(ordenProduccion orden);
    void eliminarOrden(int idOrden);
}
