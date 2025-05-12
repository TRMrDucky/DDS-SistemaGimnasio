/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Equipo;
import excepciones.AgregarEquipoException;
import excepciones.ConsultarEquipoException;
import excepciones.EliminarEquipoException;
import java.util.List;

/**
 *
 * @author Cricri
 */
public interface IEquipoDAO {
    List<Equipo> obtenerEquipos() throws ConsultarEquipoException;
    Equipo obtenerEquipo(String id) throws ConsultarEquipoException;
    List<Equipo> buscarEquiposPorFiltro(String filtro) throws ConsultarEquipoException;
    Equipo agregarEquipo(Equipo equipo) throws AgregarEquipoException;
    boolean eliminarEquipo(String id) throws EliminarEquipoException;
}
