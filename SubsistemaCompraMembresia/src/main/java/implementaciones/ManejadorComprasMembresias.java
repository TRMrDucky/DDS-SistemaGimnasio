package implementaciones;


import bos.FabricaBOs;
import bos.MembresiaBO;
import bos.RegistrarClienteBO;
import bos.ServicioExtraBO;
import clases.mock.Cliente;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoDTO;
import dtos.PagoDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.NegocioException;
import excepciones.RegistroClienteException;
import interfaces.IManejadorComprasMembresias;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 
 *
 * @author 52644
 */

public class ManejadorComprasMembresias implements IManejadorComprasMembresias {

    
    private List<TipoMembresiaDTO> listaMembresias;
    private ServicioExtraBO servicioExtraBO;
    private RegistrarClienteBO registrarClienteBO;
    private MembresiaBO membresiaBO;

    @Override
    public ClienteRegistradoDTO registrarCliente(ClienteDTO registrarClienteDTO) throws RegistroClienteException {
        if (registrarClienteDTO.getNombre().isBlank() || registrarClienteDTO.getApellido().isBlank()
                || registrarClienteDTO.getCorreo().isBlank() || registrarClienteDTO.getTelefono().isBlank()) {
            throw new RegistroClienteException("Ningun campo puede permanecer vacio");
        }

        if (!validarFormatoCorreo(registrarClienteDTO.getCorreo())) {
            throw new RegistroClienteException("Formato Email no valido");
        }

        if (validarRegistroCorreo(registrarClienteDTO.getCorreo())) {
            throw new RegistroClienteException("Correo ya registrado");
        }

        if (validarRegistroNumeroTelefonico(registrarClienteDTO.getTelefono())) {
            throw new RegistroClienteException("Numero telefonico ya registrado");
        }

        ClienteRegistradoDTO cliente = registrarClienteBO.registrarCliente(registrarClienteDTO);
        
        return cliente;
    }

    public ManejadorComprasMembresias() {
        this.servicioExtraBO = FabricaBOs.getInstanceServicioExtraBO();
        this.registrarClienteBO = FabricaBOs.getInstanceRegistrarClienteBO();
        this.membresiaBO= FabricaBOs.getInstanceMembresiaBO();
        
        

//        List<ServicioExtraDTO> servicios = new ArrayList();
//        listaMembresias = new LinkedList<>();
//        servicios.add(new ServicioExtraDTO(1, "Entrenador", 150));
//
//        listaMembresias.add(new TipoMembresiaDTO("Day Pass", 15));
//        listaMembresias.add(new TipoMembresiaDTO("7 dias", 105, servicios));
//
//        listaMembresias.add(new TipoMembresiaDTO("10 dias", 150, servicios));
//
//        listaMembresias.add(new TipoMembresiaDTO("15 dias", 225, servicios));
//
//        listaMembresias.add(new TipoMembresiaDTO("Mensual", 300));
//
//        listaMembresias.add(new TipoMembresiaDTO("Por visita", 13));
    }

    private boolean validarFormatoCorreo(String email) {
        Pattern patronEmail = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patronEmail.matcher(email);
        return matcher.matches();

    }

    private boolean validarRegistroCorreo(String email) {
        return registrarClienteBO.obtenerListaClientes().stream()
                .map(ClienteRegistradoDTO::getEmail)
                .filter(Objects::nonNull)
                .anyMatch(e -> e.equalsIgnoreCase(email));
    }

    private boolean validarRegistroNumeroTelefonico(String numeroTelefono) {
        return registrarClienteBO.obtenerListaClientes().stream()
                .map(ClienteRegistradoDTO::getNumeroTelefono)
                .filter(Objects::nonNull)
                .anyMatch(e -> e.equals(numeroTelefono));
    }

    
    //MODIFICADO
    @Override
    public List<ClienteDTO> getListaClientes() {
        return registrarClienteBO.obtenerListaClientes2();
    }

    @Override
    public List<TipoMembresiaDTO> getTiposMembresia() {
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
    public PagoDTO procesarPago(int idCliente, double monto) {
    
        boolean aprobado = new Random().nextBoolean(); 

        return new PagoDTO(idCliente, monto, aprobado);
    }

    @Override
    public List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return servicioExtraBO.obtenerServiciosExtrasDTO();
    }

    @Override
    public List<ClienteRegistradoDTO> obtenerListaClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String obtenerNombreCliente(int id) throws NegocioException {
        try {
            return registrarClienteBO.obtenerNombreCliente(id);
        } catch (NegocioException ex) {
            Logger.getLogger(ManejadorComprasMembresias.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new NegocioException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado");
    }

    @Override
    public String obtenerNumeroCliente(int id) throws NegocioException {
        try {
            return registrarClienteBO.obtenerNumeroCliente(id);
        } catch (NegocioException ex) {
            Logger.getLogger(ManejadorComprasMembresias.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new NegocioException("No se pudo cargar el numero del cliente porque el ID no fue encontrado");
    }

    @Override
    public ClienteRegistradoDTO buscarClienteporID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TipoMembresiaDTO> obtenerMembresiasDTO() {
       return membresiaBO.obtenerMembresiasDTO();
    }

   
    
    
    
}
