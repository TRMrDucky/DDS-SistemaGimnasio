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
 *
 * @author Cricri
 */
public class MantenimientoDAO implements IMantenimientoDAO {
    
     private static MantenimientoDAO instancia;

    private MantenimientoDAO() {
    }

    public static MantenimientoDAO getInstance() {
        if (instancia == null) {
            instancia = new MantenimientoDAO();
        }
        return instancia;
    }

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


        @Override
  public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws ConsultarMantenimientoException {
      List<HistorialEquipoDTO> historial = new ArrayList<>();

      try {
          MongoCollection<Document> coleccion = ConexionBD.getInstance().getCollection("mantenimientos", Document.class);

          ObjectId objectIdEquipo = new ObjectId(idEquipo);

          List<Bson> pipeline = Arrays.asList(
              Aggregates.match(Filters.eq("idEquipo", objectIdEquipo)),
              Aggregates.lookup("equipos", "idEquipo", "_id", "equipoData"),
              Aggregates.unwind("$equipoData")
          );

          AggregateIterable<Document> resultados = coleccion.aggregate(pipeline);

          for (Document doc : resultados) {
              String nombreMantenimiento = doc.getString("nombreMantenimiento");
              Date fechaMantenimiento = doc.getDate("fechaMantenimiento");
              float costo = doc.getDouble("costo").floatValue();
              String observaciones = doc.getString("observaciones");
              Date fechaSeguimiento = doc.getDate("fechaSeguimiento");

              Document equipoData = (Document) doc.get("equipoData");
              String nombreEquipo = equipoData != null ? equipoData.getString("nombreEquipo") : "Desconocido";

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


