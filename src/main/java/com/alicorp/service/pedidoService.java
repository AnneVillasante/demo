package com.alicorp.service;
import com.alicorp.dao.pedidoDAO; // (Interfaz que crearemos luego)
import com.alicorp.dao.pedidoDAOImpl; // (Implementación que crearemos luego)
import com.alicorp.dao.productoDAO;
import com.alicorp.dao.productoDAOImpl;
import com.alicorp.model.detallePedido;
import com.alicorp.model.pedido;
import com.alicorp.model.producto;

public class pedidoService {
    private productoDAO productoDAO = new productoDAOImpl();
    private pedidoDAO pedidoDAO = new pedidoDAOImpl();

    public void registrarPedido(pedido pedido) throws Exception {
        // 1. Validar Stock de cada producto antes de vender
        for (detallePedido det : pedido.getdetalles()) {
            producto p = productoDAO.obtenerPorId(det.getIdproducto());
            if (p == null) {
                throw new Exception("producto no existe: ID " + det.getIdproducto());
            }
            if (p.getStock() < det.getCantidad()) {
                throw new Exception("Stock insuficiente para: " + p.getNombre());
            }
        }
        
        // 2. Si todo está bien, llamar al DAO para guardar
        pedidoDAO.guardarPedidoTransaccional(pedido);
    }
}
