package com.alicorp.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; // Layout principal
import javax.swing.JLabel; // Para centrar el formulario
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class loginView extends JFrame{
    public JTextField txtUsuario;
    public JPasswordField txtClave; 
    public JButton btnIngresar;
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public loginView() {
        setTitle(bundle.getString("window.login.title")); 
        setSize(400, 350); // Tamaño mayor para un aspecto más elegante
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Establecer el ícono de la ventana (detalles corporativos)
        try {
            Image icon = new ImageIcon(getClass().getResource("/images/alicorp_logo_icon.png")).getImage();
            this.setIconImage(icon);
        } catch (Exception ex) {
            System.err.println("Advertencia: No se pudo cargar el ícono de la ventana.");
        }
        
        // ** 1. LAYOUT PRINCIPAL: BorderLayout para Header (NORTH) y Contenido (CENTER) **
        getContentPane().setLayout(new BorderLayout(15, 15));
        
        // Margen interno (padding)
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(25, 30, 30, 30));
        setLocationRelativeTo(null); 
        
        // ** 2. HEADER: Logo y Línea Separadora (NORTH) **
        JPanel headerPanel = new JPanel(new BorderLayout());
        try {
            // Se asume que /images/alicorp_logo.png existe en src/main/resources
            ImageIcon logo = new ImageIcon(getClass().getResource("/images/alicorp_logo.png")); 
            JLabel logoLabel = new JLabel(logo);
            logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
            headerPanel.add(logoLabel, BorderLayout.CENTER);
        } catch (Exception ex) {
            // Placeholder si no hay imagen
            JLabel placeholder = new JLabel("Sistema de Gestión Alicorp", SwingConstants.CENTER);
            placeholder.setFont(new Font("Arial", Font.BOLD, 18));
            headerPanel.add(placeholder, BorderLayout.CENTER);
        }
        
        // Línea Separadora Corporativa (Accent Red)
        JLabel separator = new JLabel();
        separator.setOpaque(true);
        separator.setBackground(new Color(205, 16, 26)); // Rojo corporativo
        separator.setPreferredSize(new java.awt.Dimension(400, 3)); 
        headerPanel.add(separator, BorderLayout.SOUTH);

        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // ** 3. FORMULARIO CENTRADO (CENTER) con GridBagLayout **
        // Usamos GridBagLayout en el contenedor para centrar el panel del formulario
        JPanel formContainer = new JPanel(new GridBagLayout()); 
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15)); // Formato de 3 filas x 2 columnas

        JLabel lblUsuario = new JLabel(bundle.getString("lbl.usuario"));
        JLabel lblClave = new JLabel(bundle.getString("lbl.clave"));
        
        txtUsuario = new JTextField(20); 
        txtClave = new JPasswordField(20);
        btnIngresar = new JButton(bundle.getString("btn.ingresar"));
        btnIngresar.setMnemonic('I'); 
        
        // Construir el panel de formulario
        formPanel.add(lblUsuario); 
        formPanel.add(txtUsuario);
        formPanel.add(lblClave); 
        formPanel.add(txtClave);
        formPanel.add(new JLabel("")); 
        formPanel.add(btnIngresar);
        
        // Centrar el panel de formulario
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0); // Margen superior para separarlo del header
        formContainer.add(formPanel, gbc);
        
        getContentPane().add(formContainer, BorderLayout.CENTER);
        setVisible(true); // Se inicia visible en Main
    }
}
