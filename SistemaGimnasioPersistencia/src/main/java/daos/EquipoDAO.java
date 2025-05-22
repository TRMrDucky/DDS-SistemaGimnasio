/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import clases.mock.Equipo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.result.DeleteResult;

import excepciones.AgregarEquipoException;
import excepciones.ConsultarEquipoException;
import excepciones.EliminarEquipoException;
import interfaces.dao.IEquipoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos (DAO) para la entidad {@link Equipo}.
 * Implementa la interfaz {@link IEquipoDAO} y sigue el patrón Singleton para 
 * garantizar una única instancia durante la ejecución.
 * 
 * Esta clase se encarga de realizar operaciones CRUD (crear, leer, eliminar) 
 * sobre la colección "equipos" en la base de datos MongoDB.
 * 
 * @author Cricri
 */
public class EquipoDAO implements IEquipoDAO {
    
    /** Instancia única de la clase para implementar Singleton. */
    private static EquipoDAO instancia;

    /**
     * Constructor privado para evitar instanciación externa.
     */
    private EquipoDAO() {
    }

    /**
     * Obtiene la instancia única de {@code EquipoDAO}.
     * 
     * @return instancia única de {@code EquipoDAO}.
     */
    public static EquipoDAO getInstance() {
        if (instancia == null) {
            instancia = new EquipoDAO();
        }
        return instancia;
    }

    /**
     * Obtiene la lista completa de equipos almacenados en la base de datos.
     * 
     * @return Lista de objetos {@link Equipo} existentes.
     * @throws ConsultarEquipoException Si ocurre algún error durante la consulta.
     */
    @Override
    public List<Equipo> obtenerEquipos() throws ConsultarEquipoException {
        try {
            MongoCollection<Equipo> coleccion = ConexionBD.getInstance().getCollection("equipos", Equipo.class);
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new ConsultarEquipoException("Error al consultar los equipos", e);
        }
    }

    /**
     * Busca equipos que coincidan con un filtro en los campos nombre, número de serie o marca.
     * La búsqueda es insensible a mayúsculas y minúsculas.
     * 
     * @param filtro Cadena con el patrón a buscar.
     * @return Lista de equipos que coinciden con el filtro.
     * @throws ConsultarEquipoException Si ocurre algún error durante la consulta.
     */
    @Override
    public List<Equipo> buscarEquiposPorFiltro(String filtro) throws ConsultarEquipoException {
        try {
            MongoCollection<Equipo> coleccion = ConexionBD.getInstance().getCollection("equipos", Equipo.class);
            Pattern patron = Pattern.compile(filtro, Pattern.CASE_INSENSITIVE);

            Bson filtroBusqueda = Filters.or(
                Filters.regex("nombre", patron),
                Filters.regex("numeroSerie", patron),
                Filters.regex("marca", patron)
            );

            return coleccion.find(filtroBusqueda).into(new ArrayList<>());
        } catch (Exception e) {
            throw new ConsultarEquipoException("Error al buscar equipos por filtro", e);
        }
    }

    /**
     * Obtiene un equipo específico dado su ID.
     * 
     * @param id ID del equipo en formato String (hexadecimal).
     * @return Objeto {@link Equipo} correspondiente al ID, o {@code null} si no existe.
     * @throws ConsultarEquipoException Si ocurre algún error durante la consulta.
     */
    @Override
    public Equipo obtenerEquipo(String id) throws ConsultarEquipoException {
        try {
            MongoCollection<Equipo> coleccion = ConexionBD.getInstance().getCollection("equipos", Equipo.class);
            ObjectId idHex = new ObjectId(id);
            return coleccion.find(Filters.eq("_id", idHex)).first();
        } catch (Exception e) {
            throw new ConsultarEquipoException("Error al consultar el equipo por ID", e);
        }
    }

    /**
     * Agrega un nuevo equipo a la base de datos.
     * 
     * @param equipo Objeto {@link Equipo} a insertar.
     * @return El mismo objeto {@code equipo} insertado.
     * @throws AgregarEquipoException Si ocurre algún error durante la inserción.
     */
    @Override
    public Equipo agregarEquipo(Equipo equipo) throws AgregarEquipoException {
        try {
            MongoCollection<Equipo> coleccion = ConexionBD.getInstance().getCollection("equipos", Equipo.class);
            coleccion.insertOne(equipo);
            return equipo;
        } catch (Exception e) {
            throw new AgregarEquipoException("Error al agregar equipo a la base de datos", e);
        }
    }

    /**
     * Elimina un equipo dado su ID.
     * 
     * @param id ID del equipo en formato String (hexadecimal).
     * @return {@code true} si la eliminación fue exitosa y reconocida por el servidor.
     * @throws EliminarEquipoException Si ocurre algún error durante la eliminación o no fue reconocida.
     */
    @Override
    public boolean eliminarEquipo(String id) throws EliminarEquipoException {
        try {
            MongoCollection<Equipo> coleccion = ConexionBD.getInstance().getCollection("equipos", Equipo.class);
            ObjectId idHex = new ObjectId(id);
            DeleteResult result = coleccion.deleteOne(Filters.eq("_id", idHex));
            if (!result.wasAcknowledged()) {
                throw new EliminarEquipoException("La eliminación no fue reconocida por el servidor");
            }
            return true;
        } catch (Exception e) {
            throw new EliminarEquipoException("Error al eliminar equipo de la base de datos", e);
        }
    }
}
