/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.ServicioExtra;
import daos.ServicioExtraDAO;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IServicioExtraDAO {
    public List<ServicioExtra> obtenerServiciosExtrasDTO();
}
