/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dtos.EquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.IdEquipoVacioException;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;
import excepciones.ObservacionesVaciasException;
import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import excepciones.TamañoObservacionesExcedidoException;

/**
 *
 * @author Cricri
 */
public interface IValidador {
     void validarEquipo(EquipoDTO equipo) throws NombreEquipoVacioException, 
                                                 TamañoNombreEquipoExcedidoException,
                                                 NumeroSerieVacioException, 
                                                 TamañoNumeroSerieExcedidoException;

    void validarMantenimiento(MantenimientoDTO mantenimiento) throws IdEquipoVacioException, 
                                                                     ObservacionesVaciasException, 
                                                                     TamañoObservacionesExcedidoException;
}

