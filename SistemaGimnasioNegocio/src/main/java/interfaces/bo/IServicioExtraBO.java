/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces.bo;

import dtos.ServicioExtraDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IServicioExtraBO {
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO()throws NegocioException;
    public ServicioExtraDTO obtenerServicioExtra(String id)throws NegocioException;
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws NegocioException;
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws NegocioException ;
    public boolean eliminarServicioExtra(String id)throws NegocioException;
}
