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
 *
 * @author Cricri
 */
public interface IMantenimientoBO {
     MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimientoDTO) throws NegocioException;
    List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws NegocioException;
    boolean eliminarMantenimientosPorEquipo(String idEquipo) throws NegocioException;
}
