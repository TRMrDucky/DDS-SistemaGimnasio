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
    
    private ServicioExtraDAO() {
    }
    /**
     * Obtiene la instancia única de ServicioExtraDAO.
     * @return instancia única de ServicioExtraDAO
     */
    public static ServicioExtraDAO getInstance() {
        if (instancia == null) {
            instancia = new ServicioExtraDAO();
        }
        return instancia;
    }
    
    
    /**
     * Consulta todos los servicios extra almacenados en la base de datos.
     * @return lista de servicios extra
     * @throws ConsultarServiciosExtraException si ocurre un error al consultar
     */
    @Override
    public List<ServicioExtra> obtenerServiciosExtras()throws ConsultarServiciosExtraException{
        try {
            MongoCollection<ServicioExtra> coleccion = ConexionBD.getInstance().getCollection("serviciosExtra",ServicioExtra.class);
            List<ServicioExtra> servicios = coleccion.find().into(new ArrayList<>());
            return servicios;
        } catch (Exception e) {
            throw new ConsultarServiciosExtraException("Error al consultar los servicios extra", e);
        }
    }
    /**
     * Consulta un servicio extra por su ID.
     * @param id ID del servicio extra
     * @return servicio extra encontrado o null si no existe
     * @throws ConsultarServiciosExtraException si ocurre un error durante la consulta
     */
    @Override
    public ServicioExtra obtenerServicioExtra(String id)throws ConsultarServiciosExtraException{
        try{
            MongoCollection<ServicioExtra> coleccion = ConexionBD.getInstance().getCollection("serviciosExtra",ServicioExtra.class);
            ObjectId idHex = new ObjectId(id);
            return coleccion.find(Filters.eq("_id", idHex)).first();
        }catch(Exception e){
            throw new ConsultarServiciosExtraException("Error al consultar los servicios extra", e.getCause());
        }
    }
    
    /**
     * Agrega un nuevo servicio extra a la base de datos.
     * @param servicio objeto ServicioExtra a agregar
     * @return el mismo objeto ServicioExtra agregado
     * @throws AgregarServicioExtraException si ocurre un error al insertar
     */
    @Override
    public ServicioExtra agregarServicio(ServicioExtra servicio)throws AgregarServicioExtraException{
        try{
            MongoCollection<ServicioExtra> coleccion = ConexionBD.getInstance().getCollection("serviciosExtra",ServicioExtra.class);
            coleccion.insertOne(servicio);
            return servicio;
        }catch(Exception e){
            throw new AgregarServicioExtraException("Error en la agregacion del servicio en la base de datos", e.getCause());
        }
    }

    /**
     * Edita un servicio extra existente en la base de datos.
     * @param servicio objeto ServicioExtra con la información actualizada
     * @return el objeto ServicioExtra editado
     * @throws EditarServicioExtraException si ocurre un error durante la actualización
     */
    @Override
    public ServicioExtra editarServicio(ServicioExtra servicio)throws EditarServicioExtraException {
        try{
            MongoCollection<ServicioExtra> coleccion = ConexionBD.getInstance().getCollection("serviciosExtra",ServicioExtra.class);
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

    /**
     * Elimina un servicio extra de la base de datos por su ID.
     * @param id ID del servicio a eliminar
     * @return true si fue eliminado correctamente
     * @throws EliminarServicioExtraException si ocurre un error durante la eliminación
     */
    @Override
    public boolean eliminarServicioExtra(String id) throws EliminarServicioExtraException{
        try{
            MongoCollection<ServicioExtra> coleccion = ConexionBD.getInstance().getCollection("serviciosExtra",ServicioExtra.class);
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
