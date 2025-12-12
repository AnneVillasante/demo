package com.alicorp;

import java.awt.Color;
import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource; // NECESARIO para LookAndFeel

import com.alicorp.controller.loginController; // NUEVO
import com.alicorp.view.loginView; // NUEVO

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("No se pudo aplicar el tema Nimbus");
        }
        // --- PERSONALIZACIÓN DE MARCA Y RSU (Accesibilidad Visual) ---
        // 1. COLORES CORPORATIVOS Y INYECCIÓN DE ESTILOS PROFUNDA
        Color alicorpRed = new Color(205, 16, 26); // Rojo Corporativo Alicorp
        Color cleanWhite = Color.WHITE;           // Fondo principal limpio
        
        // A. Aplicar el color base de Nimbus al Rojo Corporativo.
        // Esto impacta barras de título y elementos clave del L&F.
        UIManager.put("nimbusBase", new ColorUIResource(alicorpRed.darker())); // Base del tema (rojo oscuro)
        UIManager.put("nimbusBlueGrey", new ColorUIResource(alicorpRed)); // Color de acento de Nimbus (rojo brillante)
        UIManager.put("control", new ColorUIResource(cleanWhite)); // Fondo general de la aplicación: blanco limpio
        
        // B. Estilos para texto y botones
        UIManager.put("Label.font", new Font("Arial", Font.PLAIN, 14)); 
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));
        
        // C. Configuración Forzada del Botón (Solución al botón gris)
        UIManager.put("Button.background", new ColorUIResource(alicorpRed)); 
        UIManager.put("Button.foreground", new ColorUIResource(Color.WHITE));
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 18)); // Aún más grande y enfocado
        // Iniciar la aplicación MVC en el Login
        loginView loginVista = new loginView();
        new loginController(loginVista); // El controlador escucha a la vista
    }  
}