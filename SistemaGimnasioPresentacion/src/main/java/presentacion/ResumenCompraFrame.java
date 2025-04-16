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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Enums.MetodosPagoEnum;
import java.awt.GridLayout;
import javax.swing.JComboBox;
/**
 *
 * @author Ramón Zamudio
 */
public class ResumenCompraFrame extends JFrame {
 
    private ControlNavegacionCompraMembresia control;
    private JTextField txtTotalPagado;
    private JTextField txtMetodoPagoInfo;
    private JComboBox<String> comboMetodoPago;
    private JPanel panelMetodoPago;

    public ResumenCompraFrame(ControlNavegacionCompraMembresia control, ClienteRegConMemYServDTO cliente) {
        this.control = control;

        cargarFrame();
        cargarNombreCliente(control.obtenerNombreCliente(cliente.getIdCliente()));
        cargarTelefonoCliente(control.obtenerNumeroCliente(cliente.getIdCliente()));
        cargarPanelServicios(cliente);
        cargarLabelTotal(cliente);

        txtTotalPagado = cargarLabelTotalPagado();
        cargarMetodoPago();

        JButton btnPagar = new JButton("Pagar");
        btnPagar.setBounds(330, 320, 140, 40);
        btnPagar.setBackground(Color.GREEN);
        btnPagar.addActionListener(e -> {
            double montoPagado;
            try {
                montoPagado = Double.parseDouble(txtTotalPagado.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Ingrese un monto válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String metodo = (String) comboMetodoPago.getSelectedItem();
            String infoPago = txtMetodoPagoInfo.getText().trim();

            if (metodo.equals("PayPal") && !infoPago.contains("@")) {
                JOptionPane.showMessageDialog(this, "Ingrese un correo válido para PayPal.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (metodo.equals("Tarjeta de Crédito") && (infoPago.length() < 13 || !infoPago.matches("\\d+"))) {
                JOptionPane.showMessageDialog(this, "Ingrese un número de tarjeta válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (metodo.equals("Efectivo") && !infoPago.equalsIgnoreCase("efectivo")) {
                JOptionPane.showMessageDialog(this, "Confirme escribiendo 'efectivo' en el campo.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            control.procesarPago(cliente, montoPagado);
            control.openFormBuscarCliente();
            dispose();
        });
        add(btnPagar);

        JButton btnVolver = new JButton("← Volver");
        btnVolver.setBounds(10, 10, 100, 30);
        btnVolver.addActionListener(e -> {
            control.openFormServiciosExtra(new ClienteRegConMembDTO(
                cliente.getTipoMembresia(),
                cliente.getPrecio(),
                cliente.getServicios(),
                cliente.getIdCliente()
            ));
            dispose();
        });
        add(btnVolver);
    }

    public void cargarFrame() {
        setTitle("Resumen de Compra");
        setSize(600, 430);
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

    public void cargarNombreCliente(String nombre) {
        JLabel lblNombre = new JLabel("Nombre del cliente");
        lblNombre.setBounds(50, 50, 150, 20);
        add(lblNombre);
        JTextField txtNombre = new JTextField(nombre);
        txtNombre.setBounds(50, 70, 150, 25);
        txtNombre.setEditable(false);
        add(txtNombre);
    }

    public void cargarTelefonoCliente(String telefono) {
        JLabel lblTelefono = new JLabel("Número Telefónico");
        lblTelefono.setBounds(350, 50, 150, 20);
        add(lblTelefono);
        JTextField txtTelefono = new JTextField(telefono);
        txtTelefono.setBounds(350, 70, 150, 25);
        txtTelefono.setEditable(false);
        add(txtTelefono);
    }

    public void cargarLabelTotal(ClienteRegConMemYServDTO cliente) {
        JLabel lblTotal = new JLabel("Total");
        lblTotal.setBounds(350, 130, 100, 20);
        add(lblTotal);
        JTextField txtTotal = new JTextField("$" + cliente.getPrecio());
        txtTotal.setBounds(350, 150, 100, 25);
        txtTotal.setEditable(false);
        add(txtTotal);
    }

    public JTextField cargarLabelTotalPagado() {
        JLabel lblTotalPagado = new JLabel("Total pagado");
        lblTotalPagado.setBounds(350, 190, 100, 20);
        add(lblTotalPagado);
        JTextField txt = new JTextField();
        txt.setBounds(350, 210, 100, 25);
        add(txt);
        return txt;
    }

    public void cargarPanelServicios(ClienteRegConMemYServDTO cliente) {
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

  public void cargarMetodoPago() {
    JLabel lblMetodoPago = new JLabel("Método de Pago:");
    lblMetodoPago.setBounds(350, 250, 120, 20);
    add(lblMetodoPago);

    comboMetodoPago = new JComboBox<>(new String[]{"Efectivo", "Tarjeta de Crédito", "PayPal"});
    comboMetodoPago.setBounds(350, 270, 140, 25);
    add(comboMetodoPago);


    txtMetodoPagoInfo = new JTextField();

    panelMetodoPago = new JPanel();
    panelMetodoPago.setLayout(new BoxLayout(panelMetodoPago, BoxLayout.Y_AXIS));
    panelMetodoPago.setBounds(50, 270, 250, 90);
    add(panelMetodoPago);

    comboMetodoPago.addActionListener(e -> {
        String metodo = (String) comboMetodoPago.getSelectedItem();
        panelMetodoPago.removeAll();

        if (metodo.equals("PayPal")) {
            panelMetodoPago.add(new JLabel("Correo para PayPal:"));
            txtMetodoPagoInfo.setText(""); 
            panelMetodoPago.add(txtMetodoPagoInfo);
        } else if (metodo.equals("Tarjeta de Crédito")) {
            panelMetodoPago.add(new JLabel("Número de tarjeta (mín. 13 dígitos):"));
            txtMetodoPagoInfo.setText(""); 
            panelMetodoPago.add(txtMetodoPagoInfo); 
        } else if (metodo.equals("Efectivo")) {
            panelMetodoPago.add(new JLabel("Confirmar con palabra 'efectivo':"));
            txtMetodoPagoInfo.setText("");
            panelMetodoPago.add(txtMetodoPagoInfo);
        }

        panelMetodoPago.revalidate();
        panelMetodoPago.repaint();
    });
}
}