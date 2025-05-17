/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Mantenimiento;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.ConsultarMantenimientoException;
import excepciones.EliminarMantenimientoException;
import excepciones.NegocioException;
import excepciones.RegistrarMantenimientoException;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IMantenimientoDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.MantenimientoMapper;

/**
 *
 * @author Cricri
 */
public class MantenimientoBO implements IMantenimientoBO {
   private IMantenimientoDAO mantenimientoDAO;

    public MantenimientoBO(IMantenimientoDAO mantenimientoDAO) {
        this.mantenimientoDAO = mantenimientoDAO;
    }

    @Override
    public MantenimientoDTO registrarMantenimiento(MantenimientoDTO mantenimientoDTO) throws NegocioException {
        try {
            Mantenimiento mantenimiento = MantenimientoMapper.toEntity(mantenimientoDTO);
            Mantenimiento mantenimientoRegistrado = mantenimientoDAO.registrarMantenimiento(mantenimiento);
            return MantenimientoMapper.toDTO(mantenimientoRegistrado);
        } catch (RegistrarMantenimientoException ex) {
            throw new NegocioException("Error al registrar el mantenimiento", ex.getCause());
        }
    }

    @Override
    public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws NegocioException {
        try {
            return mantenimientoDAO.obtenerHistorialPorEquipo(idEquipo);
        } catch (ConsultarMantenimientoException ex) {
            throw new NegocioException("Error al consultar el historial de mantenimientos", ex.getCause());
        }
    }

    @Override
    public boolean eliminarMantenimientosPorEquipo(String idEquipo) throws NegocioException {
        try {
            return mantenimientoDAO.eliminarMantenimientosPorEquipo(idEquipo);
        } catch (EliminarMantenimientoException ex) {
            throw new NegocioException("Error al eliminar los mantenimientos del equipo", ex.getCause());
        }
    }
    }


    




