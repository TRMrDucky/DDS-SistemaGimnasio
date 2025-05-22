/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Mantenimiento;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.ConsultarMantenimientoException;
import excepciones.EliminarMantenimientoException;
import excepciones.NegocioException;
import excepciones.RegistrarMantenimientoException;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IMantenimientoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.MantenimientoMapper;
/**
 * Clase de negocio (Business Object) que gestiona las operaciones relacionadas con los mantenimientos.
 * Implementa la interfaz {@link IMantenimientoBO} y sirve como intermediaria entre la capa de persistencia
 * (DAO) y la lógica de negocio, manejando la lógica para registrar mantenimientos, obtener el historial
 * de mantenimientos por equipo y eliminar mantenimientos asociados a un equipo.
 * 
 * Utiliza {@link IMantenimientoDAO} para las operaciones de acceso a datos relacionadas con mantenimientos.
 * 
 * @author Cricri
 */
public class MantenimientoBO implements IMantenimientoBO {

    /** DAO para acceso y manipulación de datos de mantenimientos. */
    private IMantenimientoDAO mantenimientoDAO;

    /**
     * Constructor que recibe la dependencia del DAO de mantenimiento.
     * 
     * @param mantenimientoDAO Implementación del DAO para mantenimientos.
     */
    public MantenimientoBO(IMantenimientoDAO mantenimientoDAO) {
        this.mantenimientoDAO = mantenimientoDAO;
    }

    /**
     * Registra un nuevo mantenimiento en la base de datos.
     * 
     * @param mantenimientoDTO Objeto {@link MantenimientoDTO} con los datos del mantenimiento a registrar.
     * @return Objeto {@link MantenimientoDTO} con la información del mantenimiento registrado, incluyendo su ID generado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    @Override
    public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimientoDTO) throws NegocioException {
        try {
            Mantenimiento mantenimiento = MantenimientoMapper.toEntity(mantenimientoDTO);
            Mantenimiento mantenimientoRegistrado = mantenimientoDAO.registrarMantenimiento(mantenimiento);
            return MantenimientoMapper.toDTO(mantenimientoRegistrado);
        } catch (RegistrarMantenimientoException ex) {
            throw new NegocioException("Error al registrar el mantenimiento", ex.getCause());
        }
    }

    /**
     * Obtiene el historial de mantenimientos de un equipo específico.
     * 
     * @param idEquipo Identificador único del equipo.
     * @return Lista de objetos {@link HistorialEquipoDTO} con los datos del historial de mantenimientos.
     * @throws NegocioException Si ocurre un error durante la consulta del historial.
     */
    @Override
    public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws NegocioException {
        try {
            return mantenimientoDAO.obtenerHistorialPorEquipo(idEquipo);
        } catch (ConsultarMantenimientoException ex) {
            throw new NegocioException("Error al consultar el historial de mantenimientos", ex.getCause());
        }
    }

    /**
     * Elimina todos los mantenimientos asociados a un equipo específico.
     * 
     * @param idEquipo Identificador único del equipo cuyos mantenimientos se desean eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la eliminación.
     */
    @Override
    public boolean eliminarMantenimientosPorEquipo(String idEquipo) throws NegocioException {
        try {
            return mantenimientoDAO.eliminarMantenimientosPorEquipo(idEquipo);
        } catch (EliminarMantenimientoException ex) {
            throw new NegocioException("Error al eliminar los mantenimientos del equipo", ex.getCause());
        }
    }
}


