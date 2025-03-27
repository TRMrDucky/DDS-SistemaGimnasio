/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import clasesmock.Cliente;
import implementaciones.ManejadorComprasMembresias;
import interfaces.IManejadorComprasMembresias;
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

//         Cargar todos los clientes al inicio
        actualizarTabla(control.getListaClientes());

//          búsqueda en vivo
        txtBusqueda.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String nombre = txtBusqueda.getText().trim().toLowerCase();
                actualizarTabla(control.getListaClientes().stream()
                        .filter(cliente -> cliente.getNombres().toLowerCase().contains(nombre))
                        .collect(Collectors.toList()));
            }
        });

        //  botón para registrar cliente
        btnRegistrar.addActionListener(e -> {
        control.openFormRegistrarCliente();
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
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            IManejadorComprasMembresias subsistema = new ManejadorComprasMembresias();
            ControlNavegacionCompraMembresia control = new ControlNavegacionCompraMembresia();
            control.setSubsistema(subsistema);
            new BuscarCliente(control).setVisible(true);
        });
}
}