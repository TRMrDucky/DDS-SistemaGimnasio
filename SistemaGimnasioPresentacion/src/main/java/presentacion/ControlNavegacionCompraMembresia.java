/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import dtos.RegistrarClienteDTO;
import excepciones.RegistroClienteException;
import interfaces.IManejadorComprasMembresias;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 52644
 */
public class ControlNavegacionCompraMembresia {
				
    private IManejadorComprasMembresias subsistema;


    public static void openFormRegistrarCliente() {
        RegistrarCliente rc = new RegistrarCliente(this);
        rc.setVisible(true);
    }

    public static void openFormBuscarCliente(IManejadorComprasMembresias subsistema) {
        BuscarCliente bc = new BuscarCliente(subsistema);
        bc.setVisible(true);
    }

    public static void seleccionarMembresia(IManejadorComprasMembresias subsistema) {
        SeleccionarMembresia sm = new SeleccionarMembresia(subsistema);
        sm.setVisible(true);
    }

    public static void openFormSeleccionarMembresia(IManejadorComprasMembresias subsistema) {
        SeleccionarMembresia em = new SeleccionarMembresia(subsistema);
        em.setVisible(true);

    }

    public ClienteRegistradoDTO registrarCliente(RegistrarClienteDTO registrarClienteDTO) {
        try {
            ClienteRegistradoDTO clienteRegistradoDTO = subsistema.registrarCliente(registrarClienteDTO);
            JOptionPane.showMessageDialog(null, clienteRegistradoDTO.toString(),
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return clienteRegistradoDTO;
        } catch (RegistroClienteException ex) {
            Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    public static void openFormServiciosExtra(IManejadorComprasMembresias subsistema,ClienteRegConMembDTO cliente){
        ServiciosExtras se = new ServiciosExtras(subsistema, cliente);
        se.setVisible(true);
    }

    public void setSubsistema(IManejadorComprasMembresias subsistema){
        this.subsistema = subsistema;
    }
}
