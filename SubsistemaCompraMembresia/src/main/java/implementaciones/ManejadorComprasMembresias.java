/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import clasesmock.Cliente;
import clasesmock.ServicioExtra;
import dtos.ClienteRegistradoDTO;
import dtos.PagoDTO;
import dtos.RegistrarClienteDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.RegistroClienteException;
import interfaces.IManejadorComprasMembresias;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * a
 * a
 *
 * @author 52644
 */
public class ManejadorComprasMembresias implements IManejadorComprasMembresias {

    private int keyCliente = 4;
    private List<Cliente> listaClientes;
    private List<ServicioExtra> listaserviciosExtras;
    private List<TipoMembresiaDTO> listaMembresias;

    @Override
    public ClienteRegistradoDTO registrarCliente(RegistrarClienteDTO registrarClienteDTO) throws RegistroClienteException {
        if (registrarClienteDTO.getNombre().isBlank() || registrarClienteDTO.getApellidos().isBlank()
                || registrarClienteDTO.getEmail().isBlank() || registrarClienteDTO.getNumeroTelefono().isBlank()) {
            throw new RegistroClienteException("Ningun campo puede permanecer vacio");
        }

        if (!validarFormatoCorreo(registrarClienteDTO.getEmail())) {
            throw new RegistroClienteException("Formato Email no valido");
        }

        if (validarRegistroCorreo(registrarClienteDTO.getEmail())) {
            throw new RegistroClienteException("Correo ya registrado");
        }

        if (validarRegistroNumeroTelefonico(registrarClienteDTO.getNumeroTelefono())) {
            throw new RegistroClienteException("Numero telefonico ya registrado");
        }

        Cliente cliente = new Cliente(registrarClienteDTO.getNombre(), registrarClienteDTO.getApellidos(),
                registrarClienteDTO.getEmail(), registrarClienteDTO.getNumeroTelefono(), keyCliente);

        listaClientes.add(cliente);

        ClienteRegistradoDTO clienteRegistrado = new ClienteRegistradoDTO(registrarClienteDTO.getNombre(), registrarClienteDTO.getApellidos(),
                registrarClienteDTO.getEmail(), registrarClienteDTO.getNumeroTelefono(), keyCliente);

        keyCliente++;

        return clienteRegistrado;
    }

    public ManejadorComprasMembresias() {
        listaClientes = new LinkedList<>();
        listaClientes.add(new Cliente("Pedro", "Sola Meza",
                "pedro.sola@hotmail.com", "6441348130", 1));
        listaClientes.add(new Cliente("Vanessa Paola", "Solano Lopez",
                "vapo23@gmail.com", "6441385760", 2));
        listaClientes.add(new Cliente("Alondra Lizeth", "Aviles",
                "pedro.sola@hotmail.com", "6442878593", 3));
        listaserviciosExtras = new LinkedList<>();
        listaserviciosExtras.add(new ServicioExtra(1, "Entrenador", 150));
        listaserviciosExtras.add(new ServicioExtra(2, "Plan Alimenticio", 150));
        listaserviciosExtras.add(new ServicioExtra(3, "Clases de yoga (Lu, Mi, Vi 6-7:30 AM)", 100));
        listaserviciosExtras.add(new ServicioExtra(4, "Spinning (Ma, Ju 6-7:30 AM)", 50));
        listaserviciosExtras.add(new ServicioExtra(5, "Masaje relajante", 200));
        listaserviciosExtras.add(new ServicioExtra(6, "Asesoría Nutricional", 180));

        List<ServicioExtraDTO> servicios = new ArrayList();
        listaMembresias = new LinkedList<>();
        servicios.add(new ServicioExtraDTO(1, "Entrenador", 150));

        listaMembresias.add(new TipoMembresiaDTO("Day Pass", 15));
        listaMembresias.add(new TipoMembresiaDTO("7 dias", 105, servicios));

        listaMembresias.add(new TipoMembresiaDTO("10 dias", 150, servicios));

        listaMembresias.add(new TipoMembresiaDTO("15 dias", 225, servicios));

        listaMembresias.add(new TipoMembresiaDTO("Mensual", 300));

        listaMembresias.add(new TipoMembresiaDTO("Por visita", 13));
    }

    private boolean validarFormatoCorreo(String email) {
        Pattern patronEmail = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patronEmail.matcher(email);
        return matcher.matches();

    }

    private boolean validarRegistroCorreo(String email) {
        return listaClientes.stream()
                .map(Cliente::getEmail)
                .filter(Objects::nonNull)
                .anyMatch(e -> e.equalsIgnoreCase(email));
    }

    private boolean validarRegistroNumeroTelefonico(String numeroTelefono) {
        return listaClientes.stream()
                .map(Cliente::getNumeroTelefono)
                .filter(Objects::nonNull)
                .anyMatch(e -> e.equals(numeroTelefono));
    }

    @Override
    public List getListaClientes() {
        return listaClientes;
    }

    @Override
    public List<TipoMembresiaDTO> getTiposMembresia() {
        return listaMembresias;
    }

    public List<Cliente> obtenerListaClientes() {
        return listaClientes;
    }

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
    public LinkedList<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return listaserviciosExtras.stream()
                .map(servicio -> new ServicioExtraDTO(
                (int) servicio.getId(),
                servicio.getNombreServicio(),
                servicio.getPrecio()))
                .collect(Collectors.toCollection(LinkedList::new));
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
    
   
    public PagoDTO procesarPago(int idCliente, double monto) {
    
        boolean aprobado = new Random().nextBoolean(); 

        return new PagoDTO(idCliente, monto, aprobado);
    }
    
    
    
}
