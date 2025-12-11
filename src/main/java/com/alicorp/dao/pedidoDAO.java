package com.alicorp.dao;
import com.alicorp.model.pedido;
import java.sql.SQLException;

public class pedidoDAO {
    // Método que gestiona la transacción completa: insertar cabecera, detalles y actualizar stock.
    void guardarPedidoTransaccional(pedido pedido) throws SQLException;
    
    // Aquí se agregarían métodos para listar, buscar, etc., si fueran necesarios.
}
