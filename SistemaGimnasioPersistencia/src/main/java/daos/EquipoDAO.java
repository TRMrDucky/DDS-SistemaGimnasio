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
import com.mongodb.client.result.InsertOneResult;
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
 *
 * @author Cricri
 */
public class EquipoDAO implements IEquipoDAO {
    
    private static EquipoDAO instancia;
    private final MongoCollection<Equipo> coleccion;

    private EquipoDAO() {
        this.coleccion = ConexionBD.getInstance().getCollection("equipos", Equipo.class);
    }

    public static EquipoDAO getInstance() {
        if (instancia == null) {
            instancia = new EquipoDAO();
        }
        return instancia;
    }

    @Override
    public List<Equipo> obtenerEquipos() throws ConsultarEquipoException {
        try {
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new ConsultarEquipoException("Error al consultar los equipos", e);
        }
    }
    
    @Override
    public List<Equipo> buscarEquiposPorFiltro(String filtro) throws ConsultarEquipoException {
    try {
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


    @Override
    public Equipo obtenerEquipo(String id) throws ConsultarEquipoException {
        try {
            ObjectId idHex = new ObjectId(id);
            return coleccion.find(Filters.eq("_id", idHex)).first();
        } catch (Exception e) {
            throw new ConsultarEquipoException("Error al consultar el equipo por ID", e);
        }
    }

    @Override
    public Equipo agregarEquipo(Equipo equipo) throws AgregarEquipoException {
        try {
            InsertOneResult resultado = coleccion.insertOne(equipo);
            if (!resultado.wasAcknowledged()) {
                throw new AgregarEquipoException("La inserción no fue reconocida por el servidor");
            }
            return equipo;
        } catch (Exception e) {
            throw new AgregarEquipoException("Error al agregar equipo a la base de datos", e);
        }
    }

   
    @Override
    public boolean eliminarEquipo(String id) throws EliminarEquipoException {
        try {
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

