/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import clases.mock.Cliente;
import excepciones.ConsultaDatosClienteException;
import interfaces.dao.IClienteDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 52644
 */
public class ClienteDAO implements IClienteDAO {

    private static ClienteDAO instancia;
    private int keyCliente = 4;
    private List<Cliente> listaClientes;

    private ClienteDAO() {
        listaClientes = new LinkedList<>();
        listaClientes = new LinkedList<>();
        listaClientes.add(new Cliente("Pedro", "Sola Meza",
                "pedro.sola@hotmail.com", "6441348130", 1));
        listaClientes.add(new Cliente("Vanessa Paola", "Solano Lopez",
                "vapo23@gmail.com", "6441385760", 2));
        listaClientes.add(new Cliente("Alondra Lizeth", "Aviles",
                "pedro.sola@hotmail.com", "6442878593", 3));
    }

    public static ClienteDAO getInstance() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) {
        System.out.println(cliente.getApellidos());
        System.out.println(cliente.getEmail());
        cliente.setId(keyCliente);
        keyCliente++;
        listaClientes.add(cliente);
        return cliente;

    }
    
    @Override
    public List<Cliente> obtenerListaClientes(){
        return this.listaClientes;
    }
    
    @Override
    public String obtenerNombreCliente(int id) throws ConsultaDatosClienteException {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c.getNombres() + "\n" + c.getApellidos();
            }
        }
        throw new ConsultaDatosClienteException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado");
    }
    
    @Override
    public String obtenerNumeroCliente(int id) throws ConsultaDatosClienteException {
        for (Cliente c : listaClientes) {
            if (c.getId() == id) {
                return c.getNumeroTelefono();
            }
        }
        throw new ConsultaDatosClienteException("No se pudo cargar el número telefónico del cliente porque el ID no fue encontrado");
    }
}
