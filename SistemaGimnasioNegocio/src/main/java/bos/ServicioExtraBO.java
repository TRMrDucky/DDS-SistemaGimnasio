/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import interfaces.dao.IServicioExtraDAO;
import dtos.ServicioExtraDTO;
import excepciones.AgregarServicioExtraException;
import excepciones.ConsultarServiciosExtraException;
import excepciones.EditarServicioExtraException;
import excepciones.EliminarServicioExtraException;
import excepciones.NegocioException;
import interfaces.bo.IServicioExtraBO;
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
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() throws NegocioException {
        try {
            return ServicioExtraMapper.toListDTO(servicioDAO.obtenerServiciosExtras());
        } catch (ConsultarServiciosExtraException ex) {
            throw new NegocioException("Error al consultar los servicios extra", ex.getCause());
        }
    }

    @Override
    public ServicioExtraDTO obtenerServicioExtra(String id) throws NegocioException {
        try {
            return ServicioExtraMapper.toDTO(servicioDAO.obtenerServicioExtra(id));
        } catch (ConsultarServiciosExtraException ex) {
            throw new NegocioException("Error al consultar los servicios extra", ex.getCause());
        }
    }

    @Override
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws NegocioException {
        try {
            return ServicioExtraMapper.toDTO(servicioDAO.agregarServicio(ServicioExtraMapper.toEntity(servicio)));
        } catch (AgregarServicioExtraException ex) {
            throw new NegocioException("Error al agregar el servicio", ex.getCause());
        }
    }

    @Override
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws NegocioException {
        try {
            return ServicioExtraMapper.toDTO(servicioDAO.editarServicio(ServicioExtraMapper.toEntity(servicio)));
        } catch (EditarServicioExtraException ex) {
            throw new NegocioException("Error al actualizar el servicio", ex.getCause());
        }
    }

    @Override
    public boolean eliminarServicioExtra(String id) throws NegocioException {
        try {
            return servicioDAO.eliminarServicioExtra(id);
        } catch (EliminarServicioExtraException ex) {
            return false;
        }
    }


}
