/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.ClienteRegistradoDTO;
import dtos.TipoMembresiaDTO;
import implementaciones.ManejadorComprasMembresias;
import interfaces.IManejadorComprasMembresias;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class SeleccionarMembresia extends JFrame {
    
    
    private JPanel panelMembresias;
    private IManejadorComprasMembresias subsistema;
    private ClienteRegistradoDTO cliente;
    
    
    
    public SeleccionarMembresia(ControlNavegacionCompraMembresia controlador, ClienteRegistradoDTO cliente) {
        this.subsistema = subsistema;
        this.cliente = cliente;
        subsistema = new ManejadorComprasMembresias();
        inicializarComponentes();
    }
    
    
    
     private void inicializarComponentes() {
        setTitle("Seleccionar Membresía");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelMembresias = new JPanel();
        panelMembresias.setLayout(new GridLayout(0, 1)); 

        cargarMembresias();

        add(new JScrollPane(panelMembresias), BorderLayout.CENTER);
        setVisible(true);
    }

    private void cargarMembresias() {
        List<TipoMembresiaDTO> listaMembresias = subsistema.getTiposMembresia();
        
        for (TipoMembresiaDTO membresia : listaMembresias) {
            JButton btnMembresia = new JButton(membresia.getTipoMembresia() + " Precio: $" + membresia.getPrecio()+membresia.getServiciosExtras());

            btnMembresia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Seleccionaste: " + membresia.getTipoMembresia());
                }
            });

            panelMembresias.add(btnMembresia);
        }

        panelMembresias.revalidate();
        panelMembresias.repaint();
    }

    public static void main(String[] args) {
     ControlNavegacionCompraMembresia controlador = new ControlNavegacionCompraMembresia(); 
    ClienteRegistradoDTO cliente = new ClienteRegistradoDTO("janeth", "galvan", "janeth@gmail.com", "6871616433", true, 1);

    SeleccionarMembresia ventana = new SeleccionarMembresia(controlador, cliente);
    ventana.setVisible(true);
    }
}