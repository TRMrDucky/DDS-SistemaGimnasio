/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import dtos.ClienteDTO;
import dtos.ClienteRegConMemYServDTO;
import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.PagoDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import excepciones.ConsultaDatosClienteException;
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

    public ControlNavegacionCompraMembresia(IManejadorComprasMembresias subsistema){
        this.subsistema = subsistema;
    }
    
    /**
     * Genera una nueva instancia de registrarCliente
     */
    public void openFormRegistrarCliente() {
        RegistrarCliente rc = new RegistrarCliente(this);
        rc.setVisible(true);
    }

    /**
     * Abre una nueva pantalla de buscarCliente
     */
    public void openFormBuscarCliente() {
        BuscarCliente bc = new BuscarCliente(this);
        bc.setVisible(true);
    }

    /**
     * Genera una nueva instancia de seleccionarMembresia
     */
    public void seleccionarMembresia(ClienteRegistradoDTO cliente) {
        SeleccionarMembresia sm = new SeleccionarMembresia(this, cliente);
        sm.setVisible(true);
    }

    /**
     * Genera una nueva instancia de seleccionarMembresia
     */
    public void openFormSeleccionarMembresia(ClienteRegistradoDTO clienteRegistradoDTO) {
        SeleccionarMembresia em = new SeleccionarMembresia(this, clienteRegistradoDTO);
        em.setVisible(true);

    }

    /**
     * Devuelve la lista de clientes
     *
     * @return una lista con objetos del tipo Cliente
     */
    public List<ClienteRegistradoDTO> getListaClientes() {
        return subsistema.obtenerListaClientes();
    }
/**
 * Registra un cliente. Devuelve un ClienteRegistradoDTO. 
 * @param registrarClienteDTO DTO que representa los datos de un cliente a registrar
 * @return ClienteRegistradoDTO que representa los datos guardados del cliente y trae consigo el ID asignado para él
 */
    public ClienteRegistradoDTO registrarCliente(ClienteDTO registrarClienteDTO) {
        try {
            ClienteRegistradoDTO clienteRegistradoDTO = subsistema.registrarCliente(registrarClienteDTO);
            JOptionPane.showMessageDialog(null, clienteRegistradoDTO.toString(),
                    "Aviso", JOptionPane.INFORMATION_MESSAGE);
            return clienteRegistradoDTO;
        } catch (RegistroClienteException ex) {
            Logger.getLogger(RegistrarCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    
    
//    public ClienteRegConMembDTO clienteMembresia (ClienteRegistradoDTO clienteRegDTO, MembresiaSeleccionadaDTO membSeleccionadaDTO) {
//        
//        if (clienteRegDTO == null || membSeleccionadaDTO == null) {
//        JOptionPane.showMessageDialog(null, "Faltan datos para continuar", "Error", JOptionPane.ERROR_MESSAGE);
//        return null;
//        
//    }
//        
//        ClienteRegConMembDTO clienteConMembresia = new ClienteRegConMembDTO(  
//                
//                membSeleccionadaDTO.getTipoMembresia(),  
//                
//                clienteRegDTO.getId()
//       
//                );
//       
//
//        
//      JOptionPane.showMessageDialog(null, "Membresía asignada correctamente:\n" + 
//        "ID Cliente: " + clienteConMembresia.getIdCliente() + "\n" + 
//        "Membresía: " + clienteConMembresia.getTipoMembresia(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
//
//    return clienteConMembresia;
//}  
/**
 * metodo que abre el formulario de servicios extra
 * @param cliente 
 */
    public void openFormServiciosExtra(ClienteRegConMembDTO cliente) {
        ServiciosExtras se = new ServiciosExtras(this, cliente);
        se.setVisible(true);
    }
/**
 * metodo que setea el subsistema al atributo
 * @param subsistema 
 */
    public void setSubsistema(IManejadorComprasMembresias subsistema) {
        this.subsistema = subsistema;
    }
/**
 * metodo que obtiene los servicios extra
 * @return 
 */
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return subsistema.obtenerServiciosExtrasDTO();
    }
    
/**
 * metodo que muestra los servicios extras seleccionados
 * @param seleccionados 
 */
    public void mostrarServiciosSeleccionados(List<ServicioExtraDTO> seleccionados) {
        StringBuilder mensaje = new StringBuilder("Servicios seleccionados:\n");
        for (ServicioExtraDTO servicio : seleccionados) {
            mensaje.append(servicio.getNombreServicio()).append(" - Costo $").append(servicio.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Selección de Servicios", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * metodo que muestra si se completo el pago
     * @param cliente 
     * @param montoPagado 
     */
    public void mostrarPagoEnResumen(ClienteRegConMemYServDTO cliente, double montoPagado) {
        try {
            double total = cliente.getPrecio();
            if (montoPagado > total) {
                // Si el cliente pagó más, muestra el cambio a devolver
                double cambio = montoPagado - total;
                JOptionPane.showMessageDialog(null, "Pago completado. Cambio a devolver: $" + cambio, "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else if (montoPagado >= total) {
                JOptionPane.showMessageDialog(null, "Pago completado. No hay deuda pendiente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                double deuda = total - montoPagado;
                JOptionPane.showMessageDialog(null, "Pago parcial. Deuda restante: $" + deuda, "Pago Incompleto", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad válida.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retorna el los nombres del cliente con base a su ID
     *
     * @param id id del cliente
     * @return un string que representa el nombre completo
     */
    public String obtenerNombreCliente(int id) {
        try {
            return subsistema.obtenerNombreCliente(id);
        } catch (ConsultaDatosClienteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        return "";
    }
    /**
     * metodo que obtiene un cliente en especifico
     * @param id id del cliente a buscar
     * @return 
     */
    public ClienteRegistradoDTO obtenerCliente(int id) {
        return subsistema.buscarClienteporID(id);
    }

    /**
     * Retorna el numero de teléfono del cliente con base a su ID
     *
     * @param id id del cliente
     * @return un string que representa el numero de teléfono
     */
    public String obtenerNumeroCliente(int id) {
        try {
            return subsistema.obtenerNumeroCliente(id);
        } catch (ConsultaDatosClienteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                    JOptionPane.WARNING_MESSAGE);
        }
        return "";
    }
    
    /**
     * metodo que abre el formulario de resumen de compra
     * @param cliente 
     */
    public void openFormResumenCompra(ClienteRegConMemYServDTO cliente){
        new ResumenCompraFrame(this, cliente).setVisible(true);
    }
    
    
    public PagoDTO procesarPago(int idCliente, double monto) {
         return subsistema.procesarPago(idCliente, monto);
}
    
    public void procesarPago(ClienteRegConMemYServDTO cliente, double montoPagado) {
        mostrarPagoEnResumen(cliente, montoPagado);
}
    
    public List<TipoMembresiaDTO> obtenerListaMembresiasDTO(){
        return subsistema.obtenerMembresiasDTO();
    }

}
