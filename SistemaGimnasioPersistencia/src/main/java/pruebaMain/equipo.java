/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaMain;

import clases.mock.Equipo;
import clases.mock.Mantenimiento;
import com.mongodb.client.MongoClients;
import daos.EquipoDAO;
import daos.MantenimientoDAO;
import excepciones.AgregarEquipoException;
import excepciones.ConsultarEquipoException;
import excepciones.ConsultarMantenimientoException;
import excepciones.EliminarEquipoException;
import excepciones.RegistrarMantenimientoException;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Cricri
 */
public class equipo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     
         /**try {
    
            EquipoDAO equipoDAO = EquipoDAO.getInstance();
         
            String idEquipo = ("68215619e100143321664070");

        
            boolean eliminado = equipoDAO.eliminarEquipo(idEquipo);

           
            if (eliminado) {
                System.out.println("Equipo eliminado correctamente.");
            } else {
                System.out.println("️ No se eliminó el equipo (verifica si existe).");
            }

        } catch (EliminarEquipoException e) {
            System.err.println(" Error al eliminar el equipo: " + e.getMessage());
            e.printStackTrace();
        }
     */
         
        

 /**
        Equipo equipo = new Equipo();
        equipo.setNombre("hack");
        equipo.setNumeroSerie("hack-2025-9999");
        equipo.setMarca("hackfit");
        equipo.setFechaAdquisicion(new Date()); 
    

        try {
            Equipo equipoAgregado = EquipoDAO.getInstance().agregarEquipo(equipo);
            System.out.println("Equipo agregado exitosamente:");
            System.out.println(equipoAgregado);
        } catch (AgregarEquipoException e) {
            System.err.println("Error al agregar equipo: " + e.getMessage());
            e.printStackTrace();
        }
          */ 


      try {
          
            MantenimientoDAO dao = MantenimientoDAO.getInstance();

            
            Mantenimiento nuevo = new Mantenimiento(
                new ObjectId("6827d4c03b3f7d7e13b5eeae"),
                new Date(), // Fecha del mantenimiento
                "Cambio de aceite", // nombreMantenimiento
                800.0f, // Costo
                "Revisión general y limpieza interna", 
                new Date() // Fecha de seguimiento
            );

            // Registrar el mantenimiento
            Mantenimiento registrado = dao.registrarMantenimiento(nuevo);

            // Mostrar resultado 
            System.out.println("Mantenimiento registrado:");
            System.out.println("ID del equipo: " + registrado.getIdEquipo());
            System.out.println("Nombre: " + registrado.getNombreMantenimiento());
            System.out.println("Costo: $" + registrado.getCosto());
            System.out.println("Observaciones: " + registrado.getObservaciones());
            System.out.println("Fecha mantenimiento: " + registrado.getFechaMantenimiento());
            System.out.println("Fecha seguimiento: " + registrado.getFechaSeguimiento());

        } catch (RegistrarMantenimientoException e) {
            System.err.println(" Error al registrar mantenimiento: " + e.getMessage());
              e.printStackTrace(); 
        }
        

   
}

    }
    

    


    


    

    

    


    
    
    
    

