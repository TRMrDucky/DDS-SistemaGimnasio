/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.ServicioExtra;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IServicioExtraDAO {
    public List<ServicioExtra> obtenerServiciosExtrasDTO();
    public ServicioExtra obtenerServicioExtra(Long id);
    public ServicioExtra añadirServicio(ServicioExtra servicio);
    public ServicioExtra editarServicio(ServicioExtra servicio);
    public boolean eliinarServicioExtra(Long id);
}
