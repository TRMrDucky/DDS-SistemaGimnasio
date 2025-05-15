/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import Enums.MetodosPagoEnum;
import dtos.ClienteDTO;
import dtos.ClienteRegConMemYServDTO;
import dtos.ClienteRegConMembDTO;
import dtos.ClienteRegistradoConMembListaDTO;
import dtos.ClienteRegistradoDTO;
import dtos.PagoDTO;
import dtos.ServicioExtraDTO;
import dtos.MembresiaDTO;
import excepciones.DuracionException;
import excepciones.NegocioException;
import excepciones.NombreVacioException;
import excepciones.PrecioVacioException;
import excepciones.RegistroClienteException;
import excepciones.SubsistemaMembresiaException;
import excepciones.SubsistemaServicioExtraException;
import interfaces.IManejadorComprasMembresias;
import interfaz.IManejadorMembresia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import interfaz.IManejadorServicioExtra;

/**
 *
 * @author 52644
 */
public class ControlNavegacionCompraMembresia {

    private IManejadorComprasMembresias subsistema;
    private IManejadorServicioExtra subsistema2;
    private IManejadorMembresia subsistemaMembresias;
   
    
    public ControlNavegacionCompraMembresia(IManejadorComprasMembresias subsistema,IManejadorServicioExtra subsistema2 , IManejadorMembresia subsistemaMembresias){
        this.subsistema = subsistema;
        this.subsistema2 = subsistema2;
        this.subsistemaMembresias= subsistemaMembresias;
        
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
//    public void seleccionarMembresia(ClienteRegistradoDTO cliente) {
//        SeleccionarMembresia sm = new SeleccionarMembresia(this, cliente);
//        sm.setVisible(true);
//    }

    /**
     * Genera una nueva instancia de seleccionarMembresia
     */
    public void openFormOpcionesMembresia(ClienteRegistradoDTO cliente) {
        OpcionesMemb em = new OpcionesMemb(this, cliente);
        em.setVisible(true);
//
    }
    
    public void openFormAgregarMembresia(){
        new AgregarMembresia(this).setVisible(true);
    }
    
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws SubsistemaMembresiaException, NombreVacioException, PrecioVacioException, DuracionException{
        System.out.println("llega");
        return subsistemaMembresias.agregarMembresia(membresia);
       
    }
    
    public void openFormOpcionesModuloMembresia(){
        new SeleccionarOpcionMemb(this).setVisible(true);
    }

    /**
     * Devuelve la lista de clientes
     *
     * @return una lista con objetos del tipo Cliente
     */
    
    //MODIFICADO
    public List<ClienteRegistradoDTO> getListaClientes() {
        return subsistema.getListaClientes();
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
    public void mostrarPagoEnResumen(double totalPagar, double montoPagado) {
        try {
            double total = totalPagar;
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
    public String obtenerNombreCliente(String id) {
        System.out.println(id);
        try {
            return subsistema.obtenerNombreCliente(id);
        } catch (NegocioException e) {
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
    public ClienteRegistradoDTO obtenerCliente(String id) {
        return subsistema.buscarClienteporID(id);
    }

    /**
     * Retorna el numero de teléfono del cliente con base a su ID
     *
     * @param id id del cliente
     * @return un string que representa el numero de teléfono
     */
    public String obtenerNumeroCliente(String id) {
         System.out.println(id);
        try {
            return subsistema.obtenerNumeroCliente(id);
        } catch (NegocioException e) {
            System.out.println("error "+ id);
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
    
    public void openFormPantallaPrincipal(){
        new PantallaPrincipal(this).setVisible(true);
    }
    
//    public void openFormOpcionesMembresia(ClienteRegistradoDTO cliente){
//        OpcionesMemb opcionesMemb= new OpcionesMemb(this);
//        opcionesMemb.setVisible(true);
//    }
    
    public PagoDTO procesarPago(int idCliente, double monto, MetodosPagoEnum metodo, Object datosPago) {
        return subsistema.procesarPago(idCliente, monto, metodo, datosPago);
    }

    
    public void procesarPago(double totalPagar, double montoPagado) {
        mostrarPagoEnResumen(totalPagar, montoPagado);
    }
    
    public List<MembresiaDTO> obtenerListaMembresiasDTO(){
        return subsistema.obtenerMembresiasDTO();
    }

    public void openFormSeleccionarOpcionSevicioExtra(){
        new SeleccionOpcionServicioExtra(this).setVisible(true);
    }
    public void openFormAgregarServicioExtra(){
        new AgregarServicioExtra(this).setVisible(true);
    }
    public void openFormSeleccionarServicioExtra(String origen){
        new SeleccionarServicioExtra(this, origen).setVisible(true);
    }
    public void openFormMostrarServiciosExtras(String origen, ServicioExtraDTO servicioExtra){
        new MostrarServiciosExtras(this, origen, servicioExtra).setVisible(true);
    }
    
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio) throws SubsistemaServicioExtraException {
        return subsistema2.agregarServicio(servicio);
    }
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio){
        try {
            return subsistema2.editarServicio(servicio);
        } catch (SubsistemaServicioExtraException ex) {
            
        }
        return null;
    }
    public boolean eliminarServicio(String id) throws SubsistemaServicioExtraException{
        return subsistema2.eliminarServicioExtra(id);
    }
    public void mostrarMensajeServiciosExtra(String origen) {
        String mensaje = "";

        switch (origen.toLowerCase()) {
            case "agregar":
                mensaje = "Servicio extra agregado correctamente.";
                break;
            case "editar":
                mensaje = "Servicio extra editado correctamente.";
                break;
            case "eliminar":
                mensaje = "Servicio extra eliminado correctamente.";
                break;
        }

        int opcion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Información",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Aceptar"},
                "Aceptar"
        );
    }
    
    public void mostrarMensajeErrorServiciosExtra(String origen) {
        String mensaje = "";

        switch (origen.toLowerCase()) {
            case "agregar":
                mensaje = "Hubo un error en la agregacion del servicio extra";
                break;
            case "editar":
                mensaje = "El servicio Extra no se pudo editar correctamente";
                break;
            case "eliminar":
                mensaje = "Error al eliminar el servicio extra";
                break;
        }

        int opcion = JOptionPane.showOptionDialog(
                null,
                mensaje,
                "Información",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                new Object[]{"Aceptar"},
                "Aceptar"
        );
    }

    public MembresiaDTO setearFecha(MembresiaDTO membresia) {
        return subsistema.setearFecha(membresia);
    }
    
    public MembresiaDTO agregarMembresiaCliente(MembresiaDTO membresa, String id){
        return subsistema.agregarMembresiaCliente(membresa, id);
    } 
    
    public ClienteRegistradoConMembListaDTO obtenerClienteCompletoPorId(String id) {
    try {
    
        return subsistema.obtenerClienteCompleto(id);
    } catch (NegocioException ex) {
   
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        return null;
    }
}

    
    
}
