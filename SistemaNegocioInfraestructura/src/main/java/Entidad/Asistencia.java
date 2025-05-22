/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import Conexion.ConexionBD;
import DTOs.AsistenciaDTO;
import DTOs.ReporteAsistenciaDTO;
import Excepciones.AsistenciaException;
import bos.FabricaBOs;
import clases.mock.Cliente;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dtos.ClienteRegistradoDTO;
import interfaces.bo.IRegistrarClienteBO;
import interfaces.infraestructura.IAsistencia;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author 52644
 */
public class Asistencia implements IAsistencia {

    private final String CAMPO_CORREO = "email";
    private final String CAMPO_TELEFONO = "numeroTelefono";
    private final String CAMPO_MEMBRESIAS = "membresias";
    private final String NOMBRE_COLECCION = "Clientes";
    private Map<String, List<Date>> asistencias;
    private static Asistencia instance;


    private Asistencia() {
        this.asistencias = new LinkedHashMap<>();
    }

    public static Asistencia getInstance() {
        if (instance == null) {
            instance = new Asistencia();
        }
        return instance;
    }

    @Override
    public AsistenciaDTO registrarAsistencia(String identificador) {
        String id;
        try {
            id = verificarUsuario(identificador);
            if (!asistencias.containsKey(id)) {
                asistencias.put(id, new LinkedList<>());
                asistencias.get(id).add(new Date());
                
                AsistenciaDTO asis = obtenerCliente(id);
                System.out.println(asis);
                return asis;

            }
        } catch (AsistenciaException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error al registr la asistencia", JOptionPane.ERROR_MESSAGE);
        }
        return null;

    }

    @Override
    public ReporteAsistenciaDTO generarReporteAsistencia(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String verificarUsuario(String identificador) throws AsistenciaException {

        MongoCollection<Cliente> coleccion = crearConexion();

        List<Document> filtros = new ArrayList<>();
        filtros.add(new Document(CAMPO_CORREO, identificador));
        filtros.add(new Document(CAMPO_TELEFONO, identificador));

        Document filtro = new Document("$or", filtros);

        FindIterable<Cliente> resultado = coleccion.find(filtro);

        Cliente cliente = resultado.first();

        if (cliente == null) {
            throw new AsistenciaException("Cliente no encontrado");
        }

        return cliente.getId().toString();
    }

    private boolean verificarMembresia(String id) {

        return false;
    }

    private AsistenciaDTO obtenerCliente(String ide) {
        MongoCollection<Cliente> coleccion = crearConexion();
        ObjectId id = new ObjectId(ide);
        FindIterable<Cliente> resultado = coleccion.find(new Document("_id", id));

        Cliente cliente = resultado.first();

        AsistenciaDTO asistencia = new AsistenciaDTO(cliente.getNombres(), cliente.getApellidos(), new Date());

        return asistencia;
    }

    private MongoCollection crearConexion() {
        MongoDatabase db = ConexionBD.getInstance();
        MongoCollection<Cliente> coleccion = db.getCollection(NOMBRE_COLECCION, Cliente.class);
        return coleccion;
    }

}
