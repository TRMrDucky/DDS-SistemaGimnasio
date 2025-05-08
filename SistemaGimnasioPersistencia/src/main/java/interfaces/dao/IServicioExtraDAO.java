/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.ServicioExtra;
import excepciones.AgregarServicioExtraException;
import excepciones.ConsultarServiciosExtraException;
import excepciones.EditarServicioExtraException;
import excepciones.EliminarServicioExtraException;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IServicioExtraDAO {
    public List<ServicioExtra> obtenerServiciosExtras()throws ConsultarServiciosExtraException;
    public ServicioExtra obtenerServicioExtra(String id)throws ConsultarServiciosExtraException;
    public ServicioExtra agregarServicio(ServicioExtra servicio)throws AgregarServicioExtraException;
    public ServicioExtra editarServicio(ServicioExtra servicio)throws EditarServicioExtraException;
    public boolean eliminarServicioExtra(String id)throws EliminarServicioExtraException;
}
