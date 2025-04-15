/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import interfaces.dao.IServicioExtraDAO;
import dtos.ServicioExtraDTO;
import interfaces.bo.IServicioExtraBO;
import java.util.LinkedList;
import java.util.List;
import mappers.ServicioExtraMapper;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraBO implements IServicioExtraBO{
    private IServicioExtraDAO servicioDAO;

    public ServicioExtraBO(IServicioExtraDAO servicioDAO) {
        this.servicioDAO = servicioDAO;
    }

    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return ServicioExtraMapper.toListDTO(servicioDAO.obtenerServiciosExtrasDTO());
    }
}
