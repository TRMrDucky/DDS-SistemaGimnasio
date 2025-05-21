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
import excepciones.AgregarMembresiaClienteException;
import excepciones.ConsultaDatosClienteException;
import excepciones.ModificarClienteException;
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
    public ClienteRegistradoDTO registrarCliente(ClienteDTO cliente) throws RegistroClienteException {
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
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia, String id) throws NegocioException {
        try {
            if (!clienteDAO.validarSiTieneMem(MembresiaMapper.toEntity(membresia), id)) {
                return MembresiaMapper.toDTO(clienteDAO.agregarSiNoTiene(id, MembresiaMapper.toEntity(membresia)));
            }
            return MembresiaMapper.toDTO(clienteDAO.actualizarSiTiene(MembresiaMapper.toEntity(membresia), id));
        } catch (AgregarMembresiaClienteException e) {
            throw new NegocioException("Error al agregar la membresia al cliete", e);
        }
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
    public ClienteRegistradoDTO eliminarCliente(ClienteRegistradoDTO cliente) throws ModificarClienteException {
        Cliente clieente = ClienteMapper.toEntityCompleto(cliente);
        Cliente cEliminar = clienteDAO.eliminarCliente(clieente);
        if (cEliminar == null) {
            throw new ModificarClienteException("No ha sido posible eliminar el cliente");
        }
        return ClienteMapper.toDTO(cEliminar);

    }

    @Override
    public ClienteRegistradoDTO actualizarCliente(ClienteRegistradoDTO cliente) throws ModificarClienteException {
        Cliente clieente = ClienteMapper.toEntityCompleto(cliente);
        Cliente cActualizar = clienteDAO.actualizarCliente(clieente);
        if (cActualizar == null) {
            throw new ModificarClienteException("No ha sido posible eliminar el cliente");
        }
        return ClienteMapper.toDTO(cActualizar);
    }
}
