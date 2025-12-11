package com.alicorp.model;

public class usuario {
    private int idusuario;
    private String username;
    private String password;
    private String rol; // Ej: "Administrador", "Producción"

    public usuario() {}

    public usuario(int idusuario, String username, String password, String rol) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
        this.rol = rol;
    }

    public int getIdusuario() { return idusuario; }
    public void setIdusuario(int idusuario) { this.idusuario = idusuario; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}