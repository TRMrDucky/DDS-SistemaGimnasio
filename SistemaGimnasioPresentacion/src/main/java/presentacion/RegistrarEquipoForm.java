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
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Date;
import java.time.ZoneId;

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
        setSize(400, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel labelNombre = new JLabel("Nombre:");
        textNombre = new JTextField();

        JLabel labelMarca = new JLabel("Marca:");
        textMarca = new JTextField();

        JLabel labelModelo = new JLabel("Modelo:");
        textModelo = new JTextField();

        JLabel labelNumeroSerie = new JLabel("Número de Serie:");
        textNumeroSerie = new JTextField();

        JLabel labelFecha = new JLabel("Fecha de Adquisición:");
        datePicker = new DatePicker();

        btnRegistrar = new JButton("Registrar Equipo");
        btnRegistrar.addActionListener(this::registrarEquipo);

        panel.add(labelNombre);
        panel.add(textNombre);
        panel.add(labelMarca);
        panel.add(textMarca);
        panel.add(labelModelo);
        panel.add(textModelo);
        panel.add(labelNumeroSerie);
        panel.add(textNumeroSerie);
        panel.add(labelFecha);
        panel.add(datePicker);

        panel.add(new JLabel()); 
        panel.add(btnRegistrar);

        add(panel);
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

    } catch (NombreEquipoVacioException ex) {
        
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error de Validación", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error inesperado al registrar el equipo.", "Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
    }
    
    
  
    }
    

