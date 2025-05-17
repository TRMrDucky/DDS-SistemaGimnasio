/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Mantenimiento;
import dtos.HistorialEquipoDTO;
import excepciones.ConsultarMantenimientoException;
import excepciones.EliminarMantenimientoException;
import excepciones.RegistrarMantenimientoException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IMantenimientoDAO {
    
     public Mantenimiento registrarMantenimiento(Mantenimiento mantenimiento) throws RegistrarMantenimientoException;
     public List<HistorialEquipoDTO> obtenerHistorialPorEquipo(String idEquipo) throws ConsultarMantenimientoException;
     public boolean eliminarMantenimientosPorEquipo(String idEquipo) throws EliminarMantenimientoException;
}
