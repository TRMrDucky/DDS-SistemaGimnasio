 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Equipo;
import dtos.EquipoDTO;
import excepciones.AgregarEquipoException;
import excepciones.ConsultarEquipoException;
import excepciones.EliminarEquipoException;
import excepciones.NegocioException;
import interfaces.bo.IEquipoBO;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IEquipoDAO;
import java.util.List;
import mappers.EquipoMapper;

/**
 *
 * @author Cricri
 */
public class EquipoBO implements IEquipoBO {
    private final IEquipoDAO equipoDAO;
    private final IMantenimientoBO mantenimientoBO;

    public EquipoBO(IEquipoDAO equipoDAO, IMantenimientoBO mantenimientoBO) {
        this.equipoDAO = equipoDAO;
        this.mantenimientoBO = mantenimientoBO;
    }

    @Override
    public List<EquipoDTO> obtenerTodosEquipos() throws NegocioException {
        try {
            return EquipoMapper.toListDTO(equipoDAO.obtenerEquipos());
        } catch (ConsultarEquipoException ex) {
            throw new NegocioException("Error al consultar los equipos", ex.getCause());
        }
    }

    @Override
    public List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws NegocioException {
        try {
            return EquipoMapper.toListDTO(equipoDAO.buscarEquiposPorFiltro(filtro));
        } catch (ConsultarEquipoException ex) {
            throw new NegocioException("Error al buscar equipos por filtro", ex.getCause());
        }
    }

    @Override
    public EquipoDTO obtenerEquipoPorId(String id) throws NegocioException {
        try {
            Equipo equipo = equipoDAO.obtenerEquipo(id);
            if (equipo == null) {
                throw new NegocioException("No se encontró el equipo con ID: " + id);
            }
            return EquipoMapper.toDTO(equipo);
        } catch (ConsultarEquipoException ex) {
            throw new NegocioException("Error al consultar el equipo por ID", ex.getCause());
        }
    }

    @Override
    public EquipoDTO agregarEquipo(EquipoDTO equipoDTO) throws NegocioException {
        try {
            Equipo equipo = EquipoMapper.toEntity(equipoDTO);
            Equipo equipoAgregado = equipoDAO.agregarEquipo(equipo);
            return EquipoMapper.toDTO(equipoAgregado);
        } catch (AgregarEquipoException ex) {
            throw new NegocioException("Error al agregar el equipo", ex.getCause());
        }
    }

    @Override
    public boolean eliminarEquipo(String id) throws NegocioException {
        try {
            return equipoDAO.eliminarEquipo(id);
        } catch (EliminarEquipoException ex) {
            throw new NegocioException("Error al eliminar el equipo", ex.getCause());
        }
    }
    
     @Override
     public boolean eliminarEquipoYAsociados(String id) throws NegocioException {
        try {
           
            boolean mantenimientosEliminados = mantenimientoBO.eliminarMantenimientosPorEquipo(id);

        
            boolean equipoEliminado = eliminarEquipo(id);


            return mantenimientosEliminados && equipoEliminado;
        } catch (NegocioException ex) {
            throw new NegocioException("Error al eliminar el equipo y sus mantenimientos asociados", ex.getCause());
        }
    }
}
