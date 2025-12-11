package com.alicorp;

import java.awt.Font;

import javax.swing.UIManager;

import com.alicorp.controller.clienteController;
import com.alicorp.view.clienteView;

public class Main {
    public static void main(String[] args) {
        // RSU: Accesibilidad Visual
        // Aumentar el tamaño de fuente global para personas con dificultad visual
        UIManager.put("Label.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("Button.font", new Font("Arial", Font.BOLD, 14));
        UIManager.put("TextField.font", new Font("Arial", Font.PLAIN, 14));

        // Iniciar la aplicación MVC
        clienteView vista = new clienteView();
        clienteController controlador = new clienteController(vista); // El controlador escucha a la vista
        
        vista.setVisible(true);
    }
}