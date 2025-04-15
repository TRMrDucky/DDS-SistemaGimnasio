package interfaces.bo;
import dtos.TipoMembresiaDTO;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IMembresiaBO {
    public List<TipoMembresiaDTO> obtenerMembresiasDTO();
    
}
