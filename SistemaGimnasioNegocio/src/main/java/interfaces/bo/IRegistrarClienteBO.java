/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.bo;

import dtos.ClienteDTO;
import dtos.ClienteRegistradoConMembListaDTO;
import dtos.ClienteRegistradoDTO;
import dtos.MembresiaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IRegistrarClienteBO {
    public abstract ClienteRegistradoDTO registrarCliente(ClienteDTO cliente);
    public abstract List<ClienteRegistradoDTO> obtenerListaClientes();
    public abstract String obtenerNombreCliente(String id) throws NegocioException;
    public abstract String obtenerNumeroCliente(String id) throws NegocioException;
    public abstract MembresiaDTO agregarMembresia(MembresiaDTO membresia, String id);
    public abstract ClienteRegistradoConMembListaDTO obtenerClienteCompleto(String id) throws NegocioException;
    public abstract MembresiaDTO agregarMembresiaCliente(MembresiaDTO membresa, String id);
}
