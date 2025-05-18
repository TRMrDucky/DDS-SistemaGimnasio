/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Cliente;
import clases.mock.Membresia;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoConMembListaDTO;
import dtos.ClienteRegistradoDTO;
import dtos.MembresiaDTO;
import dtos.MembresiaPagadaDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.NegocioException;
import excepciones.RegistroClienteException;
import interfaces.bo.IRegistrarClienteBO;
import interfaces.dao.IClienteDAO;
import java.util.List;
import mappers.ClienteMapper;
import mappers.MembresiaMapper;

/**
 *
 * @author 52644
 */
public class RegistrarClienteBO implements IRegistrarClienteBO {

    IClienteDAO clienteDAO;

    public RegistrarClienteBO(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    @Override
    public ClienteRegistradoDTO registrarCliente(ClienteDTO cliente) throws RegistroClienteException{
        Cliente clienteRegistrar = ClienteMapper.toEntity(cliente);
        Cliente clienteRegistrado = clienteDAO.registrarClienteMongo(clienteRegistrar);
        ClienteRegistradoDTO clienteRegistradoDTO = ClienteMapper.ClienteRegistradoToDTO(clienteRegistrado);
        return clienteRegistradoDTO;
    }

    @Override
    public List<ClienteRegistradoDTO> obtenerListaClientes() {
        List<Cliente> listaClientes = clienteDAO.obtenerListaClientes();
        List<ClienteRegistradoDTO> listaClientesDTO = ClienteMapper.toListDTO(listaClientes);
        return listaClientesDTO;
    }
    @Override
    public String obtenerNombreCliente(String id) throws NegocioException {

        try {
            return clienteDAO.obtenerNombreCliente(id);
        } catch (ConsultaDatosClienteException e) {
            throw new NegocioException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado", e.getCause());
        }
    }

    @Override
    public String obtenerNumeroCliente(String id) throws NegocioException {
        try {
            return clienteDAO.obtenerNumeroCliente(id);
        } catch (ConsultaDatosClienteException e) {
            throw new NegocioException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado", e.getCause());
        }
    }

    @Override
    public MembresiaPagadaDTO agregarMembresia(MembresiaDTO membresia, String id) {
        if(!clienteDAO.validarSiTieneMem(MembresiaMapper.toEntity(membresia), id)){
            clienteDAO.agregarSiNoTiene(MembresiaMapper.toEntity(membresia), id);
        }
        clienteDAO.actualizarSiTiene(MembresiaMapper.toEntity(membresia), id);
        return null;
    }
    
        @Override
  public ClienteRegistradoConMembListaDTO obtenerClienteCompleto(String id) throws NegocioException {
      try {
          Cliente cliente = clienteDAO.obtenerClienteCompleto(id);
          return ClienteMapper.toCompletoDTO(cliente);
      } catch (ConsultaDatosClienteException e) {
          throw new NegocioException(
              "No se pudo cargar los datos completos del cliente porque el ID no fue encontrado: " + id,
              e
          );
      }
  }

    

    @Override
    public MembresiaDTO agregarMembresiaCliente(MembresiaDTO membresiaDTO, String id) {
        Membresia membresia = MembresiaMapper.toEntity(membresiaDTO);
        if(!clienteDAO.validarSiTieneMem(membresia, id)){
            return MembresiaMapper.toDTO(clienteDAO.agregarSiNoTiene(membresia, id));
        }
        return MembresiaMapper.toDTO(clienteDAO.actualizarSiTiene(membresia, id));
    }
}
