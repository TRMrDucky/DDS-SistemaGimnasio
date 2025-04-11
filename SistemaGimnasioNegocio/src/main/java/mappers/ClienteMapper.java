/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clasesmock.Cliente;
import dtos.ClienteDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class ClienteMapper {
    public static Cliente toEntity(ClienteDTO cliente){
        return new Cliente(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), 
                cliente.getCorreo(), cliente.getTelefono());
    }
    public static ClienteDTO toDTO(Cliente cliente){
        return new ClienteDTO(cliente.getNombres(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getEmail(), cliente.getNumeroTelefono());
    }
    public static List<ClienteDTO>toListDTO(List<Cliente>clientes){
        List<ClienteDTO>listaCLientesDTO = new LinkedList<>();
        for(Cliente cliente : clientes){
            listaCLientesDTO.add(new ClienteDTO(cliente.getNombres(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getEmail(), cliente.getNumeroTelefono()));
        }
        return listaCLientesDTO;
    }
}
