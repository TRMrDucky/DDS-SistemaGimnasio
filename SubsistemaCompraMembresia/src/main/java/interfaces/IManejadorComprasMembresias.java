/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import clasesmock.Cliente;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.RegistroClienteException;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IManejadorComprasMembresias {

    public abstract ClienteRegistradoDTO registrarCliente(RegistrarClienteDTO registrarClienteDTO) throws RegistroClienteException;

    public abstract List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono);

    public abstract List<Cliente> getListaClientes();

    public abstract List<ServicioExtraDTO> obtenerServiciosExtrasDTO();

    public abstract List<TipoMembresiaDTO> getTiposMembresia();
    
    public abstract List<Cliente> obtenerListaClientes();
    
    public abstract String obtenerNombreCliente(int id) throws ConsultaDatosClienteException;
    
    public abstract String obtenerNumeroCliente(int id) throws ConsultaDatosClienteException;
    
    public abstract ClienteRegistradoDTO buscarClienteporID(int id);
}
