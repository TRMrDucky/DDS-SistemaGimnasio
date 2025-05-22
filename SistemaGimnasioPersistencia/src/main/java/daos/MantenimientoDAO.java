/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import clases.mock.Mantenimiento;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import dtos.HistorialEquipoDTO;
import excepciones.ConsultarMantenimientoException;
import excepciones.EliminarMantenimientoException;
import excepciones.RegistrarMantenimientoException;
import interfaces.dao.IMantenimientoDAO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * Clase de acceso a datos (DAO) para la entidad {@link Mantenimiento}.
 * Implementa la interfaz {@link IMantenimientoDAO} y sigue el patrón Singleton para garantizar 
 * una única instancia durante la ejecución.
 * 
 * Esta clase gestiona las operaciones relacionadas con los mantenimientos registrados en la base de datos MongoDB, 
 * incluyendo la inserción, consulta del historial por equipo y eliminación de mantenimientos por equipo.
 * 
 * @author Cricri
 */
public class MantenimientoDAO implements IMantenimientoDAO {
    
    /** Instancia única de la clase para implementar Singleton. */
    private static MantenimientoDAO instancia;

    /**
     * Constructor público (aunque por patrón Singleton, se recomienda usar {@link #getInstance()}).
     */
    public MantenimientoDAO() {
    }

    /**
     * Obtiene la instancia única de {@code MantenimientoDAO}.
     * 
     * @return instancia única de {@code MantenimientoDAO}.
     */
    public static MantenimientoDAO getInstance() {
        if (instancia == null) {
            instancia = new MantenimientoDAO();
        }
        return instancia;
    }

    /**
     * Registra un nuevo mantenimiento en la base de datos.
     * 
     * @param mantenimiento Objeto {@link Mantenimiento} que se desea registrar.
     * @return El mismo objeto {@code mantenimiento} registrado.
     * @throws RegistrarMantenimientoException Si ocurre algún error durante la inserción.
     */
    @Override
    public Mantenimiento registrarMantenimiento(Mantenimiento mantenimiento) throws RegistrarMantenimientoException {
        try {
            MongoCollection<Mantenimiento> coleccion = ConexionBD.getInstance().getCollection("mantenimientos", Mantenimiento.class);
            coleccion.insertOne(mantenimiento);
            return mantenimiento;
        } catch (Exception e) {
            throw new RegistrarMantenimientoException("Error al registrar el mantenimiento.", e);
        }
    }

    /**
     * Obtiene el historial de mantenimientos de un equipo específico, enriquecido con datos del equipo.
     * 
     * @param idEquipo ID del equipo en formato String (hexadecimal).
     * @return Lista de {@link HistorialEquipoDTO} con el historial de mantenimientos y detalles del equipo.
     * @throws ConsultarMantenimientoException Si ocurre algún error durante la consulta.
     */
    @Override
    public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws ConsultarMantenimientoException {
        List<HistorialEquipoDTO> historial = new ArrayList<>();

        try {
            MongoCollection<Mantenimiento> coleccion = ConexionBD.getInstance()
                .getCollection("mantenimientos", Mantenimiento.class);

            ObjectId objectIdEquipo = new ObjectId(idEquipo);

            List<Bson> pipeline = Arrays.asList(
                Aggregates.match(Filters.eq("idEquipo", objectIdEquipo)),
                Aggregates.lookup("equipos", "idEquipo", "_id", "equipoData"),
                Aggregates.unwind("$equipoData")
            );

            AggregateIterable<Document> resultados = coleccion.aggregate(pipeline, Document.class);

            for (Document doc : resultados) {
                String nombreMantenimiento = doc.getString("nombreMantenimiento");
                Date fechaMantenimiento = doc.getDate("fechaMantenimiento");
                Double costoDouble = doc.getDouble("costo");
                float costo = (costoDouble != null) ? costoDouble.floatValue() : 0f;
                String observaciones = doc.getString("observaciones");
                Date fechaSeguimiento = doc.getDate("fechaSeguimiento");

                Document equipoData = doc.get("equipoData", Document.class);
                String nombreEquipo = (equipoData != null) ? equipoData.getString("nombre") : "Desconocido";

                HistorialEquipoDTO dto = new HistorialEquipoDTO(
                    nombreMantenimiento,
                    fechaMantenimiento,
                    nombreEquipo,
                    costo,
                    observaciones,
                    fechaSeguimiento
                );

                historial.add(dto);
            }

        } catch (Exception e) {
            throw new ConsultarMantenimientoException("Error al consultar el historial de mantenimientos del equipo.", e);
        }

        return historial;
    }

    /**
     * Elimina todos los mantenimientos asociados a un equipo específico.
     * 
     * @param idEquipo ID del equipo en formato String (hexadecimal).
     * @return {@code true} si la eliminación fue reconocida por el servidor.
     * @throws EliminarMantenimientoException Si ocurre algún error durante la eliminación.
     */
    @Override
    public boolean eliminarMantenimientosPorEquipo(String idEquipo) throws EliminarMantenimientoException {
        try {
            MongoCollection<Mantenimiento> coleccion = ConexionBD.getInstance().getCollection("mantenimientos", Mantenimiento.class);
            ObjectId id = new ObjectId(idEquipo);
            DeleteResult result = coleccion.deleteMany(Filters.eq("idEquipo", id));
            return result.wasAcknowledged();
        } catch (Exception e) {
            throw new EliminarMantenimientoException("Error al eliminar mantenimientos del equipo.", e);
        }
    }
}
