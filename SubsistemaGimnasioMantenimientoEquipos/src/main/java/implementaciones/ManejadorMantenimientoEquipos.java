/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import bos.FabricaBOs;
import dtos.EquipoDTO;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.NegocioException;
import excepciones.SubsistemaMantenimientoEquiposException;
import interfaces.bo.IEquipoBO;
import interfaces.bo.IMantenimientoBO;
import interfaz.IManejadorMantenimientoEquipos;
import java.util.List;

/**
 *
 * @author Cricri
 */
public class ManejadorMantenimientoEquipos implements IManejadorMantenimientoEquipos {


    private final IEquipoBO equipoBO;
    private final IMantenimientoBO mantenimientoBO;

    public ManejadorMantenimientoEquipos() {
        this.equipoBO = FabricaBOs.getInstanceEquipoBO();
        this.mantenimientoBO = FabricaBOs.getInstanceMantenimientoBO();
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
    public List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws SubsistemaMantenimientoEquiposException {
        if (filtro == null || filtro.trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("El filtro no puede ser nulo o vacío");
        }
        try {
            return equipoBO.buscarEquiposPorFiltro(filtro);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al buscar equipos por filtro", ex.getCause());
        }
    }


    @Override
    public EquipoDTO obtenerEquipoPorId(String id) throws SubsistemaMantenimientoEquiposException {
        if (id == null || id.trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("El ID del equipo no puede ser nulo o vacío");
        }
        try {
            return equipoBO.obtenerEquipoPorId(id);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al obtener equipo por ID", ex.getCause());
        }
    }


    @Override
    public EquipoDTO agregarEquipo(EquipoDTO equipo) throws SubsistemaMantenimientoEquiposException {
        if (equipo == null) {
            throw new NullPointerException("El equipo no puede ser nulo");
        }
        if (equipo.getNombre() == null || equipo.getNombre().trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("El nombre del equipo no puede ser nulo o vacío");
        }
        try {
            return equipoBO.agregarEquipo(equipo);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al agregar equipo", ex.getCause());
        }
    }


    @Override
    public boolean eliminarEquipoYAsociados(String id) throws SubsistemaMantenimientoEquiposException {
        if (id == null || id.trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("El ID del equipo no puede ser nulo o vacío");
        }
        try {
            return equipoBO.eliminarEquipoYAsociados(id);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al eliminar el equipo y sus mantenimientos", ex.getCause());
        }
    }


    @Override
    public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimiento) throws SubsistemaMantenimientoEquiposException {
        if (mantenimiento == null) {
            throw new NullPointerException("El mantenimiento no puede ser nulo");
        }
        if (mantenimiento.getIdEquipo() == null || mantenimiento.getIdEquipo().trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("El ID del equipo no puede ser nulo o vacío");
        }
        if (mantenimiento.getObservaciones() == null || mantenimiento.getObservaciones().trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("Las observaciones no pueden ser nulas o vacías");
        }
        try {
            return mantenimientoBO.registrarMantenimiento(mantenimiento);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al registrar el mantenimiento", ex.getCause());
        }
    }

    
    @Override
    public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws SubsistemaMantenimientoEquiposException {
        if (idEquipo == null || idEquipo.trim().isEmpty()) {
            throw new SubsistemaMantenimientoEquiposException("El ID del equipo no puede ser nulo o vacío");
        }
        try {
            return mantenimientoBO.obtenerHistorialPorEquipo(idEquipo);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al obtener el historial de mantenimiento", ex.getCause());
        }
    }
}


