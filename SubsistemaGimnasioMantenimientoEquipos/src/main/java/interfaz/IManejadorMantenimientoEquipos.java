/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dtos.EquipoDTO;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.CostoInvalidoException;
import excepciones.FechaMantenimientoNulaException;
import excepciones.FechaSeguimientoNulaException;
import excepciones.FiltroVacioException;
import excepciones.IdEquipoVacioException;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;
import excepciones.ObservacionesVaciasException;
import excepciones.SubsistemaMantenimientoEquiposException;
import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import excepciones.TamañoObservacionesExcedidoException;
import excepciones.TipoMantenimientoVacioException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IManejadorMantenimientoEquipos {
    
    
    List<EquipoDTO> obtenerTodosEquipos() throws SubsistemaMantenimientoEquiposException;

    List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws SubsistemaMantenimientoEquiposException, FiltroVacioException;

    EquipoDTO obtenerEquipoPorId(String id) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException;

    EquipoDTO agregarEquipo(EquipoDTO equipo) throws SubsistemaMantenimientoEquiposException, NombreEquipoVacioException,NumeroSerieVacioException,TamañoNumeroSerieExcedidoException, TamañoNombreEquipoExcedidoException ;
;

    boolean eliminarEquipoYAsociados(String id) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException;

    MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimiento) throws  SubsistemaMantenimientoEquiposException,IdEquipoVacioException,
                                                                       TamañoObservacionesExcedidoException,
                                                                       FechaMantenimientoNulaException,
                                                                       TipoMantenimientoVacioException,
                                                                       FechaSeguimientoNulaException,
                                                                       CostoInvalidoException;

    List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException;
}



