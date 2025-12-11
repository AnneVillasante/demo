package com.alicorp.controller;
import com.alicorp.service.clienteService;
import com.alicorp.model.cliente;
import com.alicorp.view.clienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class clienteController implements ActionListener{
    private clienteView vista;
    private clienteService modelo;
    public clienteController(clienteView vista) {
        this.vista = vista;
        this.modelo = new clienteService();
        this.vista.btnGuardar().addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = this.vista.txtNombre().getText();
        String ruc = this.vista.txtRuc().getText();
        String direccion = this.vista.txtDireccion().getText();
        String email = this.vista.txtEmail().getText();
        try {
            cliente c = new cliente(idcliente, nombre, ruc, direccion, email);
            this.modelo.registrarcliente(c);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
