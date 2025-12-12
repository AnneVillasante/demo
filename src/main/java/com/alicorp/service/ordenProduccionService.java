package com.alicorp.service;
import com.alicorp.dao.ordenProduccionDAO;
import com.alicorp.dao.ordenProduccionDAOImpl;
import com.alicorp.model.lote;
import com.alicorp.model.ordenProduccion;

public class ordenProduccionService {
    private ordenProduccionDAO dao = new ordenProduccionDAOImpl();

    public void finalizar(ordenProduccion orden, lote loteGenerado) throws Exception {
        if (orden.getCantidadObjetivo() <= 0) {
            throw new Exception("La cantidad a producir debe ser mayor a cero.");
        }
        
        // Aquí se simularía la validación de materiales (BOM) antes de producir (RQF-05)
        System.out.println("Verificando insumos para la orden N°..." );

        // Llama a la capa DAO para ejecutar la transacción
        dao.finalizarProduccionTransaccional(orden, loteGenerado);
    }
}
