/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import bos.EquipoBO;
import bos.MantenimientoBO;
import daos.EquipoDAO;
import daos.MantenimientoDAO;
import excepciones.NegocioException;
import interfaces.bo.IEquipoBO;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IEquipoDAO;
import interfaces.dao.IMantenimientoDAO;

/**
 *
 * @author Cricri
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // Crear instancias DAO
            IEquipoDAO equipoDAO = EquipoDAO.getInstance();
            IMantenimientoDAO mantenimientoDAO = MantenimientoDAO.getInstance();

            // Crear instancia de MantenimientoBO
            IMantenimientoBO mantenimientoBO = new MantenimientoBO(mantenimientoDAO);

            // Crear instancia de EquipoBO con sus dependencias
            IEquipoBO equipoBO = new EquipoBO(equipoDAO, mantenimientoBO);

            // ID del equipo que quieres eliminar
            String idEquipo = "6827d4c03b3f7d7e13b5eeae";

            // Eliminar equipo y mantenimientos asociados
            boolean eliminado = equipoBO.eliminarEquipoYAsociados(idEquipo);

            // Mostrar resultado
            if (eliminado) {
                System.out.println("El equipo y sus mantenimientos fueron eliminados correctamente.");
            } else {
                System.out.println("No se pudo eliminar completamente el equipo y/o sus mantenimientos.");
            }

        } catch (NegocioException e) {
            System.err.println("Ocurrió un error al eliminar el equipo y sus mantenimientos:");
            e.printStackTrace();
        }
    }
    }
    

