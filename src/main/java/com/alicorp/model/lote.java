package com.alicorp.model;
import java.sql.Date;

public class lote {
    private int idLote;
    private String codigo;
    private Date fechaFabricacion;
    private Date fechaVencimiento;
    private String estado; // Cuarentena, Liberado, Rechazado

    public lote(String codigo, Date fechaVencimiento) {
        this.codigo = codigo;
        this.fechaFabricacion = new Date(System.currentTimeMillis());
        this.fechaVencimiento = fechaVencimiento;
        this.estado = "Cuarentena"; // RQF-06: Debe pasar por QC antes de liberarse
    }
    
    public int getIdLote() { return idLote; }
    public void setIdLote(int idLote) { this.idLote = idLote; }
    public String getCodigo() { return codigo; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public Date getFechaFabricacion() { return fechaFabricacion; }
    public Date getFechaVencimiento() { return fechaVencimiento; }
}
