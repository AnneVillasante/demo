package com.alicorp.view;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class reportesRSUView extends JFrame{
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public reportesRSUView() {
        // RSU: Título internacionalizado
        setTitle(bundle.getString("window.reporte_rsu.title")); 
        setSize(500, 400);
        setLayout(new BorderLayout());
        
        JTextArea areaReporte = new JTextArea();
        areaReporte.setEditable(false);
        
        // Simulación de datos RSU (RQF-15) y KPIs (RQF-10)
        String reporte = "\n" + bundle.getString("reporte.rsu.titulo") + "\n";
        reporte += "========================================\n";
        reporte += bundle.getString("reporte.rsu.metrica1") + ": 5,200 kg\n"; // Desperdicio
        reporte += bundle.getString("reporte.rsu.metrica2") + ": 1,800 MWh\n"; // Energía
        reporte += bundle.getString("reporte.rsu.metrica3") + ": 98.5%\n";    // Emisiones
        reporte += "\nKPI OPERACIONAL (RQF-10):\n";
        reporte += "Rotación de Inventario: 12.5 veces/año\n";
        reporte += "Tasa de Cumplimiento (OTIF): 96.2%\n";
        reporte += "========================================\n";
        reporte += bundle.getString("reporte.rsu.cumplimiento") + ": ISO 14001, Ley de Etiquetado.\n";
        reporte += bundle.getString("reporte.rsu.accesibilidad") + ": Interfaz WCAG 2.1 AA (Aprobado).\n";
        
        areaReporte.setText(reporte);
        add(new JScrollPane(areaReporte), BorderLayout.CENTER);
        
        JButton btnExportar = new JButton(bundle.getString("btn.exportar_rsu"));
        add(btnExportar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
