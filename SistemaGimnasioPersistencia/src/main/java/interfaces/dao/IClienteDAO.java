/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Cliente;
import clases.mock.Membresia;
import excepciones.ConsultaDatosClienteException;
import excepciones.RegistroClienteException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author 52644
 */
public interface IClienteDAO {
    
    public abstract Cliente registrarCliente(Cliente cliente);
    public abstract List<Cliente> obtenerListaClientes();
    public String obtenerNombreCliente(String id) throws ConsultaDatosClienteException;
    public String obtenerNumeroCliente(String id) throws ConsultaDatosClienteException;
    public Cliente obtenerClienteCompleto(String id) throws ConsultaDatosClienteException ;
    public boolean validarSiTieneMem(Membresia membresia, String id);
    public Membresia actualizarSiTiene(Membresia membresia, String id);
    public Membresia agregarSiNoTiene(Membresia membresia, String id);

    public Cliente registrarClienteMongo(Cliente clienteRegistrar)throws RegistroClienteException;
}
