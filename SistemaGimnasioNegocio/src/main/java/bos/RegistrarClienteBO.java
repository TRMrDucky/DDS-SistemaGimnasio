/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;


import clases.mock.Cliente;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.NegocioException;
import interfaces.dao.IClienteDAO;
import java.util.List;
import java.util.stream.Collectors;
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
        System.out.println(cliente.getApellido());
        Cliente clienteRegistrar = ClienteMapper.toEntity(cliente);
        Cliente clienteRegistrado = clienteDAO.registrarCliente(clienteRegistrar);
        ClienteRegistradoDTO clienteRegistradoDTO = ClienteMapper.ClienteRegistradoToDTO(clienteRegistrado);
        return clienteRegistradoDTO;
    }
    
    //MODIFICADO
      public ClienteRegistradoDTO registrarCliente2(ClienteDTO clienteDTO) {
   
    Cliente clienteRegistrar = ClienteMapper.toEntity(clienteDTO);

  
    Cliente clienteRegistrado = clienteDAO.registrarCliente(clienteRegistrar);

    
    ClienteRegistradoDTO clienteRespuesta = ClienteMapper.toDTO(clienteRegistrado);

 
    return clienteRespuesta;
}

    
    public List<ClienteRegistradoDTO> obtenerListaClientes(){
        List<Cliente> listaClientes = clienteDAO.obtenerListaClientes();
        List<ClienteRegistradoDTO> listaClientesDTO = ClienteMapper.toListDTO(listaClientes);
        return listaClientesDTO;
    } 
    
        public List<ClienteRegistradoDTO> obtenerListaClientes2() {

        List<Cliente> listaClientes = clienteDAO.obtenerListaClientes();


        List<ClienteRegistradoDTO> listaClientesDTO = listaClientes.stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());


        return listaClientesDTO;
    }
        
    public String obtenerNombreCliente(int id) throws NegocioException{
        try{
            return clienteDAO.obtenerNombreCliente(id);
        }catch(ConsultaDatosClienteException e){
            throw new NegocioException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado", e.getCause());
        }
    }
    
    public String obtenerNumeroCliente(int id) throws NegocioException{
        try{
            return clienteDAO.obtenerNumeroCliente(id);
        }catch(ConsultaDatosClienteException e){
            throw new NegocioException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado", e.getCause());
        }
    }

}
