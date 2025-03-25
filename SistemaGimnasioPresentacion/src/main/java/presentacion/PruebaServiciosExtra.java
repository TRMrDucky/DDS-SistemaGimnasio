/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import dtos.ClienteRegConMembDTO;
import implementaciones.ManejadorComprasMembresias;
import interfaces.IManejadorComprasMembresias;

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
       ClienteRegConMembDTO cliente = new ClienteRegConMembDTO("entrenador", 150, null, 1);
        new ServiciosExtras(mane, cliente).setVisible(true);
        
    }
    
}
