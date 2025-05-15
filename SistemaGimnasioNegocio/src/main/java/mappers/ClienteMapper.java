/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.Cliente;
import clases.mock.Membresia;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoConMembListaDTO;
import dtos.ClienteRegistradoDTO;
import dtos.MembresiaPagadaDTO;
import dtos.ServicioExtraDTO;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ramón Zamudio
 */
public class ClienteMapper {
    public static Cliente toEntity(ClienteDTO cliente){
        return new Cliente(cliente.getNombre(), cliente.getApellido(), cliente.getCorreo(), cliente.getTelefono());
    }
    public static ClienteRegistradoDTO toDTO(Cliente cliente){
        return new ClienteRegistradoDTO(cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getNumeroTelefono(), cliente.getId().toString());
    }
    public static ClienteRegistradoDTO ClienteRegistradoToDTO(Cliente cliente){
        return new ClienteRegistradoDTO(cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getNumeroTelefono(), cliente.getId().toString());
    }
    public static List<ClienteRegistradoDTO>toListDTO(List<Cliente>clientes){
        List<ClienteRegistradoDTO>listaCLientesDTO = new LinkedList<>();
        for(Cliente cliente : clientes){
            listaCLientesDTO.add(new ClienteRegistradoDTO(cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getNumeroTelefono(), cliente.getId().toString()));
        }
        return listaCLientesDTO;
    }
    
    /**
     * Convierte una entidad Membresia a MembresiaPagadaDTO (incluye fechas).
     */
    public static MembresiaPagadaDTO toMembresiaPagadaDTO(Membresia m) {
        if (m == null) return null;
        List<ServicioExtraDTO> extrasDto = null;
        if (m.getServiciosExtra() != null) {
            extrasDto = m.getServiciosExtra().stream()
                .map(ServicioExtraMapper::toDTO)
                .collect(Collectors.toList());
        }

        return new MembresiaPagadaDTO(
            m.getNombre(),
            m.getId(),
            m.getPrecio(),
            extrasDto,
            m.getEstado(),
            m.getInicio(),
            m.getFin()
        );
    }

    public static ClienteRegistradoConMembListaDTO toCompletoDTO(Cliente c) {
        ClienteRegistradoDTO clienteDTO = ClienteRegistradoToDTO(c);

        List<MembresiaPagadaDTO> listaDTO = Collections.emptyList();
        List<Membresia> membresias = c.getMembresias();
        if (membresias != null && !membresias.isEmpty()) {
            listaDTO = membresias.stream()
                .map(ClienteMapper::toMembresiaPagadaDTO)
                .collect(Collectors.toList());
        }

         return new ClienteRegistradoConMembListaDTO(clienteDTO, listaDTO);
    }
}

    
   

