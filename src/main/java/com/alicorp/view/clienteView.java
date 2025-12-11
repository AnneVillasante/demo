package com.alicorp.view;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class clienteView extends JFrame{
    public JTextField txtNombre;
    public JTextField txtRuc;
    public JButton btnGuardar;

    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public clienteView() {
        // Configuración básica de la ventana
        setTitle(bundle.getString("window.title")); // Título traducible
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10)); // Diseño simple tipo rejilla

        // Inicializar componentes con RSU
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        // Etiquetas (Labels) con texto traducido
        JLabel lblNombre = new JLabel(bundle.getString("lbl.nombre"));
        JLabel lblRuc = new JLabel(bundle.getString("lbl.ruc"));

        // Campos de texto
        txtNombre = new JTextField();
        txtRuc = new JTextField();
        
        // RSU: Accesibilidad para lectores de pantalla
        txtNombre.getAccessibleContext().setAccessibleDescription(bundle.getString("desc.nombre"));
        txtRuc.getAccessibleContext().setAccessibleDescription(bundle.getString("desc.ruc"));

        // Botón
        btnGuardar = new JButton(bundle.getString("btn.guardar"));
        
        // RSU: Accesibilidad - Uso sin mouse (Mnémicos y Tooltips)
        // El usuario puede presionar ALT + G para guardar
        btnGuardar.setMnemonic('G'); 
        btnGuardar.setToolTipText(bundle.getString("tooltip.guardar"));

        // Agregar a la ventana
        add(lblNombre);
        add(txtNombre);
        add(lblRuc);
        add(txtRuc);
        add(new JLabel("")); // Espacio vacío
        add(btnGuardar);
    }
}
