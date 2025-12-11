package com.alicorp.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/alicorpdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection conexion = null;
    
    public static Connection conectar(){
        try {
            if(conexion == null || conexion.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Conexión exitosa a la Base de Datos Alicorp.");
                }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la Base de Datos: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
}
