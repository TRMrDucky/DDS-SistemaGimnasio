/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dtos.ServicioExtraDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface ImanejadorServicioExtra {
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO();
    public ServicioExtraDTO obtenerServicioExtra(Long id);
    public ServicioExtraDTO añadirServicio(ServicioExtraDTO servicio)throws NegocioException;
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws NegocioException ;
    public boolean eliinarServicioExtra(Long id);
}
