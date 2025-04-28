/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Enums.MetodosPagoEnum;
import clases.mock.Cliente;
import clases.mock.Membresia;
import dtos.ClienteRegistradoDTO;
import dtos.PagoDTO;
import dtos.ClienteDTO;
import dtos.ClienteRegistradoConMembListaDTO;
import dtos.ServicioExtraDTO;
import dtos.MembresiaDTO;
import excepciones.ConsultaDatosClienteException;
import excepciones.NegocioException;
import excepciones.RegistroClienteException;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IManejadorComprasMembresias {

    public abstract ClienteRegistradoDTO registrarCliente(ClienteDTO registrarClienteDTO) throws RegistroClienteException;

    public abstract List<ClienteRegistradoDTO> buscarCliente(String nombre, String numeroTelefono);
//MODIFICADO
    public abstract List<ClienteRegistradoDTO> getListaClientes();

   public abstract List<ServicioExtraDTO> obtenerServiciosExtrasDTO();

    public abstract List<MembresiaDTO> getTiposMembresia();
    
    public abstract List<ClienteRegistradoDTO> obtenerListaClientes();
    
    public abstract String obtenerNombreCliente(int id) throws NegocioException;
    
    public abstract String obtenerNumeroCliente(int id) throws NegocioException;
    
    public abstract ClienteRegistradoDTO buscarClienteporID(int id);
    
   // public abstract PagoDTO procesarPago (int idCliente, double monto);
   
    public abstract List<MembresiaDTO> obtenerMembresiasDTO();
    
    public PagoDTO procesarPago(int idCliente, double monto, MetodosPagoEnum metodo, Object datosPago);
    
    public abstract MembresiaDTO setearFecha(MembresiaDTO membresia);
    public abstract MembresiaDTO agregarMembresiaCliente(MembresiaDTO membresa, int id);
    
    
   public abstract  ClienteRegistradoConMembListaDTO obtenerClienteCompleto(int id) throws NegocioException;
}
