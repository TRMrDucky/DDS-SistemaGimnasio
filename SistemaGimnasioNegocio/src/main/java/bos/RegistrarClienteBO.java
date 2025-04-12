/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;


import clases.mock.Cliente;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoDTO;
import interfaces.dao.IClienteDAO;
import java.util.List;
import mappers.ClienteMapper;

/**
 *
 * @author 52644
 */
public class RegistrarClienteBO {

    IClienteDAO clienteDAO;
    
    public RegistrarClienteBO(IClienteDAO clienteDAO){
     this.clienteDAO = clienteDAO;   
    }
    
    public ClienteRegistradoDTO registrarCliente(ClienteDTO cliente){
        Cliente clienteRegistrar = ClienteMapper.toEntity(cliente);
        Cliente clienteRegistrado = clienteDAO.registrarCliente(clienteRegistrar);
        ClienteRegistradoDTO clienteRegistradoDTO = ClienteMapper.ClienteRegistradoToDTO(clienteRegistrado);
        return clienteRegistradoDTO;
    }

    
    public List<ClienteDTO> obtenerListaClientes(){
        List<Cliente> listaClientes = clienteDAO.obtenerListaClientes();
        List<ClienteDTO> listaClientesDTO = ClienteMapper.toListDTO(listaClientes);
        return listaClientesDTO;
    } 
}
