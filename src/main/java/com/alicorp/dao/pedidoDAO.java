package com.alicorp.dao;
import java.sql.SQLException;

import com.alicorp.model.pedido;

public interface pedidoDAO {
    // Método que gestiona la transacción completa: insertar cabecera, detalles y actualizar stock.
    void guardarPedidoTransaccional(pedido pedido) throws SQLException;
    
    // Aquí se agregarían métodos para listar, buscar, etc., si fueran necesarios.
}
