package com.alicorp;

import java.awt.Font;

import javax.swing.UIManager;

import com.alicorp.controller.loginController; // NUEVO
import com.alicorp.view.loginView; // NUEVO

public class Main {
    public static void main(String[] args) {
        // RSU: Accesibilidad Visual
        // Aumentar el tamaño de fuente global para personas con dificultad visual
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));

        // Iniciar la aplicación MVC en el Login
        loginView loginVista = new loginView();
        new loginController(loginVista); // El controlador escucha a la vista
    }  
}