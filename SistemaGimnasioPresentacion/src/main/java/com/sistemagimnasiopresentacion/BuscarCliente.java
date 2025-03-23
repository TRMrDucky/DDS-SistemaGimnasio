    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import com.subsistemacompramembresia.IManejadorComprasMembresias;
import dtos.ClienteRegistradoDTO;
import implementaciones.ManejadorComprasMembresias;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class BuscarCliente extends JFrame {
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JButton btnBuscar;
    
    private IManejadorComprasMembresias subsistema;

    public BuscarCliente() {
        setTitle("Búsqueda de Cliente");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        subsistema = new ManejadorComprasMembresias(); // Inicialización

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        btnBuscar = new JButton("Buscar");
        panel.add(btnBuscar);

        add(panel, BorderLayout.CENTER);

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
    }

    private void buscarCliente() {
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();

        if (nombre.isEmpty() || telefono.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar nombre y teléfono.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe tener 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<ClienteRegistradoDTO> clientes = subsistema.buscarCliente(nombre, telefono);

        if (!clientes.isEmpty()) {
            // Mostrar los resultados
            StringBuilder mensaje = new StringBuilder("Clientes encontrados:\n");
            for (ClienteRegistradoDTO cliente : clientes) {
                mensaje.append("Nombre: ").append(cliente.getNombre()).append("\n")
                       .append("Teléfono: ").append(cliente.getNumeroTelefono()).append("\n")
                       .append("Correo: ").append(cliente.getEmail()).append("\n\n");
            }
            JOptionPane.showMessageDialog(this, mensaje.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}




