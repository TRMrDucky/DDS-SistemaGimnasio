/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import clases.mock.Mantenimiento;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.InsertOneResult;
import excepciones.ConsultarMantenimientoException;
import excepciones.RegistrarMantenimientoException;
import interfaces.dao.IMantenimientoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Cricri
 */
public class MantenimientoDAO implements IMantenimientoDAO {
    
     private static MantenimientoDAO instancia;
    private final MongoCollection<Mantenimiento> coleccion;

    private MantenimientoDAO() {
        this.coleccion = ConexionBD.getInstance().getCollection("mantenimientos", Mantenimiento.class);
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
            InsertOneResult resultado = coleccion.insertOne(mantenimiento);
            if (!resultado.wasAcknowledged()) {
                throw new RegistrarMantenimientoException("La inserción no fue reconocida por el servidor.");
            }
            return mantenimiento;
        } catch (Exception e) {
            throw new RegistrarMantenimientoException("Error al registrar el mantenimiento.", e);
        }
    }

    
     @Override
    public List<Mantenimiento> obtenerHistorialPorEquipo(String idEquipo) throws ConsultarMantenimientoException {
        try {
            ObjectId id = new ObjectId(idEquipo);
            return coleccion.find(Filters.eq("idEquipo", id))
                            .into(new ArrayList<>());
        } catch (Exception e) {
            throw new ConsultarMantenimientoException("Error al consultar el historial de mantenimientos del equipo.", e);
        }
    }
}


