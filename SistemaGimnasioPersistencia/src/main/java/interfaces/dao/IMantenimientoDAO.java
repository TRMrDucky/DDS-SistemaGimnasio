/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Mantenimiento;
import excepciones.ConsultarMantenimientoException;
import excepciones.RegistrarMantenimientoException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IMantenimientoDAO {
    
     public Mantenimiento registrarMantenimiento(Mantenimiento mantenimiento) throws RegistrarMantenimientoException;
     public List<Mantenimiento> obtenerHistorialPorEquipo(String idEquipo) throws ConsultarMantenimientoException;
}
