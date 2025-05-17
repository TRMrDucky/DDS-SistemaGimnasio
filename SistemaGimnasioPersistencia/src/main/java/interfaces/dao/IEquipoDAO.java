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
   public List<Equipo> obtenerEquipos() throws ConsultarEquipoException;
   public Equipo obtenerEquipo(String id) throws ConsultarEquipoException;
    public List<Equipo> buscarEquiposPorFiltro(String filtro) throws ConsultarEquipoException;
    public Equipo agregarEquipo(Equipo equipo) throws AgregarEquipoException;
     public boolean eliminarEquipo(String id) throws EliminarEquipoException;
}
