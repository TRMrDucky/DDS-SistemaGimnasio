/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dtos.ServicioExtraDTO;
import excepciones.AgregarServicioExtraSubsistemaException;
import excepciones.ConsultarServicioExtraSubsistemaException;
import excepciones.EditarServicioExtraSubsitemaException;
import excepciones.SubsistemaServicioExtraException;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IManejadorServicioExtra {
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO()throws ConsultarServicioExtraSubsistemaException;
    public ServicioExtraDTO obtenerServicioExtra(String id)throws ConsultarServicioExtraSubsistemaException;
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws AgregarServicioExtraSubsistemaException;
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws EditarServicioExtraSubsitemaException ;
    public boolean eliminarServicioExtra(String id)throws  SubsistemaServicioExtraException;
}
