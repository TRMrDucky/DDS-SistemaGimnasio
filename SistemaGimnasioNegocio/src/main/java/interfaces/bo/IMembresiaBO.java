package interfaces.bo;
import dtos.MembresiaDTO;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IMembresiaBO {
    public List<MembresiaDTO> obtenerMembresiasDTO();
    public MembresiaDTO setearFecha(MembresiaDTO membresiaDTO);
}
