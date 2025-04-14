/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.ClienteDTO;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.stream.Collectors;
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
    private ControlNavegacionCompraMembresia control;

    public BuscarCliente(ControlNavegacionCompraMembresia control) {
        this.control = control;
        setTitle("Búsqueda de Cliente");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        inicializarComponentes();
        agregarEventos();
        actualizarTabla(control.getListaClientes());
    }

    private void inicializarComponentes() {
        txtBusqueda = new JTextField();
        txtBusqueda.setToolTipText("Escriba el nombre del cliente...");
        add(txtBusqueda, BorderLayout.NORTH);

        modeloTabla = new DefaultTableModel(new String[]{ "Nombre", "Apellidos", "Teléfono", "Correo"}, 0);
        tablaClientes = new JTable(modeloTabla);
        add(new JScrollPane(tablaClientes), BorderLayout.CENTER);

        btnRegistrar = new JButton("Registrar Cliente");
        add(btnRegistrar, BorderLayout.SOUTH);
    }

    private void agregarEventos() {
        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                buscarClientes(txtBusqueda.getText().trim().toLowerCase());
            }
        });

        btnRegistrar.addActionListener(e -> registrarActionPerformed());
    }
    
    private void registrarActionPerformed() {
        control.openFormRegistrarCliente();
        dispose();
    }

    private void buscarClientes(String nombre) {
        // Filtrar la lista de ClienteDTO por nombre
        List<ClienteDTO> clientesFiltrados = control.getListaClientes().stream()
                .filter(cliente -> cliente.getNombre().toLowerCase().contains(nombre))
                .collect(Collectors.toList());
        actualizarTabla(clientesFiltrados);
    }

    private void actualizarTabla(List<ClienteDTO> clientes) {
        modeloTabla.setRowCount(0);
        for (ClienteDTO cliente : clientes) {
            modeloTabla.addRow(new Object[]{
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getCorreo()
                // Añadir la opción String.valueOf(cliente.getId) para mostrar el id al usuario del sistema
            });
        }
    }
}
