/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidad;

import Conexion.ConexionBD;
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
import java.util.List;
import java.util.Map;
import org.bson.Document;

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
    private IRegistrarClienteBO RCBO;

    private Asistencia() {
        this.asistencias = new LinkedHashMap<>();
    }

    public Asistencia getInstance() {
        if (instance == null) {
            instance = new Asistencia();
            this.RCBO = FabricaBOs.getInstanceRegistrarClienteBO();
        }
        return instance;
    }

    @Override
    public ClienteRegistradoDTO registrarAsistencia(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void generarReporteAsistencia(String identificador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private String verificarUsuario(String identificador) {
        String id = "";
        
        MongoCollection<Cliente> coleccion = crearConexion();
        
        List<Document> filtros = new ArrayList<>();
        filtros.add(new Document(CAMPO_CORREO, identificador));
        filtros.add(new Document(CAMPO_TELEFONO, identificador));
        
        Document filtro = new Document("$or", filtros);
        
        FindIterable<Cliente> resultado = coleccion.find(filtro);

        Cliente cliente = resultado.first();
        
        if(cliente == null){
//            throw new AsistenciaException("Cliente no encontrado");
        }
  
        return cliente.getId().toString();
    }

    private boolean verificarMembresia(String id) {

        return false;
    }

    private MongoCollection crearConexion() {
        MongoDatabase db = ConexionBD.getInstance();
        MongoCollection<Cliente> coleccion = db.getCollection(NOMBRE_COLECCION, Cliente.class);
        return coleccion;
    }

}
