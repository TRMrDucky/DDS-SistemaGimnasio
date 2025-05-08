/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import clases.mock.ServicioExtra;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import excepciones.AgregarServicioExtraException;
import excepciones.ConsultarServiciosExtraException;
import excepciones.EditarServicioExtraException;
import excepciones.EliminarServicioExtraException;
import interfaces.dao.IServicioExtraDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraDAO implements IServicioExtraDAO {
    
    private static ServicioExtraDAO instancia;
    private final MongoCollection<ServicioExtra> coleccion;
    
    private ServicioExtraDAO() {
        this.coleccion = ConexionBD.getInstance().getCollection("serviciosExtra",ServicioExtra.class);
    }
    
    public static ServicioExtraDAO getInstance() {
        if (instancia == null) {
            instancia = new ServicioExtraDAO();
        }
        return instancia;
    }
    
    @Override
    public List<ServicioExtra> obtenerServiciosExtras()throws ConsultarServiciosExtraException{
        try {
        List<ServicioExtra> servicios = coleccion.find().into(new ArrayList<>());
        System.out.println("DEBUG - Se encontraron " + servicios.size() + " servicios extra.");
        return servicios;
    } catch (Exception e) {
        System.err.println("ERROR - Falló la consulta de servicios extra:");
        e.printStackTrace(); // Imprime el error completo
        throw new ConsultarServiciosExtraException("Error al consultar los servicios extra", e);
    }
    }

    @Override
    public ServicioExtra obtenerServicioExtra(String id)throws ConsultarServiciosExtraException{
        try{
            ObjectId idHex = new ObjectId(id);
            return coleccion.find(Filters.eq("_id", idHex)).first();
        }catch(Exception e){
            throw new ConsultarServiciosExtraException("Error al consultar los servicios extra", e.getCause());
        }
    }
    
    @Override
    public ServicioExtra agregarServicio(ServicioExtra servicio)throws AgregarServicioExtraException{
        try{
            InsertOneResult resultado = coleccion.insertOne(servicio);
            if(!resultado.wasAcknowledged()){
                throw new AgregarServicioExtraException("La insercion no fue reconocida por el servidor");
            }
            return servicio;
        }catch(Exception e){
            throw new AgregarServicioExtraException("Error en la agregacion del servicio en la base de datos", e.getCause());
        }
    }

    @Override
    public ServicioExtra editarServicio(ServicioExtra servicio)throws EditarServicioExtraException {
        try{
            UpdateResult result = coleccion.updateOne(
                Filters.eq("_id", servicio.getId()),
                Updates.combine(
                    Updates.set("nombreServicio", servicio.getNombreServicio()),
                    Updates.set("precio", servicio.getPrecio()),
                    Updates.set("descripcion", servicio.getDescripcion())
                )
            );
            if(!result.wasAcknowledged()){
              throw new AgregarServicioExtraException("La edicion no fue reconocida por el servidor");
            }
            return servicio;
        }catch(Exception e){
            throw new EditarServicioExtraException("Error en la edicion del servicio en la base de datos", e.getCause());
        }
    }

    @Override
    public boolean eliminarServicioExtra(String id) throws EliminarServicioExtraException{
        try{
            ObjectId idHex = new ObjectId(id);
            DeleteResult result = coleccion.deleteMany(Filters.eq("_id", idHex));
            if(!result.wasAcknowledged()){
              throw new AgregarServicioExtraException("La eliminacion no fue reconocida por el servidor");
            }
            return true;
        }catch(Exception e){
            throw new EliminarServicioExtraException("Error al eliinar el servicio de la base de datos",e.getCause());
        }
    }
    
    
    
    
}
