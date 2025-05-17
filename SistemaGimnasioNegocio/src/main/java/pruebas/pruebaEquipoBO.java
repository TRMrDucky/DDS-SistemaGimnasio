/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import bos.EquipoBO;
import daos.EquipoDAO;
import dtos.EquipoDTO;
import excepciones.NegocioException;
import interfaces.bo.IEquipoBO;
import interfaces.dao.IEquipoDAO;
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
        IEquipoBO equipoBO = new EquipoBO(equipoDAO);
   
        EquipoDTO nuevoEquipo = new EquipoDTO("Laptop HP", "HP", "X200", "ZZZZZZ", new Date());
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
  
       boolean eliminado = equipoBO.eliminarEquipo(idEquipo);
        System.out.println("¿Equipo eliminado?: " + eliminado);
    }
}
    
    

