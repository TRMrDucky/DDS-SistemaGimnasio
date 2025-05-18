package implementaciones;

import Enums.MetodosPagoEnum;
import ProcesadorPago.ProcesadorPago;
import bos.FabricaBOs;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoConMembListaDTO;
import dtos.ClienteRegistradoDTO;
import dtos.PagoDTO;
import dtos.ServicioExtraDTO;
import dtos.MembresiaDTO;
import excepciones.ConsultarServicioExtraNegocioException;
import excepciones.NegocioException;
import excepciones.RegistroClienteException;
import interfaces.IManejadorComprasMembresias;
import interfaces.bo.IMembresiaBO;
import interfaces.bo.IRegistrarClienteBO;
import interfaces.bo.IServicioExtraBO;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author 52644
 */
public class ManejadorComprasMembresias implements IManejadorComprasMembresias {

    private List<MembresiaDTO> listaMembresias;
    private IServicioExtraBO servicioExtraBO;
    private IRegistrarClienteBO registrarClienteBO;
    private IMembresiaBO membresiaBO;

    @Override
    public ClienteRegistradoDTO registrarCliente(ClienteDTO registrarClienteDTO) throws RegistroClienteException {
        try {
            if (registrarClienteDTO.getNombre().isBlank() || registrarClienteDTO.getApellido().isBlank()
                    || registrarClienteDTO.getCorreo().isBlank() || registrarClienteDTO.getTelefono().isBlank()) {
                throw new RegistroClienteException("Ningun campo puede permanecer vacio");
            }

            if (!validarFormatoCorreo(registrarClienteDTO.getCorreo())) {
                throw new RegistroClienteException("Formato Email no valido");
            }

            if (!validarTelefono(registrarClienteDTO.getTelefono())) {
                throw new RegistroClienteException("Verifica el numero de teléfono");
            }

            ClienteRegistradoDTO cliente = registrarClienteBO.registrarCliente(registrarClienteDTO);

            return cliente;

        } catch (RegistroClienteException e) {
            JOptionPane exception = new JOptionPane(e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public ManejadorComprasMembresias() {
        this.servicioExtraBO = FabricaBOs.getInstanceServicioExtraBO();
        this.registrarClienteBO = FabricaBOs.getInstanceRegistrarClienteBO();
        this.membresiaBO = FabricaBOs.getInstanceMembresiaBO();


    }

    private boolean validarFormatoCorreo(String email) {
        Pattern patronEmail = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patronEmail.matcher(email);
        return matcher.matches();

    }

    private boolean validarTelefono(String telefono) {
        Pattern patronTelefono = Pattern.compile(
                "^[0-9]{10}$");
        Matcher matcher = patronTelefono.matcher(telefono);
        return matcher.matches();
    }

    //MODIFICADO
    @Override
    public List<ClienteRegistradoDTO> getListaClientes() {
        return registrarClienteBO.obtenerListaClientes();
    }

    @Override
    public List<MembresiaDTO> getTiposMembresia() {
        return membresiaBO.obtenerMembresiasDTO();
    }


    /*
    @Override
    public List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono) {
        // Validar que los parámetros no sean null
        if (nombre == null || numeroTelefono == null) {
            return Collections.emptyList();
        }

        // Limpiar espacios extra y convertir a minúsculas para evitar errores de formato
        String nombreLimpio = nombre.trim().toLowerCase();
        String telefonoLimpio = numeroTelefono.trim();

        return listaClientes.stream()
                .filter(cliente -> cliente.getNombres() != null && cliente.getNumeroTelefono() != null)
                .filter(cliente -> cliente.getNombres().toLowerCase().contains(nombreLimpio)
                && cliente.getNumeroTelefono().equals(telefonoLimpio))
                .map(cliente -> new ClienteRegistradoDTO(
                cliente.getNombres(),
                cliente.getApellidos(),
                cliente.getEmail(),
                cliente.getNumeroTelefono(),
                cliente.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return servicioExtraBO.obtenerServiciosExtrasDTO();
    }

    @Override
    public String obtenerNombreCliente(int id) throws ConsultaDatosClienteException {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c.getNombres() + "\n" + c.getApellidos();
            }
        }
        throw new ConsultaDatosClienteException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado");
    }

    @Override
    public String obtenerNumeroCliente(int id) throws ConsultaDatosClienteException {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c.getNumeroTelefono();
            }
        }
        throw new ConsultaDatosClienteException("No se pudo cargar el número telefónico del cliente porque el ID no fue encontrado");
    }
    
    @Override
    public ClienteRegistradoDTO buscarClienteporID(int id) {
        return listaClientes.stream()
            .filter(cliente -> cliente.getId() == id) // Filtrar por ID
            .map(cliente -> new ClienteRegistradoDTO(
                    cliente.getNombres(),
                    cliente.getApellidos(),
                    cliente.getEmail(),
                    cliente.getNumeroTelefono(),
                    cliente.getId()))
            .findFirst() // Tomar solo el primer resultado (si existe)
            .orElse(null);
            
    }
    
     */
    @Override
    public List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        try {
            System.out.println("hola1");
            return servicioExtraBO.obtenerServiciosExtrasDTO();
        } catch (ConsultarServicioExtraNegocioException ex) {
            System.out.println("hola");
            return null;
        }
    }

    @Override
    public List<ClienteRegistradoDTO> obtenerListaClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obtenerNombreCliente(String id) throws NegocioException {
        try {
            return registrarClienteBO.obtenerNombreCliente(id);
        } catch (NegocioException ex) {
            Logger.getLogger(ManejadorComprasMembresias.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new NegocioException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado");
    }

    @Override
    public String obtenerNumeroCliente(String id) throws NegocioException {
        try {
            return registrarClienteBO.obtenerNumeroCliente(id);
        } catch (NegocioException ex) {
            Logger.getLogger(ManejadorComprasMembresias.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new NegocioException("No se pudo cargar el numero del cliente porque el ID no fue encontrado");
    }

    @Override
    public ClienteRegistradoDTO buscarClienteporID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<MembresiaDTO> obtenerMembresiasDTO() {
        return membresiaBO.obtenerMembresiasDTO();
    }

    public PagoDTO procesarPago(String idCliente, double monto, MetodosPagoEnum metodo, Object datosPago) {
        ProcesadorPago procesador = new ProcesadorPago();
        boolean aprobado = procesador.procesarPago(metodo, (int) monto, datosPago);

        return new PagoDTO(idCliente, monto, aprobado);
    }

    @Override
    public MembresiaDTO setearFecha(MembresiaDTO membresia) {
        return membresiaBO.setearFecha(membresia);
    }

    @Override
    public MembresiaDTO agregarMembresiaCliente(MembresiaDTO membresa, String id) {
        return registrarClienteBO.agregarMembresiaCliente(membresa, id);
    }

    @Override
    public ClienteRegistradoConMembListaDTO obtenerClienteCompleto(String id) throws NegocioException {
        try {

            return registrarClienteBO.obtenerClienteCompleto(id);
        } catch (NegocioException ex) {

            Logger.getLogger(ManejadorComprasMembresias.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("No se pudo cargar la información completa del cliente porque el ID no fue encontrado", ex);
        }

    }

    @Override
    public PagoDTO procesarPago(int idCliente, double monto, MetodosPagoEnum metodo, Object datosPago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
