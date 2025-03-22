/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import clasesmock.Cliente;
import com.subsistemacompramembresia.IManejadorComprasMembresias;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import excepciones.RegistroClienteException;
import java.util.Collections;
import java.util.LinkedHashMap;
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
    private LinkedHashMap<Integer, Cliente> listaClientes;

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

        listaClientes.put(keyCliente, cliente);

        return new ClienteRegistradoDTO(registrarClienteDTO.getNombre(), registrarClienteDTO.getApellidos(),
                registrarClienteDTO.getEmail(), registrarClienteDTO.getNumeroTelefono(), keyCliente);
    }

    public ManejadorComprasMembresias() {
        listaClientes = new LinkedHashMap<>();
        listaClientes.put(1, new Cliente("Pedro", "Sola Meza",
                "pedro.sola@hotmail.com", "6441348130", 1));
        listaClientes.put(2, new Cliente("Vanessa Paola", "Solano Lopez",
                "vapo23@gmail.com", "6441385760", 2));
        listaClientes.put(3, new Cliente("Alondra Lizeth", "Aviles",
                "pedro.sola@hotmail.com", "6442878593", 3));
    }

    private boolean validarFormatoCorreo(String email) {
        Pattern patronEmail = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patronEmail.matcher(email);
        return matcher.matches();

    }

    private boolean validarRegistroCorreo(String email) {
        return listaClientes.values().stream()
                .map(Cliente::getEmail)
                .filter(Objects::nonNull)
                .anyMatch(e -> e.equalsIgnoreCase(email));
    }

    private boolean validarRegistroNumeroTelefonico(String numeroTelefono) {
        return listaClientes.values().stream()
                .map(Cliente::getNumeroTelefono)
                .filter(Objects::nonNull)
                .anyMatch(e -> e.equals(numeroTelefono));
    }
    
    public LinkedHashMap getListaClientes(){
        return listaClientes;
    }
    
    public List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono) {
    // Validar que los parámetros no sean null
    if (nombre == null || numeroTelefono == null) {
        return Collections.emptyList();
    }

    // Limpiar espacios extra y convertir a minúsculas para evitar errores de formato
    String nombreLimpio = nombre.trim().toLowerCase();
    String telefonoLimpio = numeroTelefono.trim();

    return listaClientes.values().stream()
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

}
    


