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
 * Interfaz que define las operaciones para manejar el mantenimiento y la gestión de equipos.
 * Proporciona métodos para obtener, buscar, agregar, eliminar equipos,
 * así como para registrar mantenimientos y consultar el historial de mantenimiento.
 * 
 * @author Cricri
 */
public interface IManejadorMantenimientoEquipos {

    /**
     * Obtiene una lista con todos los equipos registrados.
     * 
     * @return Lista de objetos {@link EquipoDTO} con todos los equipos.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     */
    List<EquipoDTO> obtenerTodosEquipos() throws SubsistemaMantenimientoEquiposException;

    /**
     * Busca equipos que coincidan con el filtro dado.
     * 
     * @param filtro Texto para filtrar la búsqueda de equipos.
     * @return Lista de equipos que cumplen con el filtro.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     * @throws FiltroVacioException si el filtro es nulo o está vacío.
     */
    List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws SubsistemaMantenimientoEquiposException, FiltroVacioException;

    /**
     * Obtiene un equipo por su identificador único.
     * 
     * @param id Identificador único del equipo.
     * @return Objeto {@link EquipoDTO} correspondiente al equipo encontrado.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     * @throws IdEquipoVacioException si el ID es nulo o está vacío.
     */
    EquipoDTO obtenerEquipoPorId(String id) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException;

    /**
     * Agrega un nuevo equipo al sistema.
     * 
     * @param equipo Objeto {@link EquipoDTO} que contiene los datos del equipo a agregar.
     * @return El equipo agregado con los datos persistidos.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     * @throws NombreEquipoVacioException si el nombre del equipo está vacío.
     * @throws NumeroSerieVacioException si el número de serie está vacío.
     * @throws TamañoNumeroSerieExcedidoException si el número de serie excede el tamaño permitido.
     * @throws TamañoNombreEquipoExcedidoException si el nombre del equipo excede el tamaño permitido.
     */
    EquipoDTO agregarEquipo(EquipoDTO equipo) throws SubsistemaMantenimientoEquiposException, NombreEquipoVacioException,
                                                    NumeroSerieVacioException, TamañoNumeroSerieExcedidoException,
                                                    TamañoNombreEquipoExcedidoException;

    /**
     * Elimina un equipo y sus datos asociados del sistema.
     * 
     * @param id Identificador único del equipo a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     * @throws IdEquipoVacioException si el ID es nulo o está vacío.
     */
    boolean eliminarEquipoYAsociados(String id) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException;

    /**
     * Registra un mantenimiento para un equipo específico.
     * 
     * @param mantenimiento Objeto {@link MantenimientoDTO} con los datos del mantenimiento a registrar.
     * @return El mantenimiento registrado con los datos persistidos.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     * @throws IdEquipoVacioException si el ID del equipo está vacío.
     * @throws TamañoObservacionesExcedidoException si las observaciones exceden el tamaño permitido.
     * @throws FechaMantenimientoNulaException si la fecha del mantenimiento es nula.
     * @throws TipoMantenimientoVacioException si el tipo de mantenimiento está vacío.
     * @throws FechaSeguimientoNulaException si la fecha de seguimiento es nula.
     * @throws CostoInvalidoException si el costo indicado es inválido.
     */
    MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimiento) throws SubsistemaMantenimientoEquiposException, 
                                                                                   IdEquipoVacioException,
                                                                                   TamañoObservacionesExcedidoException,
                                                                                   FechaMantenimientoNulaException,
                                                                                   TipoMantenimientoVacioException,
                                                                                   FechaSeguimientoNulaException,
                                                                                   CostoInvalidoException;

    /**
     * Obtiene el historial de mantenimientos asociados a un equipo.
     * 
     * @param idEquipo Identificador único del equipo.
     * @return Lista de objetos {@link HistorialEquipoDTO} con el historial de mantenimientos.
     * @throws SubsistemaMantenimientoEquiposException si ocurre un error en el subsistema.
     * @throws IdEquipoVacioException si el ID del equipo es nulo o está vacío.
     */
    List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException;
}
