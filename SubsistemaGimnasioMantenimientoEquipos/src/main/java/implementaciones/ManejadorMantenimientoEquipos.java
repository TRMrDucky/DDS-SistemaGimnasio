/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import bos.FabricaBOs;
import dtos.EquipoDTO;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.CostoInvalidoException;
import excepciones.FechaMantenimientoNulaException;
import excepciones.FechaSeguimientoNulaException;
import excepciones.FiltroVacioException;
import excepciones.IdEquipoVacioException;
import excepciones.NegocioException;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;

import excepciones.SubsistemaMantenimientoEquiposException;
import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import excepciones.TamañoObservacionesExcedidoException;
import excepciones.TipoMantenimientoVacioException;
import interfaces.bo.IEquipoBO;
import interfaces.bo.IMantenimientoBO;
import interfaz.IManejadorMantenimientoEquipos;
import interfaz.IValidador;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cricri
 */
public class ManejadorMantenimientoEquipos implements IManejadorMantenimientoEquipos {


    private final IEquipoBO equipoBO;
    private final IMantenimientoBO mantenimientoBO;
    private final IValidador validador;

    public ManejadorMantenimientoEquipos() {
        this.equipoBO = FabricaBOs.getInstanceEquipoBO();
        this.mantenimientoBO = FabricaBOs.getInstanceMantenimientoBO();
        this.validador = new Validador();
    }

    @Override
    public List<EquipoDTO> obtenerTodosEquipos() throws SubsistemaMantenimientoEquiposException {
        try {
            return equipoBO.obtenerTodosEquipos();
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al obtener todos los equipos", ex.getCause());
        }
    }

    @Override
    public List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws SubsistemaMantenimientoEquiposException, FiltroVacioException {
        if (filtro == null || filtro.trim().isEmpty()) {
            throw new FiltroVacioException("El filtro no puede ser nulo o vacío");
        }
        try {
            return equipoBO.buscarEquiposPorFiltro(filtro);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al buscar equipos por filtro", ex.getCause());
        }
    }

    @Override
    public EquipoDTO obtenerEquipoPorId(String id) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException {
        if (id == null || id.trim().isEmpty()) {
            throw new IdEquipoVacioException("El ID del equipo no puede ser nulo o vacío");
        }
        try {
            return equipoBO.obtenerEquipoPorId(id);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al obtener equipo por ID", ex.getCause());
        }
    }

    @Override
public EquipoDTO agregarEquipo(EquipoDTO equipo) throws SubsistemaMantenimientoEquiposException, 
                                                         NombreEquipoVacioException, 
                                                         TamañoNombreEquipoExcedidoException, 
                                                         NumeroSerieVacioException, 
                                                         TamañoNumeroSerieExcedidoException { 

    validador.validarEquipo(equipo); 

    try {
        return equipoBO.agregarEquipo(equipo);
    } catch (NegocioException ex) {
        throw new SubsistemaMantenimientoEquiposException("Error al agregar equipo", ex.getCause());
    }
}

    
    
    @Override
    public boolean eliminarEquipoYAsociados(String id) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException {
        if (id == null || id.trim().isEmpty()) {
            throw new IdEquipoVacioException("El ID del equipo no puede ser nulo o vacío");
        }
        try {
            return equipoBO.eliminarEquipoYAsociados(id);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al eliminar el equipo y sus mantenimientos", ex.getCause());
        }
    }

  
@Override
public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimiento)
        throws  SubsistemaMantenimientoEquiposException,IdEquipoVacioException,
                                                                       TamañoObservacionesExcedidoException,
                                                                       FechaMantenimientoNulaException,
                                                                       TipoMantenimientoVacioException,
                                                                       FechaSeguimientoNulaException,
                                                                       CostoInvalidoException{

    validador.validarMantenimiento(mantenimiento);

    try {
        return mantenimientoBO.registrarMantenimiento(mantenimiento);
    } catch (NegocioException ex) {
        throw new SubsistemaMantenimientoEquiposException("Error al registrar el mantenimiento", ex.getCause());
    }
}


    @Override
    public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException {
        if (idEquipo == null || idEquipo.trim().isEmpty()) {
            throw new IdEquipoVacioException("El ID del equipo no puede ser nulo o vacío");
        }
        try {
            return mantenimientoBO.obtenerHistorialPorEquipo(idEquipo);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al obtener el historial de mantenimiento", ex.getCause());
        }
    }
}
