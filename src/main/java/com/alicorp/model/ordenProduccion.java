package com.alicorp.model;
import java.util.Date;

public class ordenProduccion {
    private int idOrden;
    private Date fechaInicio;
    private int idProductoObjetivo;
    private int cantidadObjetivo;
    private String estado; // Pendiente, En Proceso, Finalizada
    private int idLoteGenerado; // Clave para vincular al Lote

    // Constructor, Getters y Setters
    public ordenProduccion(int idProductoObjetivo, int cantidadObjetivo) {
        this.idProductoObjetivo = idProductoObjetivo;
        this.cantidadObjetivo = cantidadObjetivo;
        this.estado = "En Proceso"; // Estado inicial al crear
    }

    public int getIdOrden() { return idOrden; }
    public void setIdOrden(int idOrden) { this.idOrden = idOrden; }
    public int getIdProductoObjetivo() { return idProductoObjetivo; }
    public int getCantidadObjetivo() { return cantidadObjetivo; }
    public void setIdLoteGenerado(int idLoteGenerado) { this.idLoteGenerado = idLoteGenerado; }
    public int getIdLoteGenerado() { return idLoteGenerado; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setCantidadObjetivo(int cantidadObjetivo) { this.cantidadObjetivo = cantidadObjetivo; }
    public void setIdProductoObjetivo(int idProductoObjetivo) { this.idProductoObjetivo = idProductoObjetivo; }
}
