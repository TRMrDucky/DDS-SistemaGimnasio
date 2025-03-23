/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import dtos.ServicioExtraDTO;
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
        LinkedHashMap<Long, ServicioExtraDTO> serviciosExtras = new LinkedHashMap<>();
        serviciosExtras.put(1L, new ServicioExtraDTO(1, "Entrenador", 150));
        serviciosExtras.put(2L, new ServicioExtraDTO(2, "Plan Alimenticio", 150));
        serviciosExtras.put(3L, new ServicioExtraDTO(3, "Clases de yoga (Lu, Mi, Vi 6-7:30 AM)", 100));
        serviciosExtras.put(4L, new ServicioExtraDTO(4, "Spinning (Ma, Ju 6-7:30 AM)", 50));
        serviciosExtras.put(5L, new ServicioExtraDTO(5, "Masaje relajante", 200));
        serviciosExtras.put(6L, new ServicioExtraDTO(6, "Asesoría Nutricional", 180));

        List<ServicioExtraDTO> seleccionados = new ArrayList<>();
            seleccionados.add(serviciosExtras.get(1L));
            seleccionados.add(serviciosExtras.get(3L));
            seleccionados.add(serviciosExtras.get(5L));

        new ServiciosExtras(serviciosExtras, seleccionados).setVisible(true);
        
    }
    
}
