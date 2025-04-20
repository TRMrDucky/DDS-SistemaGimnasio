/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.ServicioExtra;
import interfaces.dao.IServicioExtraDAO;
import dtos.ServicioExtraDTO;
import excepciones.NegocioException;
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

    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return ServicioExtraMapper.toListDTO(servicioDAO.obtenerServiciosExtrasDTO());
    }

    @Override
    public ServicioExtraDTO obtenerServicioExtra(Long id) {
        return ServicioExtraMapper.toDTO(servicioDAO.obtenerServicioExtra(id));
    }

    @Override
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws NegocioException {
        return ServicioExtraMapper.toDTO(servicioDAO.agregarServicio(ServicioExtraMapper.toEntity(servicio)));
    }

    @Override
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws NegocioException {
        return ServicioExtraMapper.toDTO(servicioDAO.editarServicio(ServicioExtraMapper.toEntity(servicio)));
    }

    @Override
    public boolean eliinarServicioExtra(Long id) {
        return servicioDAO.eliinarServicioExtra(id);
    }
}
