/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import Enumeradores.EnumEstadoMembresia;
import static Enumeradores.EnumEstadoMembresia.ACTIVA;
import clases.mock.Membresia;
import clases.mock.ServicioExtra;
//import clases.mock.membresias.DayPass;
//import clases.mock.membresias.FifteenDaysPass;
//import clases.mock.membresias.MonthlyPass;
//import clases.mock.membresias.SevenDaysPass;
//import clases.mock.membresias.TenDaysPass;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import excepciones.ActualizarMembresiaException;

import excepciones.ConsultarServiciosExtraException;
import excepciones.AgregarMembresiaException;
import excepciones.ConsultarMembPorEstadoException;
import excepciones.ConsultarMembresiasDesactivadasException;
import excepciones.ConsultarMembresiasException;
import excepciones.EditarServicioEnMembresiaException;
import excepciones.EliminarMembresiaException;
import excepciones.EliminarServicioDeMembresiasException;

import interfaces.dao.IMembresiaDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaDAO implements IMembresiaDAO {

    private static MembresiaDAO instancia = new MembresiaDAO();
    Long DURACION_DIA = 86400000L;

    private MembresiaDAO() {

    }
/**
 * 
 * @return
 * @throws ConsultarServiciosExtraException 
 */
    @Override
    public List<ServicioExtra> obtenerServicio() throws ConsultarServiciosExtraException {
        List<ServicioExtra> servicios = new LinkedList<>();
        List<ServicioExtra> serviciosDisponibles = ServicioExtraDAO.getInstance().obtenerServiciosExtras();

        if (!serviciosDisponibles.isEmpty()) {
            servicios.add(serviciosDisponibles.get(0));

        }
        return servicios;
    }
/**
 * 
 * @return 
 */
    public static MembresiaDAO getInstance() {
        if (instancia == null) {
            instancia = new MembresiaDAO();
        }
        return instancia;
    }
/**
 * 
 * @param membresia la membresia que queremos agregar, sin ID
 * @return la membresia ya agregada, con ID
 * @throws AgregarMembresiaException excepcion en caso de ocurrir errores al insertarla a la base de datos
 */
    @Override
    public Membresia agregarMembresia(Membresia membresia) throws AgregarMembresiaException {
        try {

            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);

            coleccion.insertOne(membresia);

            return membresia;

        } catch (Exception e) {
            throw new AgregarMembresiaException("Error al insertar membresia");
        }

    }
/**
 * 
 * @return lista de todas las membresias, que as obtenemos desde la base de datos
 * @throws ConsultarMembresiasException en caso de ocurrir error al consultarlas
 */
    public List<Membresia> consultarMembresias() throws ConsultarMembresiasException {
        try {
            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
            return coleccion.find().into(new ArrayList<>());
        } catch (Exception e) {
            throw new ConsultarMembresiasException("Error al consultar membresias", e);
        }

    }
/**
 * 
 * @param estado el estado de la membresa es un enum y aqui lo usamos para filtarr entre membresias activas o inactivas
 * @returnla lista de membresias con el estado que le pedimos
 * @throws ConsultarMembPorEstadoException en caso de ocurrir error al consultarlas
 */
    public List<Membresia> consultarMembresiasPorEstado(EnumEstadoMembresia estado) throws ConsultarMembPorEstadoException {
        try {
            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
            return coleccion.find(Filters.eq("estado", estado.name())).into(new ArrayList<>());
        } catch (Exception e) {
            throw new ConsultarMembPorEstadoException("Error al consultar membresias por estado", e);
        }
    }
/**
 * 
 * @param id id de la membresia a eliminar, llega como string pero se busca como objectId, se pasa como string para facililitar su manejo entre las capas
 * @return retorna u valor booleano dependiendo si se ha podido eliminar la membresia
 * @throws EliminarMembresiaException en caso de ocurrir error al eliminarla
 */
    public boolean eliminarMembresia(String id) throws EliminarMembresiaException {
        try {
            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
            ObjectId objectId = new ObjectId(id);
            DeleteResult resultado = coleccion.deleteOne(Filters.eq("_id", objectId));
            return resultado.getDeletedCount() > 0;
        } catch (Exception e) {
            throw new EliminarMembresiaException("Error al eliminar membresia", e);
        }

    }
/**
 * 
 * @param idServicio pasamos el id del servicio que queremos eliminar
 * @return un valor booleano para dentificar si se pudo eliminar 
 * @throws EliminarServicioDeMembresiasException excepcion en caso de no poder eliminar el servicio de la membresia
 */
    public boolean eliminarServicioDeMembresias(String idServicio) throws EliminarServicioDeMembresiasException {
        try {
            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
            UpdateResult result = coleccion.updateMany(
                    Filters.elemMatch("serviciosExtra", Filters.eq("_id", new ObjectId(idServicio))),
                    new Document("$pull", new Document("serviciosExtra", new Document("_id", new ObjectId(idServicio))))
            );
            return result.getModifiedCount() > 0;
        } catch (Exception e) {
            throw new EliminarServicioDeMembresiasException("Error al eliminar servicio de membresia asociada", e);
        }
    }
/**
 * 
 * @param idServicio pasamos el id del servicio que queremos editar
 * @param servicioActualizado el servicio con los nuevos datos
 * @return un valor booleano para dentificar si se pudo editar 
 * @throws EditarServicioEnMembresiaException excepcion en caso de no poder editar el servicio de la membresia
 */
    public boolean editarServicioEnMembresias(String idServicio, ServicioExtra servicioActualizado) throws EditarServicioEnMembresiaException {
        try {
            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
            UpdateResult resultado = coleccion.updateMany(
                    Filters.elemMatch("serviciosExtra", Filters.eq("_id", new ObjectId(idServicio))),
                    new Document("$set", new Document("serviciosExtra.$", servicioActualizado))
            );

            return resultado.getModifiedCount() > 0;

        } catch (Exception e) {
            throw new EditarServicioEnMembresiaException("Error al editar servicio en membresia", e);
        }

    }
/**
 * 
 * @param membresiaActualizada la membresia con los nuevos datos
 * @return la membresia actualizada
 * @throws ActualizarMembresiaException excepcion en caso de no poder actualizar la membresia
 */
    public Membresia actualizarMembresia(Membresia membresiaActualizada) throws ActualizarMembresiaException {

        try {
            MongoCollection<Membresia> coleccion = ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
            UpdateResult result = coleccion.updateOne(
                    Filters.eq("_id", membresiaActualizada.getId()),
                    Updates.combine(
                            Updates.set("nombre", membresiaActualizada.getNombre()),
                            Updates.set("duracion", membresiaActualizada.getDuracion()),
                            Updates.set("precio", membresiaActualizada.getPrecio()),
                            Updates.set("estado", membresiaActualizada.getEstado().name()),
                            Updates.set("serviciosExtra", membresiaActualizada.getServiciosExtra())
                    )
            );
            if (result.getModifiedCount() == 0) {
                throw new ActualizarMembresiaException("No se edito ningun cambio en la membresia");
            }
            return membresiaActualizada;

        } catch (Exception e) {
            e.printStackTrace();
            throw new ActualizarMembresiaException("Error al actualizar membresia" + e.getMessage());
        }
    }

    @Override
    public Membresia setearFecha(Membresia membresia) {
        return membresia;
    }

    @Override
    public List<Membresia> obtenerMembresias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<Membresia> consultarMembresiasA() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
