/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import Enumeradores.EnumEstadoMembresia;
import dtos.MembresiaDTO;
import excepciones.DuracionException;
import excepciones.NegocioException;
import excepciones.NombreVacioException;
import excepciones.PrecioVacioException;
import excepciones.SubsistemaMembresiaException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IManejadorMembresia {
     public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws SubsistemaMembresiaException, NombreVacioException, PrecioVacioException, DuracionException;
     public boolean eliminarMembresia(String id) throws SubsistemaMembresiaException;
     public List<MembresiaDTO> consultarMembresias() throws SubsistemaMembresiaException;
    public MembresiaDTO actualizarMembresia(MembresiaDTO membresiaActualizada) throws SubsistemaMembresiaException, PrecioVacioException, DuracionException;
     public List<MembresiaDTO> consultarMembresiasPorEstado(EnumEstadoMembresia estado) throws SubsistemaMembresiaException;
            
}
