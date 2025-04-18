/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Cliente;
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
}
