/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces.bo;

import dtos.ServicioExtraDTO;
import excepciones.AgregarServicioExtraNegocioException;
import excepciones.ConsultarServicioExtraNegocioException;
import excepciones.EditarServicioExtraNegocioException;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IServicioExtraBO {
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO()throws ConsultarServicioExtraNegocioException;
    public ServicioExtraDTO obtenerServicioExtra(String id)throws ConsultarServicioExtraNegocioException;
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws AgregarServicioExtraNegocioException;
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws EditarServicioExtraNegocioException ;
    public boolean eliminarServicioExtra(String id);
}
