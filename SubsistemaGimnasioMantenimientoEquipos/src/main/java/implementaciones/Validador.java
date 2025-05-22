/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dtos.EquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.CostoInvalidoException;
import excepciones.FechaMantenimientoNulaException;
import excepciones.FechaSeguimientoNulaException;
import excepciones.IdEquipoVacioException;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;
import excepciones.ObservacionesVaciasException;
import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import excepciones.TamañoObservacionesExcedidoException;
import excepciones.TipoMantenimientoVacioException;
import interfaz.IValidador;
/**
 * Clase que implementa la interfaz {@link IValidador} y proporciona métodos para validar
 * objetos {@link EquipoDTO} y {@link MantenimientoDTO}, asegurando que cumplan con reglas
 * de negocio como no tener campos vacíos o nulos y respetar límites de longitud.
 * 
 * Lanza excepciones específicas si alguna validación falla.
 * 
 * @author Cricri
 */
public class Validador implements IValidador  {

    /** Longitud máxima permitida para el nombre del equipo */
    private static final int MAX_NOMBRE_EQUIPO_LENGTH = 100;

    /** Longitud máxima permitida para el número de serie del equipo */
    private static final int MAX_NUMERO_SERIE_LENGTH = 50;

    /** Longitud máxima permitida para las observaciones en mantenimiento */
    private static final int MAX_OBSERVACIONES_LENGTH = 500;

    /**
     * Valida los datos de un objeto {@link EquipoDTO}.
     * 
     * Validaciones realizadas:
     * <ul>
     *   <li>El objeto equipo no debe ser nulo.</li>
     *   <li>El nombre del equipo no debe ser nulo ni vacío, y no debe exceder {@value MAX_NOMBRE_EQUIPO_LENGTH} caracteres.</li>
     *   <li>El número de serie no debe ser nulo ni vacío, y no debe exceder {@value MAX_NUMERO_SERIE_LENGTH} caracteres.</li>
     * </ul>
     * 
     * @param equipo Objeto {@link EquipoDTO} a validar.
     * @throws NullPointerException si el objeto equipo es nulo.
     * @throws NombreEquipoVacioException si el nombre del equipo es nulo o vacío.
     * @throws TamañoNombreEquipoExcedidoException si el nombre del equipo excede el tamaño permitido.
     * @throws NumeroSerieVacioException si el número de serie es nulo o vacío.
     * @throws TamañoNumeroSerieExcedidoException si el número de serie excede el tamaño permitido.
     */
    @Override
    public void validarEquipo(EquipoDTO equipo) throws NombreEquipoVacioException, 
                                                        TamañoNombreEquipoExcedidoException, 
                                                        NumeroSerieVacioException, 
                                                        TamañoNumeroSerieExcedidoException {
        if (equipo == null) {
            throw new NullPointerException("El equipo no puede ser nulo");
        }
        if (equipo.getNombre() == null || equipo.getNombre().trim().isEmpty()) {
            throw new NombreEquipoVacioException("El nombre del equipo no puede ser nulo o vacío");
        }
        if (equipo.getNombre().length() > MAX_NOMBRE_EQUIPO_LENGTH) {
            throw new TamañoNombreEquipoExcedidoException("El nombre del equipo excede el tamaño permitido.");
        }

        if (equipo.getNumeroSerie() == null || equipo.getNumeroSerie().trim().isEmpty()) {
            throw new NumeroSerieVacioException("El número de serie no puede ser nulo o vacío");
        }
        if (equipo.getNumeroSerie().length() > MAX_NUMERO_SERIE_LENGTH) {
            throw new TamañoNumeroSerieExcedidoException("El número de serie excede el tamaño permitido.");
        }
    }

    /**
     * Valida los datos de un objeto {@link MantenimientoDTO}.
     * 
     * Validaciones realizadas:
     * <ul>
     *   <li>El objeto mantenimiento no debe ser nulo.</li>
     *   <li>El ID del equipo no debe ser nulo ni vacío.</li>
     *   <li>La fecha de mantenimiento no debe ser nula.</li>
     *   <li>El tipo de mantenimiento no debe ser nulo ni vacío.</li>
     *   <li>El costo debe ser un valor no negativo.</li>
     *   <li>La fecha de seguimiento no debe ser nula.</li>
     *   <li>Las observaciones, si existen, no deben exceder {@value MAX_OBSERVACIONES_LENGTH} caracteres.</li>
     * </ul>
     * 
     * @param mantenimiento Objeto {@link MantenimientoDTO} a validar.
     * @throws NullPointerException si el objeto mantenimiento es nulo.
     * @throws IdEquipoVacioException si el ID del equipo es nulo o vacío.
     * @throws FechaMantenimientoNulaException si la fecha de mantenimiento es nula.
     * @throws TipoMantenimientoVacioException si el tipo de mantenimiento es nulo o vacío.
     * @throws CostoInvalidoException si el costo es negativo.
     * @throws FechaSeguimientoNulaException si la fecha de seguimiento es nula.
     * @throws TamañoObservacionesExcedidoException si las observaciones exceden el tamaño permitido.
     */
    @Override
    public void validarMantenimiento(MantenimientoDTO mantenimiento) throws IdEquipoVacioException,
                                                                       TamañoObservacionesExcedidoException,
                                                                       FechaMantenimientoNulaException,
                                                                       TipoMantenimientoVacioException,
                                                                       FechaSeguimientoNulaException,
                                                                       CostoInvalidoException {
        if (mantenimiento == null) {
            throw new NullPointerException("El mantenimiento no puede ser nulo");
        }
        if (mantenimiento.getIdEquipo() == null || mantenimiento.getIdEquipo().trim().isEmpty()) {
            throw new IdEquipoVacioException("El ID del equipo no puede ser nulo o vacío");
        }

        if (mantenimiento.getFechaMantenimiento() == null) {
            throw new FechaMantenimientoNulaException("La fecha de mantenimiento no puede ser nula");
        }

        if (mantenimiento.getTipoMantenimiento() == null || mantenimiento.getTipoMantenimiento().trim().isEmpty()) {
            throw new TipoMantenimientoVacioException("El nombre del mantenimiento no puede ser nulo o vacío");
        }

        if (mantenimiento.getCosto() < 0) {
            throw new CostoInvalidoException("El costo no puede ser negativo");
        }

        if (mantenimiento.getFechaSeguimiento() == null) {
            throw new FechaSeguimientoNulaException("La fecha de seguimiento no puede ser nula");
        }

        if (mantenimiento.getObservaciones() != null && mantenimiento.getObservaciones().length() > MAX_OBSERVACIONES_LENGTH) {
            throw new TamañoObservacionesExcedidoException("Las observaciones exceden el tamaño permitido.");
        }
    }
}
