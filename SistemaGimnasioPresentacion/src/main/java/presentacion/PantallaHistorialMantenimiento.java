/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.EquipoDTO;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cricri
 */
public class PantallaHistorialMantenimiento extends JFrame{
     private ControlNavegacionCompraMembresia control;
    private EquipoDTO equipo;
    private JTable tablaMantenimientos;
    private DefaultTableModel modeloTabla;

    public PantallaHistorialMantenimiento(ControlNavegacionCompraMembresia control, EquipoDTO equipo) {
        this.control = control;
        this.equipo = equipo;
        setTitle("Historial de Mantenimientos - " + equipo.getNombre());
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        cargarMantenimientos();
    }

    private void initComponents() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Historial de Mantenimientos del Equipo: " + equipo.getNombre());
        titulo.setFont(new Font("Arial", Font.BOLD, 16));

        modeloTabla = new DefaultTableModel(new String[]{
            "Fecha", "Mantenimiento", "Costo", "Observaciones", "Fecha Seguimiento"
        }, 0);

        tablaMantenimientos = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaMantenimientos);

        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    private void cargarMantenimientos() {
        try {
            List<HistorialEquipoDTO> lista = control.obtenerHistorialPorEquipo(equipo.getId());

            modeloTabla.setRowCount(0); // Limpiar tabla
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            for (HistorialEquipoDTO m : lista) {
                modeloTabla.addRow(new Object[]{
                    sdf.format(m.getFechaMantenimiento()),
                    m.getNombreMantenimiento(),
                    "$" + m.getCosto(),
                    m.getObservaciones(),
                    m.getFechaSeguimiento() != null ? sdf.format(m.getFechaSeguimiento()) : "-"
                });
            }

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "No se encontraron mantenimientos para este equipo.",
                        "Historial vacío", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al cargar el historial de mantenimiento.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}