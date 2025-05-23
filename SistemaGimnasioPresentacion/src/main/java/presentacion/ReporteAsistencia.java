/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import DTOs.ReporteAsistenciaDTO;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 52644
 */
public class ReporteAsistencia extends JFrame {

    private JTable tabla;
    private DefaultTableModel modelo;
    private ControlNavegacionCompraMembresia control;
    private JButton btnVolver;

    public ReporteAsistencia(ReporteAsistenciaDTO cliente, ControlNavegacionCompraMembresia control) {
        this.control = control;
        iniciarComponentes(cliente);
        rellenarTabla(cliente);

    }

    public ReporteAsistencia(ReporteAsistenciaDTO cliente) {
        this.control = control;
        iniciarComponentes(cliente);
        rellenarTabla(cliente);
    }

    private void iniciarComponentes(ReporteAsistenciaDTO cliente) {
        setTitle("Búsqueda de Cliente");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        modelo = new DefaultTableModel(new String[]{
            "Nombre", "Apellidos", "Asistencia"
        }, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        tabla = new JTable(modelo);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        btnVolver = new JButton("Volver");
        add(btnVolver, BorderLayout.SOUTH);
    }

    private void rellenarTabla(ReporteAsistenciaDTO cliente) {
        modelo.setRowCount(0);
        List<Date> la = cliente.getAsistencia();
        int i = la.size();
        for (int j = 0; j < i; j++) {
            modelo.addRow(new String[]{
                cliente.getNombre(),
                cliente.getApellido(),
                la.get(j).toString()});
        }

    }
}
