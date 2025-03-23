/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import dtos.ServicioExtraDTO;
import implementaciones.ManejadorComprasMembresias;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ramón Zamudio
 */
public class PruebaServiciosExtra {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
       ManejadorComprasMembresias mane = new ManejadorComprasMembresias();
       
       LinkedHashMap<Long, ServicioExtraDTO> mapa = mane.obtenerServiciosExtrasDTO();
       List<ServicioExtraDTO> serviciosSeleccionados = new ArrayList<>();
       if (mapa.containsKey(1L)) {
            serviciosSeleccionados.add(mapa.get(1L));
        }
        if (mapa.containsKey(3L)) {
            serviciosSeleccionados.add(mapa.get(3L));
        }
       
        new ServiciosExtras(serviciosSeleccionados).setVisible(true);
        
    }
    
}
