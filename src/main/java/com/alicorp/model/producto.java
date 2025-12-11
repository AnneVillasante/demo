package com.alicorp.model;

public class producto {
    private int idproducto;
    private String nombre;
    private String unidad;
    private double precio;
    private int stock;
    
    // Constructor vacío y con parámetros
    public producto() {}
    
    public producto(int id, String nom, double pre, int stock) {
        this.idproducto = id;
        this.nombre = nom;
        this.precio = pre;
        this.stock = stock;
    }

    // Getters y Setters necesarios
    public int getIdproducto() { return idproducto; }
    public void setIdproducto(int idproducto) { this.idproducto = idproducto; }
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}