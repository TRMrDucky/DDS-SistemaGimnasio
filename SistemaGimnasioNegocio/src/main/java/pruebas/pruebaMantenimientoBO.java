/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import bos.MantenimientoBO;
import daos.MantenimientoDAO;
import dtos.HistorialEquipoDTO;
import dtos.MantenimientoDTO;
import excepciones.NegocioException;
import interfaces.bo.IMantenimientoBO;
import interfaces.dao.IMantenimientoDAO;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cricri
 */
public class pruebaMantenimientoBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
               try {
            // Instancia de DAO y BO
            IMantenimientoDAO mantenimientoDAO = MantenimientoDAO.getInstance();
            IMantenimientoBO mantenimientoBO = new MantenimientoBO(mantenimientoDAO);

            // ID del equipo al que se le hará mantenimiento (puedes reemplazarlo con uno válido de tu BD)
            String idEquipo = "68268ee7ee194609c2353533"; 

            // Crear un nuevo mantenimiento
            MantenimientoDTO nuevoMantenimiento = new MantenimientoDTO(
                idEquipo, new Date(), "Mantenimiento preventivo", 900.0f, "Cambio de filtro", new Date()
            );

            MantenimientoDTO mantenimientoAgregado = mantenimientoBO.registrarMantenimiento(nuevoMantenimiento);
            System.out.println("Mantenimiento registrado: " + mantenimientoAgregado);

            // Consultar historial de mantenimientos por equipo
            List<HistorialEquipoDTO> historial = mantenimientoBO.obtenerHistorialPorEquipo(idEquipo);
            System.out.println("Historial de mantenimientos del equipo:");
            for (HistorialEquipoDTO registro : historial) {
                System.out.println(registro);
            }

            // Eliminar los mantenimientos del equipo
           boolean eliminado = mantenimientoBO.eliminarMantenimientosPorEquipo(idEquipo);
           System.out.println("¿Mantenimientos eliminados?: " + eliminado);

        } catch (NegocioException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
    
    

