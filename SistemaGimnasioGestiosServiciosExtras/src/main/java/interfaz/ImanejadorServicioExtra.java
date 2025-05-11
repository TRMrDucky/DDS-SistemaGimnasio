/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaz;

import dtos.ServicioExtraDTO;
import excepciones.SubsistemaServicioExtraException;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IManejadorServicioExtra {
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO()throws SubsistemaServicioExtraException;
    public ServicioExtraDTO obtenerServicioExtra(String id)throws SubsistemaServicioExtraException;
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws SubsistemaServicioExtraException;
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws SubsistemaServicioExtraException ;
    public boolean eliminarServicioExtra(String id)throws SubsistemaServicioExtraException;
}
