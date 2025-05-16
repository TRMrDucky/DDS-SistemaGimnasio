package interfaces.bo;
import dtos.MembresiaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IMembresiaBO {
    public List<MembresiaDTO> obtenerMembresiasDTO();
    public MembresiaDTO setearFecha(MembresiaDTO membresiaDTO);
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws NegocioException;
     public List<MembresiaDTO> consultarMembresias();
}
