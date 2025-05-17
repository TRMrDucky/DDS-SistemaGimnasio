/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.bo;

import bos.MantenimientoBO;
import dtos.EquipoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IEquipoBO {
  
    public  List<EquipoDTO> obtenerTodosEquipos() throws NegocioException;
    public  List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws NegocioException;
    public   EquipoDTO obtenerEquipoPorId(String id) throws NegocioException;
    public   EquipoDTO agregarEquipo(EquipoDTO equipoDTO) throws NegocioException;
    public   boolean eliminarEquipo(String id) throws NegocioException;
    public  boolean eliminarEquipoYAsociados(String id) throws NegocioException;
    
}

