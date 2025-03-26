/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import clasesmock.ServicioExtra;
import dtos.ClienteRegConMembDTO;
import dtos.ServicioExtraDTO;
import implementaciones.ManejadorComprasMembresias;
import interfaces.IManejadorComprasMembresias;
import java.util.LinkedList;

/**
 *
 * @author Ramón Zamudio
 */
public class PruebaServiciosExtra {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       IManejadorComprasMembresias mane = new ManejadorComprasMembresias();
       LinkedList<ServicioExtraDTO> servicios = new LinkedList<>();
       ServicioExtraDTO servicio = new ServicioExtraDTO(2, "Plan Alimenticio", 150);
       servicios.add(servicio);
       ClienteRegConMembDTO cliente = new ClienteRegConMembDTO("mensual", 150, servicios, 1);
       new ServiciosExtras(mane, cliente).setVisible(true);
        
    }
    
}
