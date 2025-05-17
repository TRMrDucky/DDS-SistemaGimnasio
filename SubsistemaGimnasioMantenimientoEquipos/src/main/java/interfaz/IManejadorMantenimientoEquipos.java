/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dtos.EquipoDTO;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.SubsistemaMantenimientoEquiposException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IManejadorMantenimientoEquipos {
    
   public List<EquipoDTO> obtenerTodosEquipos() throws SubsistemaMantenimientoEquiposException;
   public List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws SubsistemaMantenimientoEquiposException;
   public EquipoDTO obtenerEquipoPorId(String id) throws SubsistemaMantenimientoEquiposException;
   public EquipoDTO agregarEquipo(EquipoDTO equipo) throws SubsistemaMantenimientoEquiposException;
   public boolean eliminarEquipoYAsociados(String id) throws SubsistemaMantenimientoEquiposException;
   public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimiento) throws SubsistemaMantenimientoEquiposException;
   public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws SubsistemaMantenimientoEquiposException;
}


