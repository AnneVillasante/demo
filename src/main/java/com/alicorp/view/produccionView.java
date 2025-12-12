package com.alicorp.view;
import java.awt.GridLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class produccionView extends JFrame {
    public JTextField txtIdProducto, txtCantidad, txtCodLote, txtFechaVencimiento;
    public JButton btnFinalizarProduccion;
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public produccionView() {
        setTitle(bundle.getString("window.produccion.title")); // RSU: i18n
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        
        // Margen interno
        ((JPanel)getContentPane()).setBorder(new EmptyBorder(20, 20, 20, 20));
        setLocationRelativeTo(null);
        
        // Componentes de la Orden de Producción
        add(new JLabel(bundle.getString("lbl.prod_id")));
        txtIdProducto = new JTextField();
        add(txtIdProducto);
        
        add(new JLabel(bundle.getString("lbl.prod_cant")));
        txtCantidad = new JTextField();
        add(txtCantidad);

        // Componentes de Lote (Trazabilidad RQF-04)
        add(new JLabel(bundle.getString("lbl.lote_codigo")));
        txtCodLote = new JTextField();
        add(txtCodLote);

        add(new JLabel(bundle.getString("lbl.lote_vencimiento")));
        txtFechaVencimiento = new JTextField("YYYY-MM-DD");
        add(txtFechaVencimiento);

        add(new JLabel(""));
        btnFinalizarProduccion = new JButton(bundle.getString("btn.prod_finalizar"));
        btnFinalizarProduccion.setMnemonic('P'); // RSU: Atajo ALT+P
        add(btnFinalizarProduccion);

        // Nota: Faltaría el controlador para conectar esta vista con el Service.
    }
}
