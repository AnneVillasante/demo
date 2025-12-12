package com.alicorp.view;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class loginView extends JFrame{
    public JTextField txtUsuario;
    public JPasswordField txtClave; 
    public JButton btnIngresar;
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public loginView() {
        setTitle(bundle.getString("window.login.title")); // RSU: i18n
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));
        setLocationRelativeTo(null); 

        JLabel lblUsuario = new JLabel(bundle.getString("lbl.usuario"));
        JLabel lblClave = new JLabel(bundle.getString("lbl.clave"));

        txtUsuario = new JTextField();
        txtClave = new JPasswordField();
        btnIngresar = new JButton(bundle.getString("btn.ingresar"));
        btnIngresar.setMnemonic('I'); 

        add(lblUsuario); add(txtUsuario);
        add(lblClave); add(txtClave);
        add(new JLabel("")); add(btnIngresar);
        setVisible(true); // Se inicia visible en Main
    }
}
