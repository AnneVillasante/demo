package com.alicorp.controller;
import com.alicorp.service.usuarioService;
import com.alicorp.model.usuario;
import com.alicorp.view.loginView;
import com.alicorp.view.mainView; // Necesitas crear esta clase

import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginController implements ActionListener {
    private loginView loginView;
    private usuarioService userService;

    public loginController(loginView loginView) {
        this.loginView = loginView;
        this.userService = new usuarioService();
        this.loginView.btnIngresar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = loginView.txtUsuario.getText();
        String password = new String(loginView.txtClave.getPassword());
        
        try {
            usuario user = userService.autenticar(username, password);
            if (user != null) {
                JOptionPane.showMessageDialog(loginView, "Bienvenido, " + user.getNombre() + " (" + user.getRol() + ")", "Ingreso Exitoso", JOptionPane.INFORMATION_MESSAGE);
                
                // Cierra la ventana de Login
                loginView.dispose(); 
                
                // Abre el Dashboard principal con el rol del usuario (RBAC)
                new mainView(user.getRol()); 
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(loginView, ex.getMessage(), "Error de Autenticación", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
