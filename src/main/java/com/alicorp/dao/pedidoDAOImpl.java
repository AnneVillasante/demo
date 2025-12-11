package com.alicorp.dao;
import com.alicorp.model.pedido;
import com.alicorp.model.detallePedido;
import com.alicorp.util.conexionDB;
import java.sql.*;

public class pedidoDAOImpl implements pedidoDAO{
    public void guardarPedidoTransaccional(pedido pedido) throws SQLException {
        Connection con = null;
        try {
            con = conexionDB.conectar();
            // INICIO DE TRANSACCIÓN
            con.setAutoCommit(false); 

            // A. Insertar Cabecera
            String sqlCabecera = "INSERT INTO Pedido (fecha, total, idCliente) VALUES (NOW(), ?, ?)";
            PreparedStatement psCab = con.prepareStatement(sqlCabecera, Statement.RETURN_GENERATED_KEYS);
            psCab.setDouble(1, pedido.getTotal());
            psCab.setInt(2, pedido.getIdCliente()); // Asumiendo que ya seteas el cliente
            psCab.executeUpdate();

            // Obtener el ID generado del Pedido
            ResultSet rsKeys = psCab.getGeneratedKeys();
            int idPedidoGenerado = 0;
            if (rsKeys.next()) {
                idPedidoGenerado = rsKeys.getInt(1);
            }

            // B. Insertar Detalles y Actualizar Stock
            String sqlDetalle = "INSERT INTO detallePedido (idPedido, idProducto, cantidad, precioUnitario) VALUES (?,?,?,?)";
            String sqlUpdateStock = "UPDATE producto SET stock = stock - ? WHERE idProducto = ?";
            
            PreparedStatement psDet = con.prepareStatement(sqlDetalle);
            PreparedStatement psStock = con.prepareStatement(sqlUpdateStock);

            for (detallePedido det : pedido.getDetalles()) {
                // Insertar detalle
                psDet.setInt(1, idPedidoGenerado);
                psDet.setInt(2, det.getIdproducto());
                psDet.setInt(3, det.getCantidad());
                psDet.setDouble(4, det.getPrecioUnitario());
                psDet.executeUpdate();

                // Restar stock
                psStock.setInt(1, det.getCantidad());
                psStock.setInt(2, det.getIdproducto());
                psStock.executeUpdate();
            }

            // CONFIRMAR TRANSACCIÓN
            con.commit(); 
            System.out.println("Pedido registrado exitosamente.");

        } catch (SQLException e) {
            // SI ALGO FALLA, DESHACER TODO
            if (con != null) {
                System.out.println("Error en transacción. Revirtiendo cambios...");
                con.rollback(); 
            }
            throw e;
        } finally {
            if (con != null) con.setAutoCommit(true); // Restaurar estado por defecto
        }
    }
}
