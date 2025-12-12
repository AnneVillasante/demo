package com.alicorp.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class reporteKPIView extends JFrame {
    public reporteKPIView() {
        setTitle("Reporte de KPIs de Gestión");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Placeholder para futuros gráficos
        JLabel lblMensaje = new JLabel("<html><center><h1>Dashboard de KPIs</h1><p>Gráficos de rendimiento en construcción...</p></center></html>", SwingConstants.CENTER);
        add(lblMensaje);
    }
}