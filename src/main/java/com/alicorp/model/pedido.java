package com.alicorp.model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class pedido {
    private int idPedido;
    private Date fecha;
    private double total;
    private int idcliente;
    // Un pedido tiene muchos detalles (Lista de productos)
    private List<detallePedido> detalles = new ArrayList<>();

    // Constructor, Getters y Setters
    public void agregardetalle(detallePedido detalle) {
        this.detalles.add(detalle);
        this.total += detalle.getSubtotal();
    }
    public List<detallePedido> getdetalles() { 
        return detalles; }
    public void setdetalles(List<detallePedido> detalles) {
         this.detalles = detalles; }
    public int getIdPedido() { 
        return idPedido; }
    public void setIdPedido(int idPedido) { 
        this.idPedido = idPedido; }
    public Date getFecha() { 
        return fecha; }
    public void setFecha(Date fecha) { 
        this.fecha = fecha; }
    public double getTotal() { 
        return total; }
    public void setTotal(double total) { 
        this.total = total; }
    public int getIdcliente() { 
        return idcliente; }
    public void setIdCliente(int idCliente) { 
        this.idcliente = idCliente; }

}
