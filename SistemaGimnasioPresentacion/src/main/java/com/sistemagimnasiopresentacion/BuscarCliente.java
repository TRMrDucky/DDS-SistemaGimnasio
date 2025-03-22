/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemagimnasiopresentacion;

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

/**
 *
 * @author Jose
 */
public class BuscarCliente extends JFrame {
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JButton btnBuscar;
    private JTextArea txtResultados;

    public BuscarCliente() {
        setTitle("Búsqueda de Cliente");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        
        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField();
        
        btnBuscar = new JButton("Buscar");
        txtResultados = new JTextArea();
        txtResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultados);
        
        panel.add(lblNombre);
        panel.add(txtNombre);
        panel.add(lblTelefono);
        panel.add(txtTelefono);
        panel.add(new JLabel());
        panel.add(btnBuscar);
        
        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });
    }

    private void buscarCliente() {
        String nombre = txtNombre.getText().trim().toLowerCase();
        String telefono = txtTelefono.getText().trim();
        
        if (!telefono.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "El teléfono debe contener exactamente 10 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Simulación de búsqueda en base de datos
        String resultado = "Cliente encontrado:\nNombre: " + nombre + "\nTeléfono: " + telefono;
        txtResultados.setText(resultado);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BuscarCliente().setVisible(true));
    }
}

