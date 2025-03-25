/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import clasesmock.Cliente;
import clasesmock.ServicioExtra;
import com.subsistemacompramembresia.IManejadorComprasMembresias;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import excepciones.RegistroClienteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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

    private int keyCliente;
    private LinkedList<Cliente> listaClientes;
    private LinkedList<ServicioExtra> serviciosExtras;
    private LinkedList<TipoMembresiaDTO> tiposMembresia;

    @Override
    public ClienteRegistradoDTO registrarCliente(RegistrarClienteDTO registrarClienteDTO) throws RegistroClienteException {
        keyCliente = (int) Math.random()*100000;
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
        
        if(validarRegistroNumeroTelefonico(registrarClienteDTO.getNumeroTelefono())){
            throw new RegistroClienteException("Numero telefonico ya registrado");
        }
        
        Cliente cliente = new Cliente(registrarClienteDTO.getNombre(), registrarClienteDTO.getApellidos(),
                registrarClienteDTO.getEmail(), registrarClienteDTO.getNumeroTelefono(), keyCliente);

        listaClientes.add(cliente);

        return new ClienteRegistradoDTO(registrarClienteDTO.getNombre(), registrarClienteDTO.getApellidos(),
                registrarClienteDTO.getEmail(), registrarClienteDTO.getNumeroTelefono(), keyCliente);
    }

    public ManejadorComprasMembresias() {
        listaClientes = new LinkedList<>();
        listaClientes.add(1, new Cliente("Pedro", "Sola Meza",
                "pedro.sola@hotmail.com", "6441348130", 1));
        listaClientes.add(2, new Cliente("Vanessa Paola", "Solano Lopez",
                "vapo23@gmail.com", "6441385760", 2));
        listaClientes.add(3, new Cliente("Alondra Lizeth", "Aviles",
                "pedro.sola@hotmail.com", "6442878593", 3));
        serviciosExtras = new LinkedList<>();
        serviciosExtras.add(1, new ServicioExtra(1, "Entrenador", 150));
        serviciosExtras.add(2, new ServicioExtra(2, "Plan Alimenticio", 150));
        serviciosExtras.add(3, new ServicioExtra(3, "Clases de yoga (Lu, Mi, Vi 6-7:30 AM)", 100));
        serviciosExtras.add(4, new ServicioExtra(4, "Spinning (Ma, Ju 6-7:30 AM)", 50));
        serviciosExtras.add(5, new ServicioExtra(5, "Masaje relajante", 200));
        serviciosExtras.add(6, new ServicioExtra(6, "Asesoría Nutricional", 180));
        
        
         List<ServicioExtraDTO> servicios= new ArrayList();
         tiposMembresia = new LinkedList<>();
         servicios.add(new ServicioExtraDTO(1, "Entrenador", 150));


        
        
        tiposMembresia.add(1, new TipoMembresiaDTO("Day Pass", 15));
        tiposMembresia.add(2, new TipoMembresiaDTO("7 dias", 105, servicios));

        tiposMembresia.add(3, new TipoMembresiaDTO("10 dias", 150, servicios));

        tiposMembresia.add(4, new TipoMembresiaDTO("15 dias", 225, servicios));

        tiposMembresia.add(5, new TipoMembresiaDTO("Mensual", 300));
        
        tiposMembresia.add(6, new TipoMembresiaDTO("Por visita", 13));
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
    
    public LinkedList getListaClientes(){
        return listaClientes;
    }
    
    public LinkedList<TipoMembresiaDTO> getTiposMembresia() {
        return tiposMembresia;
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
            .filter(cliente -> cliente.getNombres().toLowerCase().contains(nombreLimpio) && 
                               cliente.getNumeroTelefono().equals(telefonoLimpio))
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
    return serviciosExtras.entrySet().stream()
            .collect(Collectors.toMap(
                    entry -> entry.getKey().longValue(), // Convertir la clave de Integer a Long
                    entry -> new ServicioExtraDTO(entry.getValue().getId(), 
                                                  entry.getValue().getNombreServicio(), 
                                                  entry.getValue().getPrecio()),
                    (oldValue, newValue) -> oldValue, // Manejo de colisiones (no debería haber)
                    LinkedHashMap::new // Especificar que queremos un LinkedHashMap
            ));
}
    
    
    
}


    


