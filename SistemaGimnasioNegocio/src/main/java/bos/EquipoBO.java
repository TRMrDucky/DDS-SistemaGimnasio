 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Equipo;
import daos.MantenimientoDAO;
import dtos.EquipoDTO;
import excepciones.AgregarEquipoException;
import excepciones.ConsultarEquipoException;
import excepciones.EliminarEquipoException;
import excepciones.EliminarMantenimientoException;
import excepciones.NegocioException;
import interfaces.bo.IEquipoBO;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IEquipoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.EquipoMapper;
/**
 * Clase de negocio (Business Object) que gestiona las operaciones relacionadas con los equipos.
 * Implementa la interfaz {@link IEquipoBO} y actúa como intermediario entre la capa de persistencia
 * (DAO) y la lógica de negocio, manejando la lógica para obtener, agregar, buscar y eliminar equipos,
 * así como eliminar equipos junto con sus mantenimientos asociados.
 * 
 * Esta clase utiliza {@link IEquipoDAO} para las operaciones de acceso a datos y {@link IMantenimientoBO}
 * para gestionar las operaciones relacionadas con mantenimientos.
 * 
 * @author Cricri
 */
public class EquipoBO implements IEquipoBO {

    /** DAO para acceso y manipulación de datos de equipos. */
    private final IEquipoDAO equipoDAO;
    
    /** BO para operaciones relacionadas con mantenimientos. */
    private final IMantenimientoBO mantenimientoBO;

    /**
     * Constructor que recibe las dependencias necesarias para operar.
     * 
     * @param equipoDAO Implementación del DAO para equipos.
     * @param mantenimientoBO Implementación del BO para mantenimientos.
     */
    public EquipoBO(IEquipoDAO equipoDAO, IMantenimientoBO mantenimientoBO) {
        this.equipoDAO = equipoDAO;
        this.mantenimientoBO = mantenimientoBO;
    }

    /**
     * Obtiene la lista de todos los equipos disponibles.
     * 
     * @return Lista de objetos {@link EquipoDTO} con la información de los equipos.
     * @throws NegocioException Si ocurre un error durante la consulta.
     */
    @Override
    public List<EquipoDTO> obtenerTodosEquipos() throws NegocioException {
        try {
            return EquipoMapper.toListDTO(equipoDAO.obtenerEquipos());
        } catch (ConsultarEquipoException ex) {
            throw new NegocioException("Error al consultar los equipos", ex.getCause());
        }
    }

    /**
     * Busca equipos que coincidan con un filtro de búsqueda.
     * 
     * @param filtro Cadena usada para filtrar los equipos (por ejemplo, nombre o descripción).
     * @return Lista de {@link EquipoDTO} que cumplen con el filtro.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    @Override
    public List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws NegocioException {
        try {
            return EquipoMapper.toListDTO(equipoDAO.buscarEquiposPorFiltro(filtro));
        } catch (ConsultarEquipoException ex) {
            throw new NegocioException("Error al buscar equipos por filtro", ex.getCause());
        }
    }

    /**
     * Obtiene un equipo específico a partir de su identificador.
     * 
     * @param id Identificador único del equipo.
     * @return Objeto {@link EquipoDTO} con la información del equipo encontrado.
     * @throws NegocioException Si no se encuentra el equipo o ocurre un error en la consulta.
     */
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

    /**
     * Agrega un nuevo equipo a la base de datos.
     * 
     * @param equipoDTO Objeto {@link EquipoDTO} con los datos del equipo a agregar.
     * @return Objeto {@link EquipoDTO} con los datos del equipo agregado, incluyendo su ID generado.
     * @throws NegocioException Si ocurre un error al agregar el equipo.
     */
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

    /**
     * Elimina un equipo identificado por su ID.
     * 
     * @param id Identificador único del equipo a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error al eliminar el equipo.
     */
    @Override
    public boolean eliminarEquipo(String id) throws NegocioException {
        try {
            return equipoDAO.eliminarEquipo(id);
        } catch (EliminarEquipoException ex) {
            throw new NegocioException("Error al eliminar el equipo", ex.getCause());
        }
    }

    /**
     * Elimina un equipo junto con todos sus mantenimientos asociados.
     * 
     * @param id Identificador único del equipo a eliminar.
     * @return {@code true} si tanto el equipo como sus mantenimientos fueron eliminados correctamente.
     * @throws NegocioException Si ocurre un error al eliminar el equipo o sus mantenimientos asociados.
     */
    @Override
    public boolean eliminarEquipoYAsociados(String id) throws NegocioException {
        try {
            boolean mantenimientosEliminados = mantenimientoBO.eliminarMantenimientosPorEquipo(id);
            boolean equipoEliminado = equipoDAO.eliminarEquipo(id);

            if (!mantenimientosEliminados || !equipoEliminado) {
                throw new NegocioException("Error al eliminar parte de la entidad equipo o sus mantenimientos asociados.");
            }
            
            return true;
        } catch (EliminarEquipoException ex) {
            Logger.getLogger(EquipoBO.class.getName()).log(Level.SEVERE, "Error al eliminar equipo y mantenimientos", ex);
            throw new NegocioException("Error al eliminar el equipo y sus mantenimientos asociados", ex);
        }
    }
}
