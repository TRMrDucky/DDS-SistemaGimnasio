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
 * Clase que implementa la interfaz {@link IManejadorMantenimientoEquipos} y actúa como
 * manejador del subsistema de mantenimiento de equipos.
 * 
 * Esta clase coordina operaciones relacionadas con equipos y mantenimientos, 
 * validando datos y delegando la lógica de negocio a las capas correspondientes.
 * Además, maneja las excepciones propias del subsistema y valida las entradas
 * mediante un validador.
 * 
 * Provee métodos para obtener equipos, buscar por filtro, agregar, eliminar,
 * registrar mantenimientos y obtener historial de mantenimiento por equipo.
 * 
 * @author Cricri
 */
public class ManejadorMantenimientoEquipos implements IManejadorMantenimientoEquipos {

    /** Objeto para la lógica de negocio relacionada con equipos */
    private final IEquipoBO equipoBO;

    /** Objeto para la lógica de negocio relacionada con mantenimientos */
    private final IMantenimientoBO mantenimientoBO;

    /** Validador para validar datos de equipos y mantenimientos */
    private final IValidador validador;

    /**
     * Constructor que inicializa las instancias de los objetos de negocio y validador.
     */
    public ManejadorMantenimientoEquipos() {
        this.equipoBO = FabricaBOs.getInstanceEquipoBO();
        this.mantenimientoBO = FabricaBOs.getInstanceMantenimientoBO();
        this.validador = new Validador();
    }

    /**
     * Obtiene la lista de todos los equipos registrados.
     * 
     * @return Lista de {@link EquipoDTO} con todos los equipos.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
    @Override
    public List<EquipoDTO> obtenerTodosEquipos() throws SubsistemaMantenimientoEquiposException {
        try {
            return equipoBO.obtenerTodosEquipos();
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al obtener todos los equipos", ex.getCause());
        }
    }

    /**
     * Busca equipos que coincidan con un filtro de texto.
     * 
     * @param filtro Cadena de texto para filtrar la búsqueda.
     * @return Lista de {@link EquipoDTO} que cumplen con el filtro.
     * @throws FiltroVacioException Si el filtro es nulo o vacío.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
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

    /**
     * Obtiene un equipo por su identificador.
     * 
     * @param id Identificador del equipo.
     * @return {@link EquipoDTO} correspondiente al ID proporcionado.
     * @throws IdEquipoVacioException Si el ID es nulo o vacío.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
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

    /**
     * Agrega un nuevo equipo al sistema después de validar sus datos.
     * 
     * @param equipo Objeto {@link EquipoDTO} con los datos del equipo a agregar.
     * @return El {@link EquipoDTO} agregado con su ID asignado.
     * @throws NombreEquipoVacioException Si el nombre del equipo es nulo o vacío.
     * @throws TamañoNombreEquipoExcedidoException Si el nombre del equipo excede la longitud permitida.
     * @throws NumeroSerieVacioException Si el número de serie es nulo o vacío.
     * @throws TamañoNumeroSerieExcedidoException Si el número de serie excede la longitud permitida.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
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

    /**
     * Elimina un equipo y todos los mantenimientos asociados a él.
     * 
     * @param id Identificador del equipo a eliminar.
     * @return true si la eliminación fue exitosa, false en caso contrario.
     * @throws IdEquipoVacioException Si el ID es nulo o vacío.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
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

    /**
     * Registra un nuevo mantenimiento para un equipo luego de validar los datos.
     * 
     * @param mantenimiento Objeto {@link MantenimientoDTO} con los datos del mantenimiento.
     * @return El {@link MantenimientoDTO} registrado con su ID asignado.
     * @throws IdEquipoVacioException Si el ID del equipo es nulo o vacío.
     * @throws TamañoObservacionesExcedidoException Si las observaciones exceden el tamaño permitido.
     * @throws FechaMantenimientoNulaException Si la fecha de mantenimiento es nula.
     * @throws TipoMantenimientoVacioException Si el tipo de mantenimiento es nulo o vacío.
     * @throws FechaSeguimientoNulaException Si la fecha de seguimiento es nula.
     * @throws CostoInvalidoException Si el costo es negativo.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
    @Override
    public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimiento)
            throws SubsistemaMantenimientoEquiposException, IdEquipoVacioException,
                   TamañoObservacionesExcedidoException, FechaMantenimientoNulaException,
                   TipoMantenimientoVacioException, FechaSeguimientoNulaException,
                   CostoInvalidoException {

        validador.validarMantenimiento(mantenimiento);

        try {
            return mantenimientoBO.registrarMantenimiento(mantenimiento);
        } catch (NegocioException ex) {
            throw new SubsistemaMantenimientoEquiposException("Error al registrar el mantenimiento", ex.getCause());
        }
    }

    /**
     * Obtiene el historial de mantenimiento asociado a un equipo.
     * 
     * @param idEquipo Identificador del equipo.
     * @return Lista de {@link HistorialEquipoDTO} con el historial de mantenimiento.
     * @throws IdEquipoVacioException Si el ID del equipo es nulo o vacío.
     * @throws SubsistemaMantenimientoEquiposException Si ocurre un error en la capa de negocio.
     */
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
