/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.ClienteRegistradoDTO;
import dtos.ServicioExtraDTO;
import dtos.MembresiaDTO;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import dtos.ClienteRegConMembDTO;
import mappers.ServicioExtraMapper;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class SeleccionarMembresia extends JFrame {

    private JPanel panelMembresias;
    private ClienteRegistradoDTO cliente;
    private ControlNavegacionCompraMembresia control;
    private ClienteRegConMembDTO clienteMemb;

    public SeleccionarMembresia(ControlNavegacionCompraMembresia control, ClienteRegistradoDTO cliente) {
        this.control = control;
        this.cliente = cliente;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setTitle("Seleccionar Membresía");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        panelMembresias = new JPanel();
        panelMembresias.setLayout(new GridLayout(0, 1));

        cargarMembresias();

        add(new JScrollPane(panelMembresias), BorderLayout.CENTER);
        setVisible(true);
    }

    private void cargarMembresias() {
        List<MembresiaDTO> listaMembresias = control.obtenerListaMembresiasDTO();
        if (listaMembresias == null || listaMembresias.isEmpty()) {
            System.out.println("Membresias no disponibles");
            return;
        }

        for (MembresiaDTO membresia : listaMembresias) {
            String servicios = "";

//        List<ServicioExtraDTO> extras = membresia.getServiciosExtras();
//        if (extras != null && !extras.isEmpty()) {
//            StringBuilder sb = new StringBuilder("Incluye: ");
//            
//            
//            for (int i = 0; i < extras.size(); i++) {
//                sb.append(extras.get(i).getNombreServicio());
//                if (i < extras.size() - 1) {
//                    sb.append(", ");
//                }
//            }
//            servicios = sb.toString();
//        }
            String textoBoton = membresia.getNombre() + " - $" + membresia.getPrecio();
            if (!servicios.isEmpty()) {
                textoBoton += " (" + servicios + ")";
            }

            JButton btnMembresia = new JButton(textoBoton);

            btnMembresia.addActionListener(e -> {
                List<ServicioExtraDTO> serviciosExtras = membresia.getServiciosExtra();
                clienteMemb = new ClienteRegConMembDTO(
                        cliente,
                        membresia
                );

                String mensaje = "Seleccionaste la membresía: " + membresia.getNombre();

                JOptionPane.showMessageDialog(null, mensaje);

                control.openFormServiciosExtra(clienteMemb);
                dispose();
            });

            panelMembresias.add(btnMembresia);
        }

        panelMembresias.revalidate();
        panelMembresias.repaint();
    }

}
