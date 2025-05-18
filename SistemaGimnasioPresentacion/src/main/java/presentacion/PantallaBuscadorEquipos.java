/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;
import enums.ModoUso;
 import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Cricri
 */
public class PantallaBuscadorEquipos extends JDialog{
    private JTextField campoBusqueda;
    private JTable tablaResultados;
    private JButton btnSeleccionar;
    private ModoUso modoUso;

    public PantallaBuscadorEquipos(ModoUso modoUso) {
        this.modoUso = modoUso;
        setTitle("Buscar Equipo");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        configurarInterfaz();
        configurarEventos();
    }

    private void configurarInterfaz() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel();
        campoBusqueda = new JTextField(20);
        JButton btnBuscar = new JButton("Buscar");
        panelBusqueda.add(new JLabel("Buscar: "));
        panelBusqueda.add(campoBusqueda);
        panelBusqueda.add(btnBuscar);

        // Tabla de resultados
        String[] columnas = {"Nombre del equipo", "ID", "Estado"};
        Object[][] datos = {
                {"Máquina Prensadora", "123456", "FitBoard"},
                {"Máquina Curl", "345987", "FitBoard"},
                {"Máquina Piernas", "398577", "FitGym"}
        };
        tablaResultados = new JTable(new DefaultTableModel(datos, columnas));
        JScrollPane scrollTabla = new JScrollPane(tablaResultados);

        
        btnSeleccionar = new JButton("Seleccionar equipo");

        panelPrincipal.add(panelBusqueda, BorderLayout.NORTH);
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);
        panelPrincipal.add(btnSeleccionar, BorderLayout.SOUTH);

        setContentPane(panelPrincipal);
    }

    private void configurarEventos() {
        btnSeleccionar.addActionListener(e -> {
            String equipoSeleccionado = obtenerEquipoSeleccionado();
            if (equipoSeleccionado != null) {
                manejarSeleccion(equipoSeleccionado);
            }
        });
    }

    private String obtenerEquipoSeleccionado() {
        int fila = tablaResultados.getSelectedRow();
        if (fila >= 0) {
            return tablaResultados.getValueAt(fila, 0).toString();
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un equipo primero.");
            return null;
        }
    }

    private void manejarSeleccion(String equipo) {
        switch (modoUso) {
            case REGISTRO_MANTENIMIENTO:
                abrirPantallaRegistroMantenimiento(equipo);
                break;
            case CONSULTA_HISTORIAL:
                abrirPantallaHistorial(equipo);
                break;
            case ELIMINAR_EQUIPO:
                confirmarEliminacion(equipo);
                break;
        }
    }

    private void abrirPantallaRegistroMantenimiento(String equipo) {
        JOptionPane.showMessageDialog(this, "Abrir pantalla de registro para: " + equipo);
        // new PantallaRegistroMantenimiento(equipo).setVisible(true);
    }

    private void abrirPantallaHistorial(String equipo) {
        JOptionPane.showMessageDialog(this, "Abrir historial para: " + equipo);
        // new PantallaHistorial(equipo).setVisible(true);
    }

    private void confirmarEliminacion(String equipo) {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Dar de baja el equipo " + equipo + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            eliminarEquipo(equipo);
        }
    }

    private void eliminarEquipo(String equipo) {
        JOptionPane.showMessageDialog(this, "Equipo " + equipo + " eliminado.");
        // Aquí iría la lógica de eliminación real
    }

  
    // Prueba rápida
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PantallaBuscadorEquipos(ModoUso.REGISTRO_MANTENIMIENTO).setVisible(true);
        });
    }
}


   


    

