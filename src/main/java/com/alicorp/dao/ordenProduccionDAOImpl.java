package com.alicorp.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alicorp.model.lote;
import com.alicorp.model.ordenProduccion;
import com.alicorp.util.conexionDB;

public class ordenProduccionDAOImpl implements ordenProduccionDAO{
    public void finalizarProduccionTransaccional(ordenProduccion orden, lote loteGenerado) throws SQLException {
        Connection con = null;
        try {
            con = conexionDB.conectar();
            con.setAutoCommit(false); // INICIO DE TRANSACCIÓN

            // 1. Insertar la Orden de Producción PRIMERO (Lote depende de Orden)
            String sqlInsertOrden = "INSERT INTO OrdenProduccion (fechaInicio, idProductoObjetivo, cantidadObjetivo, estado) VALUES (NOW(), ?, ?, ?)";
            PreparedStatement psOrden = con.prepareStatement(sqlInsertOrden, Statement.RETURN_GENERATED_KEYS);
            psOrden.setInt(1, orden.getIdProductoObjetivo());
            psOrden.setInt(2, orden.getCantidadObjetivo());
            psOrden.setString(3, "Finalizada"); // Se asume finalizada al registrar el lote
            psOrden.executeUpdate();

            // Obtener ID de la Orden generada
            ResultSet rsOrdenKeys = psOrden.getGeneratedKeys();
            int idOrdenGenerado = 0;
            if (rsOrdenKeys.next()) {
                idOrdenGenerado = rsOrdenKeys.getInt(1);
            }

            // 2. Insertar el Lote (Vinculado a la Orden)
            String sqlInsertLote = "INSERT INTO Lote (codigo, fechaFabricacion, fechaVencimiento, estado, idOrden) VALUES (?, NOW(), ?, ?, ?)";
            PreparedStatement psLote = con.prepareStatement(sqlInsertLote);
            psLote.setString(1, loteGenerado.getCodigo());
            psLote.setDate(2, loteGenerado.getFechaVencimiento());
            psLote.setString(3, loteGenerado.getEstado());
            psLote.setInt(4, idOrdenGenerado); // FK correcta
            psLote.executeUpdate();

            // 3. Actualizar Stock del Producto (SUMAR) - Tabla Producto
            String sqlUpdateStock = "UPDATE Producto SET stock = stock + ? WHERE idProducto = ?";
            PreparedStatement psStock = con.prepareStatement(sqlUpdateStock);
            psStock.setInt(1, orden.getCantidadObjetivo());
            psStock.setInt(2, orden.getIdProductoObjetivo());
            psStock.executeUpdate();

            // CONFIRMAR TRANSACCIÓN
            con.commit();
            System.out.println("Producción finalizada. Orden N°: " + idOrdenGenerado);

        } catch (SQLException e) {
            if (con != null) {
                System.out.println("Error en transacción de Producción. Revirtiendo cambios...");
                con.rollback(); // DESHACER CAMBIOS SI FALLA
            }
            throw e;
        } finally {
            if (con != null) con.setAutoCommit(true);
        }
    }
    public void crearOrden(ordenProduccion orden) {

    }
    public ordenProduccion obtenerOrdenPorId(int idOrden) {
        return null;
    }
    public void actualizarOrden(ordenProduccion orden) {

    }
    public void eliminarOrden(int idOrden) {

    }
}
