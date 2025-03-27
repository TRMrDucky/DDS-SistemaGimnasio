/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.ClienteRegConMemYServDTO;
import dtos.ClienteRegConMembDTO;
import dtos.ServicioExtraDTO;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Ramón Zamudio
 */
public class ResumenCompraFrame extends JFrame {
    private ControlNavegacionCompraMembresia control;
    public ResumenCompraFrame(ControlNavegacionCompraMembresia control,ClienteRegConMemYServDTO cliente) {
        
        this.control = control;
        
        
        cargarFrame();
        
        cargarNombreCliente(control.obtenerNombreCliente(cliente.getIdCliente()));
        
        cargarTelefonoCliente(control.obtenerNumeroCliente(cliente.getIdCliente()));
        
        cargarPanelServicios(cliente);

        cargarLabelTotal(cliente);
        
        JTextField txtTotalPagado = cargarLabelTotalPagado();
        
        JButton btnPagar = new JButton("Pagar");
        btnPagar.setBounds(230, 300, 140, 40);
        btnPagar.setBackground(Color.GREEN);
        btnPagar.addActionListener(e -> {
            control.mostrarPagoEnResumen(cliente, txtTotalPagado);
            dispose();
        });
        add(btnPagar);

        JButton btnVolver = new JButton("← Volver");
        btnVolver.setBounds(10, 10, 100, 30);
        btnVolver.addActionListener(e -> {
            control.openFormServiciosExtra(new ClienteRegConMembDTO(cliente.getTipoMembresia(),
                    (double)cliente.getPrecio(), cliente.getServicios(), cliente.getIdCliente()));
            dispose();
        });
        add(btnVolver);
    }
    
    public void cargarFrame(){
        setTitle("Resumen de Compra");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(new Color(102, 178, 255));

        JLabel lblTitulo = new JLabel("Resumen de Compra", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(Color.MAGENTA);
        lblTitulo.setBounds(180, 10, 250, 30);
        add(lblTitulo);

    }
    
    public void cargarNombreCliente(String nombre){
        JLabel lblNombre = new JLabel("Nombre del cliente");
            lblNombre.setBounds(50, 50, 150, 20);
            add(lblNombre);
            JTextField txtNombre = new JTextField(nombre);
            txtNombre.setBounds(50, 70, 150, 25);
            txtNombre.setEditable(false);
            add(txtNombre);
    }
    
    public void cargarTelefonoCliente(String telefono){
        JLabel lblTelefono = new JLabel("Número Telefónico");
        lblTelefono.setBounds(350, 50, 150, 20);
        add(lblTelefono);
        JTextField txtTelefono = new JTextField(telefono);
        txtTelefono.setBounds(350, 70, 150, 25);
        txtTelefono.setEditable(false);
        add(txtTelefono);
    }
    
    public void cargarLabelTotal(ClienteRegConMemYServDTO cliente){
        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(350, 130, 100, 20);
        add(lblTotal);
        JTextField txtTotal = new JTextField("$" + cliente.getPrecio());
        txtTotal.setBounds(350, 150, 100, 25);
        txtTotal.setEditable(false);
        add(txtTotal);
    }
    
    public JTextField cargarLabelTotalPagado(){
        JLabel lblTotalPagado = new JLabel("Total pagado");
        lblTotalPagado.setBounds(350, 190, 100, 20);
        add(lblTotalPagado);
        JTextField txtTotalPagado = new JTextField();
        txtTotalPagado.setBounds(350, 210, 100, 25);
        add(txtTotalPagado);
        return txtTotalPagado;
    }
    
    public void cargarPanelServicios(ClienteRegConMemYServDTO cliente){
        JPanel panelServicios = new JPanel();
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));
        panelServicios.setBorder(BorderFactory.createTitledBorder("Membresía y Servicios Extras"));
        panelServicios.setBackground(new Color(204, 153, 255));
        panelServicios.setBounds(50, 110, 200, 150);
        
        List<ServicioExtraDTO> servicios = cliente.getServicios();
        if (servicios != null && !servicios.isEmpty()) {
            for (ServicioExtraDTO servicio : servicios) {
                panelServicios.add(new JLabel("- " + servicio.getNombreServicio()));
            }
        } else {
            panelServicios.add(new JLabel("Sin servicios adicionales"));
        }
        add(panelServicios);
    }
}
