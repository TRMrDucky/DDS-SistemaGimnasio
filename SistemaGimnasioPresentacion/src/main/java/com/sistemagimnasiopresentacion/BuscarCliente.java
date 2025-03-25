/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import clasesmock.Cliente;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jose
 */
public class BuscarCliente extends JFrame {

    private JTextField txtBusqueda;
    private JTable tablaClientes;
    private DefaultTableModel modeloTabla;
    private JButton btnRegistrar;
    private IManejadorComprasMembresias subsistema;

    public BuscarCliente(IManejadorComprasMembresias subsistema) {

        this.subsistema = subsistema;

        setTitle("Búsqueda de Cliente");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //  búsqueda
        txtBusqueda = new JTextField();
        txtBusqueda.setToolTipText("Escriba el nombre del cliente...");
        add(txtBusqueda, BorderLayout.NORTH);

        //  mostrar clientes
        modeloTabla = new DefaultTableModel(new String[]{"ID", "Nombre", "Teléfono", "Correo"}, 0);
        tablaClientes = new JTable(modeloTabla);
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);

        // registro
        btnRegistrar = new JButton("Registrar Cliente");
        add(btnRegistrar, BorderLayout.SOUTH);

        // Cargar todos los clientes al inicio
        actualizarTabla(subsistema.getListaClientes().stream().toList());

        //  búsqueda en vivo
        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String nombre = txtBusqueda.getText().trim().toLowerCase();
                actualizarTabla(subsistema.getListaClientes().stream()
                        .filter(cliente -> cliente.getNombres().toLowerCase().contains(nombre))
                        .collect(Collectors.toList()));
            }
        });

        //  botón para registrar cliente
        btnRegistrar.addActionListener(e -> {
            ControlNavegacionCompraMembresia controlNavegacion = new ControlNavegacionCompraMembresia();
            controlNavegacion.openFormRegistrarCliente(this.subsistema);
        });
    }

    //  actualizar la tabla con los clientes
    private void actualizarTabla(List<Cliente> clientes) {
        modeloTabla.setRowCount(0); // limpia la tabla
        for (Cliente cliente : clientes) {
            modeloTabla.addRow(new Object[]{
                cliente.getId(),
                cliente.getNombres(),
                cliente.getNumeroTelefono(),
                cliente.getEmail()
            });
        }
    }

  
}
