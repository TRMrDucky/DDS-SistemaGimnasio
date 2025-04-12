/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import com.sistemagimnasiopersistencia.interfaces.dao.IServicioExtraDAO;
import dtos.ServicioExtraDTO;
import java.util.LinkedList;
import java.util.List;
import mappers.ServicioExtraMapper;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraBO {
    private IServicioExtraDAO servicioDAO;

    public ServicioExtraBO(IServicioExtraDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return ServicioExtraMapper.toListDTO(servicioDAO.obtenerServiciosExtrasDTO());
    }
}
