    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

/**
 *
 * @author Ramón Zamudio
 */
import dtos.ClienteRegConMemYServDTO;
import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.ServicioExtraDTO;
import implementaciones.ManejadorComprasMembresias;
import interfaces.IManejadorComprasMembresias;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
/**
 * clase que representa la pantalla para elegir servicios extra
 * @author Ramón Zamudio
 */
public class ServiciosExtras extends JFrame {

    private ControlNavegacionCompraMembresia control;
    private List<JCheckBox> checkBoxes;
    private List<ServicioExtraDTO> serviciosExtras;
    private double costoTotal;
    private JLabel lblCostoTotal;
    /**
     * metodo que crea el frame
     * @param control controlNavegacion
     * @param cliente DTO del cliente recibido de la pantalla anterior
     */
    public ServiciosExtras(ControlNavegacionCompraMembresia control, ClienteRegConMembDTO cliente) {
        this.control = control;
        this.serviciosExtras = control.obtenerServiciosExtrasDTO();
        this.costoTotal = 0.0;
        this.checkBoxes = new ArrayList<>();
        cargarFrame();
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(100, 149, 237));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Servicios Extras", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setForeground(Color.MAGENTA);
        panel.add(lblTitulo, BorderLayout.NORTH);

        JPanel serviciosPanel = new JPanel();
        serviciosPanel.setLayout(new GridLayout(0, 1, 10, 10));
        serviciosPanel.setBackground(new Color(100, 149, 237));

        LinkedList<Long> idsServiciosCliente = new LinkedList<>();
        
        if (cliente.getServicios() != null) {
            for (ServicioExtraDTO servicio : cliente.getServicios()) {
                idsServiciosCliente.add(servicio.getId());
            }
        } else {
            System.out.println("El cliente no tiene servicios extra.");
        }

        for (ServicioExtraDTO servicio : serviciosExtras) {
            JCheckBox checkBox = new JCheckBox(servicio.getNombreServicio() + " - Costo $" + servicio.getPrecio());
            checkBox.setActionCommand(String.valueOf(servicio.getId()));

            if (idsServiciosCliente.contains(servicio.getId())) {
                checkBox.setSelected(true);
                costoTotal += servicio.getPrecio();
            }

            checkBox.addActionListener(e -> actualizarCosto(checkBox, servicio.getPrecio()));
            checkBoxes.add(checkBox);
            serviciosPanel.add(checkBox);
        }

        JScrollPane scrollPane = new JScrollPane(serviciosPanel);
        scrollPane.setPreferredSize(new Dimension(300, 200));
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(new Color(100, 149, 237));
        centerPanel.add(scrollPane);

        panel.add(centerPanel, BorderLayout.CENTER);

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new FlowLayout());
        botonesPanel.setBackground(new Color(100, 149, 237));

        lblCostoTotal = new JLabel("Costo Total: $" + costoTotal);
        lblCostoTotal.setFont(new Font("Arial", Font.BOLD, 16));
        botonesPanel.add(lblCostoTotal);

        JButton btnCancelar = new JButton("Cancelar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnContinuar = new JButton("Continuar");

        botonesPanel.add(btnCancelar);
        botonesPanel.add(btnLimpiar);
        botonesPanel.add(btnContinuar);

        panel.add(botonesPanel, BorderLayout.SOUTH);
        add(panel);

        btnContinuar.addActionListener(e -> {
            List<ServicioExtraDTO> seleccionadosList = getServiciosSeleccionados();
            ClienteRegConMemYServDTO clienteConMembresia = new ClienteRegConMemYServDTO(cliente.getTipoMembresia(), cliente.getPrecio() + costoTotal, seleccionadosList, cliente.getIdCliente());
            control.mostrarServiciosSeleccionados(seleccionadosList);
            control.openFormResumenCompra(clienteConMembresia);
            dispose();
        });
        
        btnCancelar.addActionListener(e -> {
            ClienteRegistradoDTO cliente2 = control.obtenerCliente(cliente.getIdCliente());
            control.openFormSeleccionarMembresia(cliente2);
            dispose();
        });
        
        btnLimpiar.addActionListener(e -> limpiarSeleccion());
    }
    /**
     * metodo que carga el frame
     */
    public void cargarFrame() {
        setTitle("Servicios Extras");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }
    /**
     * meotdo que obtiene los servicios seleccionados por el cliente
     * @return regresa una lista de los servicios seleccionados
     */
    public List<ServicioExtraDTO> getServiciosSeleccionados() {
        List<ServicioExtraDTO> seleccionados = new LinkedList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                long id = Long.parseLong(checkBox.getActionCommand());
                seleccionados.add(serviciosExtras.stream()
                        .filter(servicio -> servicio.getId() == id)
                        .findFirst()
                        .orElse(null));
            }
        }
        return seleccionados;
    }
    /**
     * meotdo que actualiza el costo despues de marcar un checkBox
     * @param checkBox checkbox marcado
     * @param precio precio a sumar al total
     */
    private void actualizarCosto(JCheckBox checkBox, double precio) {
        if (checkBox.isSelected()) {
            costoTotal += precio;
        } else {
            costoTotal -= precio;
        }
        lblCostoTotal.setText("Costo Total: $" + costoTotal);
    }
    /**
     * metodo que quita la seleccion de todos los checkboxes
     */
    private void limpiarSeleccion() {
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                checkBox.setSelected(false);
            }
        }
        costoTotal = 0;
        lblCostoTotal.setText("Costo Total: $" + costoTotal);
    }
    
}

