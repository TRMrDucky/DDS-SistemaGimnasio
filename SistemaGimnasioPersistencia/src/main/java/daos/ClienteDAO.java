/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import clases.mock.Cliente;
import clases.mock.Membresia;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import excepciones.ConsultaDatosClienteException;
import excepciones.RegistroClienteException;
import interfaces.dao.IClienteDAO;
import java.util.LinkedList;
import java.util.List;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author 52644
 */
public class ClienteDAO implements IClienteDAO {

    private final String NOMBRE_COLECCION = "Clientes";
    private final String CAMPO_NOMBRES = "Nombres";
    private final String CAMPO_APELLIDO = "Apellidos";
    private final String CAMPO_CORREO = "Correo";
    private final String CAMPO_TELEFONO = "Telefono";
    private final String CAMPO_MEMBRESIAS = "Membresias";

    private static ClienteDAO instancia;
    private int keyCliente = 4;
    private List<Cliente> listaClientes;

    private ClienteDAO() {
        listaClientes = new LinkedList<>();
        listaClientes.add(new Cliente("Pedro", "Sola Meza",
                "pedro.sola@hotmail.com", "6441348130", new ObjectId("68110d3cb41a0ec85044152e")));
        listaClientes.add(new Cliente("Vanessa Paola", "Solano Lopez",
                "vapo23@gmail.com", "6441385760",new ObjectId( "68110d3cb41a0ec85043152e")));
        listaClientes.add(new Cliente("Alondra Lizeth", "Aviles",
                "pedro.sola@hotmail.com", "6442878593", new ObjectId("68110d3cb41a0ec85044142e")));
    }

    public static ClienteDAO getInstance() {
        if (instancia == null) {
            instancia = new ClienteDAO();
        }
        return instancia;
    }

    @Override
    public Cliente registrarClienteMongo(Cliente cliente) throws RegistroClienteException {
        if (verificarCorreo(cliente.getEmail())) {
            throw new RegistroClienteException("Correo ya registrado");
        }
        if (verificarTelefono(cliente.getNumeroTelefono())) {
            throw new RegistroClienteException("Numero de teléfono ya registrado");
        }
        
        MongoCollection coleccion = crearConexion();
        Cliente c = new Cliente(cliente.getNombres(), cliente.getApellidos(), cliente.getEmail(), cliente.getNumeroTelefono());
        coleccion.insertOne(c);
        return c;
    }
    
    //todo
    @Override
    public List<Cliente> obtenerListaClientes() {
        return this.listaClientes;
    }

    @Override
    public String obtenerNombreCliente(String id) throws ConsultaDatosClienteException {
        ObjectId oid = new ObjectId(id);
        for (Cliente c : listaClientes) {
            if (c.getId() == oid) {
                return c.getNombres() + "\n" + c.getApellidos();
            }
        }
        throw new ConsultaDatosClienteException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado");
    }

    @Override
    public String obtenerNumeroCliente(String id) throws ConsultaDatosClienteException {
        ObjectId oid = new ObjectId(id);
        for (Cliente c : listaClientes) {
            if (c.getId() == oid) {
                return c.getNumeroTelefono();
            }
        }
        throw new ConsultaDatosClienteException("No se pudo cargar el número telefónico del cliente porque el ID no fue encontrado");
    }
    
    //todo
    @Override
    public Cliente obtenerClienteCompleto(String id) throws ConsultaDatosClienteException {
        ObjectId oid = new ObjectId(id);
        for (Cliente c : listaClientes) {
            if (c.getId() == oid) {
                return c;
            }
        }
        throw new ConsultaDatosClienteException(
                "No se pudo cargar los datos del cliente porque el ID no fue encontrado: " + id
        );
    }

    //todo
    public Membresia agregarSiNoTiene(Membresia membresia, String id) {
        ObjectId oid = new ObjectId(id);
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == oid) {
                cliente.getMembresias().add(membresia);
                return membresia;
            }
        }
        return null;
    }
    
    //todo
    public Membresia actualizarSiTiene(Membresia membresia, String id) {
        ObjectId oid = new ObjectId(id);
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == oid) {
                List<Membresia> membresias = cliente.getMembresias();
                for (int i = 0; i < membresias.size(); i++) {
                    if (membresias.get(i).getId() == membresia.getId()) {
                        membresias.set(i, membresia);
                        return membresia;
                    }
                }
            }
        }
        return null;
    }
    
    //todo
    @Override
    public boolean validarSiTieneMem(Membresia membresia, String id) {
        ObjectId oid = new ObjectId(id);
        for (Cliente cliente : listaClientes) {
            if (cliente.getId() == oid) {
                for (Membresia mem : cliente.getMembresias()) {
                    if (mem.getId() == membresia.getId()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public Cliente eliminarCliente(Cliente cliente){
         MongoCollection<Cliente> coleccion = crearConexion();
         Cliente clieente = coleccion.findOneAndDelete(new Document("_Id", cliente.getId()));
         return clieente;
    }
     
    private boolean verificarCorreo(String correo) {
        MongoCollection<Cliente> coleccion = crearConexion();

        FindIterable<Cliente> resultado = coleccion.find(new Document(CAMPO_CORREO, correo));

        Cliente cliente = resultado.first();

        return cliente != null;

    }

    private boolean verificarTelefono(String telefono) {

        MongoCollection<Cliente> coleccion = crearConexion();

        FindIterable<Cliente> resultado = coleccion.find(new Document(CAMPO_TELEFONO, telefono));

        Cliente cliente = resultado.first();

        return cliente != null;
    }

    private MongoCollection crearConexion() {
        MongoDatabase db = ConexionBD.getInstance();
        MongoCollection<Cliente> coleccion = db.getCollection(NOMBRE_COLECCION, Cliente.class);
        return coleccion;
    }

}
