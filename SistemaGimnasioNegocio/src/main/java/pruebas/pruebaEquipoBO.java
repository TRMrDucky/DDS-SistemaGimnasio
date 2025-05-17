/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import bos.EquipoBO;
import bos.MantenimientoBO;
import daos.EquipoDAO;
import daos.MantenimientoDAO;
import dtos.EquipoDTO;
import excepciones.NegocioException;
import interfaces.bo.IEquipoBO;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IEquipoDAO;
import interfaces.dao.IMantenimientoDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cricri
 */
public class pruebaEquipoBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NegocioException {
      IEquipoDAO equipoDAO = EquipoDAO.getInstance();
    IMantenimientoDAO mantenimientoDAO = MantenimientoDAO.getInstance(); 
    IMantenimientoBO mantenimientoBO = new MantenimientoBO(mantenimientoDAO);
    IEquipoBO equipoBO = new EquipoBO(equipoDAO, mantenimientoBO); 

    EquipoDTO nuevoEquipo = new EquipoDTO("PC GAMER", "GMER", "34200", "33434", new Date());
    EquipoDTO equipoAgregado = equipoBO.agregarEquipo(nuevoEquipo);
    System.out.println("Equipo agregado: " + equipoAgregado);

    String idEquipo = equipoAgregado.getId();
    EquipoDTO equipoConsultado = equipoBO.obtenerEquipoPorId(idEquipo);
    System.out.println("Equipo consultado por ID: " + equipoConsultado);

    String filtro = "Laptop";
    List<EquipoDTO> equiposFiltrados = equipoBO.buscarEquiposPorFiltro(filtro);
    System.out.println("Equipos encontrados con filtro '" + filtro + "':");
    for (EquipoDTO equipo : equiposFiltrados) {
        System.out.println(equipo);
    }
    
      // 4. Probar eliminación completa (equipo + mantenimientos)
    boolean eliminadoTodo = equipoBO.eliminarEquipoYAsociados(equipoAgregado.getId());
    System.out.println("¿Equipo y mantenimientos eliminados?: " + eliminadoTodo);

   // boolean eliminado = equipoBO.eliminarEquipo(idEquipo);
    //System.out.println("¿Equipo eliminado?: " + eliminado);
}
}
    
    

