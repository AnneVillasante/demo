package com.alicorp.view;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class pedidoView extends JFrame{
    public JTextField txtIdcliente, txtIdproducto, txtCantidad;
    public JButton btnAgregar, btnFinalizar;
    public JTextArea txtAreaDetalle; // Para ver qué estamos comprando
    
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public pedidoView() {
        setTitle(bundle.getString("window.pedido.title")); // "Gestión de Pedidos"
        setSize(500, 400);
        setLayout(new BorderLayout(10, 10));
        
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(15, 15, 15, 15));

        // Campos RSU: Etiquetas traducidas y descripciones accesibles
        JLabel lblProd = new JLabel(bundle.getString("lbl.producto")); // "ID Producto:"
        txtIdproducto = new JTextField(5);
        txtIdproducto.getAccessibleContext().setAccessibleDescription("Ingrese el código del producto");

        JLabel lblCant = new JLabel(bundle.getString("lbl.cantidad")); // "Cantidad:"
        txtCantidad = new JTextField(5);
        
        btnAgregar = new JButton(bundle.getString("btn.agregar")); // "Agregar al Carrito"
        btnAgregar.setMnemonic('A'); // Alt+A

        btnFinalizar = new JButton(bundle.getString("btn.finalizar")); // "Finalizar Pedido"
        btnFinalizar.setMnemonic('F'); // Alt+F

        txtAreaDetalle = new JTextArea(10, 40);
        txtAreaDetalle.setEditable(false);

        // Panel Superior (Formulario)
        JPanel panelForm = new JPanel(new GridLayout(3, 2, 5, 5));
        panelForm.add(lblProd); panelForm.add(txtIdproducto);
        panelForm.add(lblCant); panelForm.add(txtCantidad);
        panelForm.add(new JLabel("")); panelForm.add(btnAgregar);
        
        // Agregar componentes al Layout Principal
        add(panelForm, BorderLayout.NORTH);
        add(new JScrollPane(txtAreaDetalle), BorderLayout.CENTER);
        add(btnFinalizar, BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
