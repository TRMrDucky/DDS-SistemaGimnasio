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
    public List<MembresiaDTO> obtenerMembresiasDTO();
    public MembresiaDTO setearFecha(MembresiaDTO membresiaDTO);
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws NegocioException;
     public List<MembresiaDTO> consultarMembresias();
     public boolean eliminarMembresia(String id) throws NegocioException;
     public MembresiaDTO actualizarMembresia(String idMembresia, Map<String, Object> cambios) throws NegocioException;
     public boolean eliminarServicioDeMembresias(String idServicio)throws  EliminarServicioDeMembresiasException;
      public boolean editarServicioDeMembresias(String idServicio, ServicioExtraDTO servicioActualizado) throws EditarServicioEnMembresiaException;
      public List<MembresiaDTO> consultarMembresiasPorEstado(EnumEstadoMembresia estado);
}
