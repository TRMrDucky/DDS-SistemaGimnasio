/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.bo;

import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.NegocioException;
import java.util.List;
/**
 * Interfaz que define las operaciones de negocio relacionadas con el mantenimiento de equipos.
 * Proporciona métodos para registrar mantenimientos, consultar el historial y eliminar mantenimientos asociados a un equipo.
 * 
 * @author Cricri
 */
public interface IMantenimientoBO {

    /**
     * Registra un nuevo mantenimiento para un equipo.
     * 
     * @param mantenimientoDTO Objeto {@link MantenimientoDTO} con los datos del mantenimiento a registrar.
     * @return El {@link MantenimientoDTO} registrado con los datos actualizados.
     * @throws NegocioException Si ocurre un error durante el registro del mantenimiento.
     */
    public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimientoDTO) throws NegocioException;

    /**
     * Obtiene el historial de mantenimientos asociados a un equipo específico.
     * 
     * @param idEquipo Identificador único del equipo cuyo historial se desea obtener.
     * @return Lista de {@link HistorialEquipoDTO} que representan el historial de mantenimientos.
     * @throws NegocioException Si ocurre un error al consultar el historial de mantenimientos.
     */
    public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws NegocioException;

    /**
     * Elimina todos los mantenimientos asociados a un equipo dado.
     * 
     * @param idEquipo Identificador único del equipo cuyos mantenimientos se desean eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error durante la eliminación de los mantenimientos.
     */
    public boolean eliminarMantenimientosPorEquipo(String idEquipo) throws NegocioException;
}
