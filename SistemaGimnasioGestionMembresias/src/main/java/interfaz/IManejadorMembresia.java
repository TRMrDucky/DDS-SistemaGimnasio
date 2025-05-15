/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dtos.MembresiaDTO;
import excepciones.DuracionException;
import excepciones.NombreVacioException;
import excepciones.PrecioVacioException;
import excepciones.SubsistemaMembresiaException;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IManejadorMembresia {
     public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws SubsistemaMembresiaException, NombreVacioException, PrecioVacioException, DuracionException;
}
