/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.bo;

import dtos.ClienteDTO;
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
    public abstract String obtenerNombreCliente(int id) throws NegocioException;
    public abstract String obtenerNumeroCliente(int id) throws NegocioException;
    public abstract MembresiaDTO agregarMembresia(MembresiaDTO membresia, int id);
}
