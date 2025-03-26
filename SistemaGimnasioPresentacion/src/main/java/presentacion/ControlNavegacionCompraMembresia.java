/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import clasesmock.Cliente;
import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import dtos.RegistrarClienteDTO;
import dtos.ServicioExtraDTO;
import excepciones.RegistroClienteException;
import interfaces.IManejadorComprasMembresias;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author 52644
 */
public class ControlNavegacionCompraMembresia {
				
    private IManejadorComprasMembresias subsistema;


    public void openFormRegistrarCliente() {
        RegistrarCliente rc = new RegistrarCliente(this);
        rc.setVisible(true);
    }
    
    public static void openFormBuscarCliente() {
        BuscarCliente bc = new BuscarCliente(this);
        bc.setVisible(true);
    }

    public void seleccionarMembresia(ClienteRegistradoDTO cliente) {
        SeleccionarMembresia sm = new SeleccionarMembresia(this, cliente);
       sm.setVisible(true);
    }

    public void openFormSeleccionarMembresia(ClienteRegistradoDTO clienteRegistradoDTO) {
        SeleccionarMembresia em = new SeleccionarMembresia(this, clienteRegistradoDTO);
        em.setVisible(true);

    }
    

        public List<Cliente> getListaClientes() {
        return subsistema.obtenerListaClientes();
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
    
    public void openFormServiciosExtra(ClienteRegConMembDTO cliente){
        ServiciosExtras se = new ServiciosExtras(this, cliente);
        se.setVisible(true);
    }

    public void setSubsistema(IManejadorComprasMembresias subsistema){
        this.subsistema = subsistema;
    }

    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO(){
        return subsistema.obtenerServiciosExtrasDTO();
    }
    
    public void mostrarServiciosSeleccionados(List<ServicioExtraDTO> seleccionados) {
        StringBuilder mensaje = new StringBuilder("Servicios seleccionados:\n");
        for (ServicioExtraDTO servicio : seleccionados) {
            mensaje.append(servicio.getNombreServicio()).append(" - Costo $").append(servicio.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Selección de Servicios", JOptionPane.INFORMATION_MESSAGE);
    }
}
