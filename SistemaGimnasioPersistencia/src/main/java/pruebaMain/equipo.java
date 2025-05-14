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

       try {
            // Aquí debes colocar un ID válido que exista en tu colección de mantenimientos
            String idEquipo = "68215619e100143321664070"; // Asegúrate que este ID sea real en tu base

            List<Mantenimiento> historial = MantenimientoDAO.getInstance().obtenerHistorialPorEquipo(idEquipo);

            if (historial.isEmpty()) {
                System.out.println("No se encontraron mantenimientos para ese equipo.");
            } else {
                for (Mantenimiento m : historial) {
                    System.out.println("Fecha: " + m.getFechaMantenimiento());
                    System.out.println("Tipo: " + m.getTipoMantenimiento());
                    System.out.println("Costo: " + m.getCosto());
                    System.out.println("Observaciones: " + m.getObservaciones());
                    System.out.println("Fecha seguimiento: " + m.getFechaSeguimiento());
                    System.out.println("-------------");
                }
            }
        } catch (ConsultarMantenimientoException e) {
            e.printStackTrace();
        }
    }
    }

    


    
    
    
    

