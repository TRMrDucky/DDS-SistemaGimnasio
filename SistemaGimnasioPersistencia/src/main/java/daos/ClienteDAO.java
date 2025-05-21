/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import clases.mock.Cliente;
import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import excepciones.AgregarMembresiaClienteException;
import excepciones.ConsultaDatosClienteException;
import excepciones.RegistroClienteException;
import interfaces.dao.IClienteDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author 52644
 */
public class ClienteDAO implements IClienteDAO {

    private final String NOMBRE_COLECCION = "Clientes";
    private final String CAMPO_NOMBRES = "nombres";
    private final String CAMPO_APELLIDO = "apellidos";
    private final String CAMPO_CORREO = "email";
    private final String CAMPO_TELEFONO = "numeroTelefono";
    private final String CAMPO_MEMBRESIAS = "membresias";

    private static ClienteDAO instancia;

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
        MongoCollection<Cliente> coleccion = crearConexion();
        List<Cliente> clientes = new ArrayList<>();
        coleccion.find().into(clientes);
        return clientes;
    }

    @Override
    public String obtenerNombreCliente(String id) throws ConsultaDatosClienteException {
        ObjectId oid = new ObjectId(id);
        MongoCollection<Cliente> coleccion = crearConexion();
        Cliente cliente = coleccion.find(Filters.eq("_id", oid)).first();

        if (cliente != null) {
            return cliente.getNombres() + "\n" + cliente.getApellidos();
        }

        throw new ConsultaDatosClienteException("No se pudo cargar el nombre del cliente porque el ID no fue encontrado");
    }

    @Override
    public String obtenerNumeroCliente(String id) throws ConsultaDatosClienteException {
        ObjectId oid = new ObjectId(id);
        MongoCollection<Cliente> coleccion = crearConexion();
        Cliente cliente = coleccion.find(Filters.eq("_id", oid)).first();

        if (cliente != null) {
            return cliente.getNumeroTelefono();
        }

        throw new ConsultaDatosClienteException("No se pudo cargar el número telefónico del cliente porque el ID no fue encontrado");
    }

    @Override
    public Cliente obtenerClienteCompleto(String id) throws ConsultaDatosClienteException {
        ObjectId oid = new ObjectId(id);
        MongoCollection<Cliente> coleccion = crearConexion();
        Cliente cliente = coleccion.find(Filters.eq("_id", oid)).first();

        if (cliente != null) {
            return cliente;
        }

        throw new ConsultaDatosClienteException("No se pudo cargar los datos del cliente porque el ID no fue encontrado: " + id);
    }

    @Override
    public Membresia agregarSiNoTiene(String id, Membresia membresia) throws AgregarMembresiaClienteException {
        try {
            ObjectId idCliente = new ObjectId(id);
            MongoCollection<Document> coleccionClientes = crearConexion();

            Document docMembresia = new Document()
                    .append("id", membresia.getId())
                    .append("nombre", membresia.getNombre())
                    .append("precio", membresia.getPrecio())
                    .append("estado", membresia.getEstado().toString())
                    .append("inicio", membresia.getInicio())
                    .append("fin", membresia.getFin())
                    .append("duracion", membresia.getDuracion());

            if (membresia.getServiciosExtra() != null) {
                List<Document> servicios = new ArrayList<>();
                for (ServicioExtra s : membresia.getServiciosExtra()) {
                    servicios.add(new Document("nombre", s.getNombreServicio()).append("precio", s.getPrecio()));
                }
                docMembresia.append("serviciosExtra", servicios);
            }

            coleccionClientes.updateOne(
                    Filters.eq("_id", idCliente),
                    Updates.push("membresias", docMembresia)
            );

            return membresia;
        } catch (Exception e) {
            throw new AgregarMembresiaClienteException("Error al agregar la membresia al cliente", e);
        }
    }

    @Override
    public Membresia actualizarSiTiene(Membresia membresia, String idCliente) throws AgregarMembresiaClienteException {
        try {
            MongoCollection<Document> coleccionClientes = crearConexion();
            ObjectId clienteId = new ObjectId(idCliente);
            ObjectId membresiaId = membresia.getId();
            Document nuevaMembresia = new Document()
                    .append("id", membresiaId)
                    .append("nombre", membresia.getNombre())
                    .append("precio", membresia.getPrecio())
                    .append("estado", membresia.getEstado().toString())
                    .append("inicio", membresia.getInicio())
                    .append("fin", membresia.getFin())
                    .append("duracion", membresia.getDuracion());
            if (membresia.getServiciosExtra() != null) {
                List<Document> extras = new ArrayList<>();
                for (ServicioExtra s : membresia.getServiciosExtra()) {
                    extras.add(new Document("nombre", s.getNombreServicio()).append("precio", s.getPrecio()).append("Deescripcion", s.getDescripcion()));
                }
                nuevaMembresia.append("serviciosExtra", extras);
            }
            coleccionClientes.updateOne(
                    Filters.and(
                            Filters.eq("_id", clienteId),
                            Filters.eq("membresias.id", membresiaId)
                    ),
                    Updates.set("membresias.$", nuevaMembresia)
            );
            return membresia;
        } catch (Exception e) {
            throw new AgregarMembresiaClienteException("Error al agregar la membresia al cliente", e);
        }
    }

    @Override
    public boolean validarSiTieneMem(Membresia membresia, String id) {
        ObjectId oidCliente = new ObjectId(id);
        ObjectId oidMembresia = membresia.getId();

        MongoCollection<Document> coleccion = crearConexion();
        Document cliente = coleccion.find(
                Filters.and(
                        Filters.eq("_id", oidCliente),
                        Filters.elemMatch("membresias", Filters.eq("id", oidMembresia))
                )
        ).first();
        return cliente != null;
    }

    @Override
    public Cliente eliminarCliente(Cliente cliente) {
        try {
            MongoCollection<Cliente> coleccion = crearConexion();

            Bson filtro = Filters.eq("_id", cliente.getId());

            Cliente clienteEliminado = coleccion.findOneAndDelete(filtro);

            if (clienteEliminado == null) {
                throw new RuntimeException("No se encontró el cliente con ID: " + cliente.getId());
            }

            return clienteEliminado;

        } catch (Exception e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            throw new RuntimeException("Error de base de datos", e);
        }
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) {

        try {
            if (!verificarCorreoActualizacion(cliente.getEmail())) {
                throw new Exception("Verificar correo");
            }
            if (!verificarTelefonoActualizacion(cliente.getNumeroTelefono())) {
                throw new Exception("Verificar teléfono");
            }
  
            FindOneAndUpdateOptions opciones = new FindOneAndUpdateOptions()
                .upsert(false);
                    
            Document updateSet = new Document();
            updateSet.append(CAMPO_NOMBRES, cliente.getNombres());
            updateSet.append(CAMPO_APELLIDO, cliente.getApellidos());
            updateSet.append(CAMPO_CORREO, cliente.getEmail());
            updateSet.append(CAMPO_TELEFONO, cliente.getNumeroTelefono());

            Document update = new Document("$set", updateSet);
            
            MongoCollection<Cliente> coleccion = crearConexion();

            Bson filtro = Filters.eq("_id", cliente.getId());

            Cliente clienteActualizado = coleccion.findOneAndUpdate(filtro, update, opciones);

            if (clienteActualizado == null) {
                throw new RuntimeException("No se encontró el cliente con ID: " + cliente.getId());
            }

            return clienteActualizado;

        } catch (Exception e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            throw new RuntimeException("Error de base de datos", e);
        }
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

    private boolean verificarCorreoActualizacion(String correo) {
        int encontrados = 0;
        MongoCollection<Cliente> coleccion = crearConexion();

        FindIterable<Cliente> resultado = coleccion.find(new Document(CAMPO_CORREO, correo));
        Cliente c = resultado.first();
        if (c == null) {
            return true;
        }

        for (Cliente cl : resultado) {
            encontrados += 1;
            if (encontrados >= 2) {
                return false;
            }
        }

        return true;
    }

    private boolean verificarTelefonoActualizacion(String telefono) {
        int encontrados = 0;
        MongoCollection<Cliente> coleccion = crearConexion();

        FindIterable<Cliente> resultado = coleccion.find(new Document(CAMPO_TELEFONO, telefono));
        Cliente c = resultado.first();
        if (c == null) {
            return true;
        }

        for (Cliente cl : resultado) {
            encontrados += 1;
            if (encontrados >= 2) {
                return false;
            }
        }

        return true;
    }

    private MongoCollection crearConexion() {
        MongoDatabase db = ConexionBD.getInstance();
        MongoCollection<Cliente> coleccion = db.getCollection(NOMBRE_COLECCION, Cliente.class);
        return coleccion;
    }

}
