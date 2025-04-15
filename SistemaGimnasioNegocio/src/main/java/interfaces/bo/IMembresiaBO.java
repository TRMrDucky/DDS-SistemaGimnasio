/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
