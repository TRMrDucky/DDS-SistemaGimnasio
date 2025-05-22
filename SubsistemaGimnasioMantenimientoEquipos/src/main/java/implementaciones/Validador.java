/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import dtos.EquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.IdEquipoVacioException;
import excepciones.NombreEquipoVacioException;
import excepciones.NumeroSerieVacioException;
import excepciones.ObservacionesVaciasException;
import excepciones.TamañoNombreEquipoExcedidoException;
import excepciones.TamañoNumeroSerieExcedidoException;
import excepciones.TamañoObservacionesExcedidoException;
import interfaz.IValidador;

/**
 *
 * @author Cricri
 */
public class Validador implements IValidador  {
   

    private static final int MAX_NOMBRE_EQUIPO_LENGTH = 100;
    private static final int MAX_NUMERO_SERIE_LENGTH = 50;
    private static final int MAX_OBSERVACIONES_LENGTH = 500;

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

    @Override
    public void validarMantenimiento(MantenimientoDTO mantenimiento) throws IdEquipoVacioException, 
                                                                            ObservacionesVaciasException, 
                                                                            TamañoObservacionesExcedidoException {
        if (mantenimiento == null) {
            throw new NullPointerException("El mantenimiento no puede ser nulo");
        }
        if (mantenimiento.getIdEquipo() == null || mantenimiento.getIdEquipo().trim().isEmpty()) {
            throw new IdEquipoVacioException("El ID del equipo no puede ser nulo o vacío");
        }
        if (mantenimiento.getObservaciones() == null || mantenimiento.getObservaciones().trim().isEmpty()) {
            throw new ObservacionesVaciasException("Las observaciones no pueden ser nulas o vacías");
        }
        if (mantenimiento.getObservaciones().length() > MAX_OBSERVACIONES_LENGTH) {
            throw new TamañoObservacionesExcedidoException("Las observaciones exceden el tamaño permitido.");
        }
    }
}


