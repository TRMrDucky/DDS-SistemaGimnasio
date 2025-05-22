/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaz;

import dtos.EquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.CostoInvalidoException;
import excepciones.FechaMantenimientoNulaException;
import excepciones.FechaSeguimientoNulaException;
import excepciones.IdEquipoVacioException;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;

import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import excepciones.TamañoObservacionesExcedidoException;
import excepciones.TipoMantenimientoVacioException;
/**
 * Interfaz que define los métodos para validar los datos de equipos y mantenimientos.
 * 
 * Implementa las reglas de negocio para validar la información antes de ser procesada.
 * 
 * @author Cricri
 */
public interface IValidador {

    /**
     * Valida los datos de un equipo.
     * 
     * @param equipo Objeto {@link EquipoDTO} que contiene los datos del equipo a validar.
     * @throws NombreEquipoVacioException si el nombre del equipo es nulo o vacío.
     * @throws TamañoNombreEquipoExcedidoException si el nombre del equipo excede la longitud máxima permitida.
     * @throws NumeroSerieVacioException si el número de serie es nulo o vacío.
     * @throws TamañoNumeroSerieExcedidoException si el número de serie excede la longitud máxima permitida.
     */
    void validarEquipo(EquipoDTO equipo) throws NombreEquipoVacioException, 
                                               TamañoNombreEquipoExcedidoException,
                                               NumeroSerieVacioException, 
                                               TamañoNumeroSerieExcedidoException;

    /**
     * Valida los datos de un mantenimiento.
     * 
     * @param mantenimiento Objeto {@link MantenimientoDTO} con los datos del mantenimiento a validar.
     * @throws IdEquipoVacioException si el ID del equipo es nulo o vacío.
     * @throws TamañoObservacionesExcedidoException si las observaciones exceden la longitud máxima permitida.
     * @throws FechaMantenimientoNulaException si la fecha del mantenimiento es nula.
     * @throws TipoMantenimientoVacioException si el tipo de mantenimiento es nulo o vacío.
     * @throws FechaSeguimientoNulaException si la fecha de seguimiento es nula.
     * @throws CostoInvalidoException si el costo es inválido (por ejemplo, negativo o nulo).
     */
    void validarMantenimiento(MantenimientoDTO mantenimiento) throws IdEquipoVacioException,
                                                                     TamañoObservacionesExcedidoException,
                                                                     FechaMantenimientoNulaException,
                                                                     TipoMantenimientoVacioException,
                                                                     FechaSeguimientoNulaException,
                                                                     CostoInvalidoException;
}
