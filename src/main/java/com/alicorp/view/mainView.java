package com.alicorp.view;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class mainView extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menuGestion, menuOperaciones, menuReportes, menuAyuda;
    private JMenuItem miClientes, miPedidos, miProduccion, miReporteKPI, miReporteRSU, miEvidenciasRSU, miSalir;
    private ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
    private String rolUsuario;
    
    public mainView(String rol) {
        this.rolUsuario = rol;
        // RQN-01: Muestra el rol actual en el título
        setTitle(bundle.getString("window.main.title") + " - Rol: " + rol); 
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        crearMenu();
        aplicarControlDeAcceso(); // CRÍTICO: Control de Acceso basado en Roles (RBAC)
        
        setVisible(true);
    }
    
    private void crearMenu() {
        menuBar = new JMenuBar();
        
        // 1. Menú Gestión
        menuGestion = new JMenu(bundle.getString("menu.gestion")); 
        miClientes = crearMenuItem("item.clientes"); 
        
        // 2. Menú Operaciones
        menuOperaciones = new JMenu(bundle.getString("menu.operaciones"));
        miPedidos = crearMenuItem("item.pedidos");
        miProduccion = crearMenuItem("item.produccion"); 
        
        // 3. Menú Reportes
        menuReportes = new JMenu(bundle.getString("menu.reportes"));
        miReporteKPI = crearMenuItem("item.reporte_kpi");
        miReporteRSU = crearMenuItem("item.reporte_rsu"); 
        
        // 4. Menú Ayuda
        menuAyuda = new JMenu(bundle.getString("menu.ayuda"));
        miEvidenciasRSU = crearMenuItem("item.evidencias_rsu"); // RSU: Evidencias documentales
        miSalir = crearMenuItem("item.salir");
        
        menuGestion.add(miClientes);
        menuOperaciones.add(miPedidos);
        menuOperaciones.add(miProduccion);
        menuReportes.add(miReporteKPI);
        menuReportes.add(miReporteRSU);
        menuAyuda.add(miEvidenciasRSU);
        menuAyuda.add(miSalir);
        
        menuBar.add(menuGestion);
        menuBar.add(menuOperaciones);
        menuBar.add(menuReportes);
        menuBar.add(menuAyuda);
        
        setJMenuBar(menuBar);
    }
    
    // RQN-01: Lógica de Control de Acceso basado en Roles (RBAC)
    private void aplicarControlDeAcceso() {
        // Restricción: Solo Administradores y Vendedores pueden gestionar clientes
        miClientes.setEnabled(rolUsuario.equals("Administrador") || rolUsuario.equals("Ventas"));
        
        // Restricción: Solo Administradores y Producción pueden crear órdenes
        miProduccion.setEnabled(rolUsuario.equals("Administrador") || rolUsuario.equals("Produccion"));
        
        // Restricción: Solo Gerencia/Administradores acceden a Reportes RSU
        miReporteRSU.setEnabled(rolUsuario.equals("Administrador")); 
    }

    private JMenuItem crearMenuItem(String key) {
        JMenuItem item = new JMenuItem(bundle.getString(key));
        item.setActionCommand(key);
        item.addActionListener(this);
        return item;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "item.clientes":
                new clienteView().setVisible(true);
                break;
            case "item.pedidos":
                new pedidoView().setVisible(true); // Abre Pedidos
                break;
            case "item.produccion":
                new produccionView().setVisible(true); // Abre Producción
                break;
            case "item.reporte_kpi":
                new reporteKPIView().setVisible(true); // Abre Reporte KPI
                break;
            case "item.reporte_rsu":
                new reportesRSUView().setVisible(true); // Abre Reporte RSU
                break;
            case "item.evidencias_rsu":
                abrirEvidenciasRSU(); // Llama a la función para RSU documental
                break;
            case "item.salir":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Función no implementada: " + command);
        }
    }
    
    // Función para RSU documental
    private void abrirEvidenciasRSU() {
        // CRÍTICO RSU: Simula la apertura de los documentos de evidencia.
        // Asume que la carpeta 'evidencias_rsu' existe en la raíz del proyecto.
        try {
            File folder = new File("evidencias_rsu");
            if (folder.exists() && folder.isDirectory()) {
                Desktop.getDesktop().open(folder);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "ERROR: La carpeta 'evidencias_rsu' no fue encontrada. Debe crearla y añadir los PDFs de actas y recomendaciones.", 
                    "Faltante RSU Documental", 
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "No se pudo abrir la carpeta: " + ex.getMessage());
        }
    }
}
