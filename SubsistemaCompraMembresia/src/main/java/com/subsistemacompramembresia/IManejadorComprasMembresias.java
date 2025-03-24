/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.subsistemacompramembresia;

import clasesmock.Cliente;
import clasesmock.ServicioExtra;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import excepciones.RegistroClienteException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IManejadorComprasMembresias {

    public abstract ClienteRegistradoDTO registrarCliente(RegistrarClienteDTO registrarClienteDTO) throws RegistroClienteException;

    public abstract List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono);

    public abstract LinkedHashMap<Integer, Cliente> getListaClientes();

    public LinkedHashMap<Long, ServicioExtraDTO> obtenerServiciosExtrasDTO();

    public abstract LinkedHashMap<Integer, TipoMembresiaDTO> getTiposMembresia();
}
