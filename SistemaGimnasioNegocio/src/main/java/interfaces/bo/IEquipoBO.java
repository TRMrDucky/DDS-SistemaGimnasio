/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.bo;

import dtos.EquipoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IEquipoBO {
  
    List<EquipoDTO> obtenerTodosEquipos() throws NegocioException;
    List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws NegocioException;
    EquipoDTO obtenerEquipoPorId(String id) throws NegocioException;
    EquipoDTO agregarEquipo(EquipoDTO equipoDTO) throws NegocioException;
    boolean eliminarEquipo(String id) throws NegocioException;
    
}

