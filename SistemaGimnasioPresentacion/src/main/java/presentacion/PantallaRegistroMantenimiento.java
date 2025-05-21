/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import com.github.lgooddatepicker.components.DatePicker;
import dtos.EquipoDTO;
import dtos.MantenimientoDTO;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Cricri
 */
public class PantallaRegistroMantenimiento extends JFrame {
     
    private JTextField textTipoMantenimiento;
    private JTextField textCosto;
    private JTextArea textObservaciones;
    private DatePicker datePickerMantenimiento;
    private DatePicker datePickerSeguimiento;
    private JButton btnRegistrar;

    private ControlNavegacionCompraMembresia control;
    private EquipoDTO equipoSeleccionado;

    public PantallaRegistroMantenimiento(ControlNavegacionCompraMembresia control, EquipoDTO equipo) {
        this.control = control;
        this.equipoSeleccionado = equipo;
        setTitle("Registrar Mantenimiento");
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10)); 
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNombreEquipo = new JLabel("Equipo Seleccionado:");
        JLabel valorNombreEquipo = new JLabel(equipoSeleccionado.getNombre());
        panel.add(labelNombreEquipo);
        panel.add(valorNombreEquipo);

        JLabel labelFechaMantenimiento = new JLabel("Fecha de Mantenimiento:");
        datePickerMantenimiento = new DatePicker();

        JLabel labelTipo = new JLabel("Nombre del Mantenimiento:");
        textTipoMantenimiento = new JTextField();

        JLabel labelCosto = new JLabel("Costo: ");
        textCosto = new JTextField();

        JLabel labelObservaciones = new JLabel("Observaciones: (opcional)");
        textObservaciones = new JTextArea(3, 20);
        JScrollPane scrollObs = new JScrollPane(textObservaciones);

        JLabel labelFechaSeguimiento = new JLabel("Fecha de Seguimiento:");
        datePickerSeguimiento = new DatePicker();

        btnRegistrar = new JButton("Registrar Mantenimiento");
        btnRegistrar.addActionListener(this::registrarMantenimiento);

        panel.add(labelFechaMantenimiento);
        panel.add(datePickerMantenimiento);
        panel.add(labelTipo);
        panel.add(textTipoMantenimiento);
        panel.add(labelCosto);
        panel.add(textCosto);
        panel.add(labelObservaciones);
        panel.add(scrollObs);
        panel.add(labelFechaSeguimiento);
        panel.add(datePickerSeguimiento);
        panel.add(new JLabel()); // espacio en blanco
        panel.add(btnRegistrar);

        add(panel);
    }

    private void registrarMantenimiento(ActionEvent evt) {
        try {
            String idEquipo = equipoSeleccionado.getId(); 
            LocalDate fechaMant = datePickerMantenimiento.getDate();
            String tipo = textTipoMantenimiento.getText().trim();
            String costoStr = textCosto.getText().trim();
            String observaciones = textObservaciones.getText().trim();
            LocalDate fechaSeg = datePickerSeguimiento.getDate();

            float costo = Float.parseFloat(costoStr);
            Date fechaMantenimiento = Date.from(fechaMant.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Date fechaSeguimiento = (fechaSeg != null) ? Date.from(fechaSeg.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;

            MantenimientoDTO mantenimiento = new MantenimientoDTO(idEquipo, fechaMantenimiento, tipo, costo, observaciones, fechaSeguimiento);

            MantenimientoDTO registrado = control.registrarMantenimiento(mantenimiento);

            if (registrado != null) {
                JOptionPane.showMessageDialog(this, "Mantenimiento registrado exitosamente.");
                dispose();
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El costo debe ser un número válido.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error inesperado al registrar el mantenimiento.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}