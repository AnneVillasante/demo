package com.alicorp.model;

public class cliente {
    // Atributos basados en tu Diccionario de Datos 
    private int idcliente;
    private String nombre;
    private String ruc;
    private String direccion;
    private String email;

    // Constructor, Getters y Setters
    public cliente(int id, String nom, String ruc, String dir, String email) {
        this.idcliente = id;
        this.nombre = nom;
        this.ruc = ruc;
        this.direccion = dir;
        this.email = email;
    }
    public int getIdcliente() {
        return idcliente;
    }
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
