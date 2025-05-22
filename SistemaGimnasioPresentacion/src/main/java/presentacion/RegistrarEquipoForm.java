/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author Cricri
 */

import com.github.lgooddatepicker.components.DatePicker;
import dtos.EquipoDTO;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;
import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class RegistrarEquipoForm extends JFrame {
   
    private JTextField textNombre;
    private JTextField textMarca;
    private JTextField textModelo;
    private JTextField textNumeroSerie;
    private DatePicker datePicker;
    private JButton btnRegistrar;

    private ControlNavegacionCompraMembresia control;

    public RegistrarEquipoForm(ControlNavegacionCompraMembresia control) {
        this.control = control;
        setTitle("Registrar Nuevo Equipo");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

       
        panel.add(crearFilaFormulario("Nombre:", textNombre = new JTextField(20)));
        panel.add(crearFilaFormulario("Marca:(opcional)", textMarca = new JTextField(20)));
        panel.add(crearFilaFormulario("Modelo: (opcional)", textModelo = new JTextField(20)));
        panel.add(crearFilaFormulario("Número de Serie:", textNumeroSerie = new JTextField(20)));

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelFecha = new JLabel("Fecha de Adquisición:");
        datePicker = new DatePicker();
        datePanel.add(labelFecha);
        datePanel.add(datePicker);
        panel.add(datePanel);

        
        btnRegistrar = new JButton("Registrar Equipo");
        btnRegistrar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnRegistrar.addActionListener(this::registrarEquipo);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(btnRegistrar);

        add(panel);
    }

    private JPanel crearFilaFormulario(String labelText, JTextField textField) {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(160, 25)); 
        textField.setMaximumSize(new Dimension(200, 25));
        row.add(label);
        row.add(textField);
        return row;
    }

   private void registrarEquipo(ActionEvent evt) {
    try {
        String nombre = textNombre.getText().trim();
        String marca = textMarca.getText().trim();
        String modelo = textModelo.getText().trim();
        String numeroSerie = textNumeroSerie.getText().trim();
        LocalDate fecha = datePicker.getDate();

        if (fecha == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una fecha de adquisición.", "Fecha requerida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date fechaAdquisicion = Date.from(fecha.atStartOfDay(ZoneId.systemDefault()).toInstant());
        EquipoDTO equipo = new EquipoDTO(nombre, marca, modelo, numeroSerie, fechaAdquisicion);

        EquipoDTO registrado = control.registrarEquipo(equipo);

        if (registrado != null) {
            JOptionPane.showMessageDialog(this, "Equipo registrado exitosamente.");
            dispose();
        }

    } catch (NombreEquipoVacioException | NumeroSerieVacioException | 
             TamañoNombreEquipoExcedidoException | TamañoNumeroSerieExcedidoException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado al registrar el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}
}
