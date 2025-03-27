/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import clasesmock.Cliente;
import dtos.ClienteRegConMemYServDTO;
import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import dtos.ServicioExtraDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.RegistroClienteException;
import interfaces.IManejadorComprasMembresias;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 52644
 */
public class ControlNavegacionCompraMembresia {

    private IManejadorComprasMembresias subsistema;

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
        SeleccionarMembresia2 sm = new SeleccionarMembresia2(this, cliente);
        sm.setVisible(true);
    }

    /**
     * Genera una nueva instancia de seleccionarMembresia
     */
    public void openFormSeleccionarMembresia(ClienteRegistradoDTO clienteRegistradoDTO) {
        SeleccionarMembresia2 em = new SeleccionarMembresia2(this, clienteRegistradoDTO);
        em.setVisible(true);

    }

    /**
     * Devuelve la lista de clientes
     *
     * @return una lista con objetos del tipo Cliente
     */
    public List<Cliente> getListaClientes() {
        return subsistema.obtenerListaClientes();
    }
/**
 * Registra un cliente. Devuelve un ClienteRegistradoDTO. 
 * @param registrarClienteDTO DTO que representa los datos de un cliente a registrar
 * @return ClienteRegistradoDTO que representa los datos guardados del cliente y trae consigo el ID asignado para él
 */
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
        return new ClienteRegistradoDTO();
    }

    public void openFormServiciosExtra(ClienteRegConMembDTO cliente) {
        ServiciosExtras se = new ServiciosExtras(this, cliente);
        se.setVisible(true);
    }

    public void setSubsistema(IManejadorComprasMembresias subsistema) {
        this.subsistema = subsistema;
    }

    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return subsistema.obtenerServiciosExtrasDTO();
    }

    public void mostrarServiciosSeleccionados(List<ServicioExtraDTO> seleccionados) {
        StringBuilder mensaje = new StringBuilder("Servicios seleccionados:\n");
        for (ServicioExtraDTO servicio : seleccionados) {
            mensaje.append(servicio.getNombreServicio()).append(" - Costo $").append(servicio.getPrecio()).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Selección de Servicios", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarPagoEnResumen(ClienteRegConMemYServDTO cliente, JTextField txtTotalPagado) {
        try {
            double total = cliente.getPrecio();
            double pagado = Double.parseDouble(txtTotalPagado.getText());
            if (pagado > total) {
                // Si el cliente pagó más, muestra el cambio a devolver
                double cambio = pagado - total;
                JOptionPane.showMessageDialog(null, "Pago completado. Cambio a devolver: $" + cambio, "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else if (pagado >= total) {
                JOptionPane.showMessageDialog(null, "Pago completado. No hay deuda pendiente.", "Pago Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                double deuda = total - pagado;
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

}
