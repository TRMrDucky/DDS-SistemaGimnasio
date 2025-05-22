package interfaces.bo;
import Enumeradores.EnumEstadoMembresia;
import clases.mock.Membresia;
import dtos.MembresiaDTO;
import dtos.ServicioExtraDTO;
import excepciones.EditarServicioEnMembresiaException;
import excepciones.EliminarServicioDeMembresiasException;
import excepciones.NegocioException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IMembresiaBO {
    /**
     * obtiene la lista de todas las membresias mock
     * @return todas las membresias 
     */
    public List<MembresiaDTO> obtenerMembresiasDTO();
    /**
     * cambia la fecha de una membresia por una en especifico 
     * @param membresiaDTO la membresia dto con la nueva fecha que queremos 
     * @return la membresiaDTO con la fecha ya actualizada 
     */
    public MembresiaDTO setearFecha(MembresiaDTO membresiaDTO);
    /**
     * nos permite agregar una membresia a la base de datos
     * @param membresia la membresia dto que quermeos agregar
     * @return la membresia que se creo
     * @throws NegocioException en caso de ocurrir un eror al agregarla
     */
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws NegocioException;
    /**
     * nos permite consultar todas las membresias sin ningun filtro de la base de datos
     * @return la lista de membresias dto consultadas
     * @throws NegocioException en caso de ocurrir un eror al agregarla
     */
     public List<MembresiaDTO> consultarMembresias() throws NegocioException;
     /**
      * 
      * @param id pasamos el id de la membresia que queremos eliminar
      * @return valor booleano para identificar si se elimino o no
      * @throws NegocioException excepcion en caso de no eliminarse
      */
     public boolean eliminarMembresia(String id) throws NegocioException;
     /**
      * 
      * @param membresiaActualizada la membresia dto con los datos que queremos actualizar
      * @return la membresia ya actualizada de la base de datos
      * @throws NegocioException excepcion en caso de no actualizarse
      */
     public MembresiaDTO actualizarMembresia(MembresiaDTO membresiaActualizada) throws NegocioException;
    /**
     * 
     * @param idServicio el id del servicio a eliminar de la membresia
     * @return valor booleano para identificar si se elimino de la membresia
     * @throws NegocioException excepcion en caso de no eliminarse
     */
     public boolean eliminarServicioDeMembresias(String idServicio)throws  NegocioException;
     /**
      * 
      * @param idServicio el id del servicio a editar de la embresia
      * @param servicioActualizado el servicio extra dto con los datos a actualizar 
      * @return  valor booleano para identificar si se edito de la membresia
      * @throws NegocioException excepcion en caso de no editarse 
      */
      public boolean editarServicioDeMembresias(String idServicio, ServicioExtraDTO servicioActualizado) throws NegocioException;
      public List<MembresiaDTO> consultarMembresiasPorEstado(EnumEstadoMembresia estado) throws NegocioException;
}
