/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Cliente;
import clases.mock.Membresia;
import excepciones.ConsultaDatosClienteException;
import java.util.List;

/**
 *
 * @author 52644
 */
public interface IClienteDAO {
    
    public abstract Cliente registrarCliente(Cliente cliente);
    public abstract List<Cliente> obtenerListaClientes();
    public String obtenerNombreCliente(int id) throws ConsultaDatosClienteException;
    public String obtenerNumeroCliente(int id) throws ConsultaDatosClienteException;
    public Cliente obtenerClienteCompleto(int id) throws ConsultaDatosClienteException ;
    public boolean validarSiTieneMem(Membresia membresia, int id);
    public Membresia actualizarSiTiene(Membresia membresia, int id);
    public Membresia agregarSiNoTiene(Membresia membresia, int id);
}
