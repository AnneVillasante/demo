package com.alicorp.model;

public class detallePedido {
    private int idproducto;
    private int cantidad;
    private double precioUnitario;

    public detallePedido(int idproducto, int cantidad, double precio) {
        this.idproducto = idproducto;
        this.cantidad = cantidad;
        this.precioUnitario = precio;
    }
    
    public double getSubtotal() { return cantidad * precioUnitario; }
    public int getIdproducto() { return idproducto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioUnitario() { return precioUnitario; }
}
