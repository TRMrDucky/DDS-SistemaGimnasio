/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import dtos.ServicioExtraDTO;
import java.util.ArrayList;
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
        List<ServicioExtraDTO> servicios = new ArrayList<>();
        servicios.add(new ServicioExtraDTO(1, "Entrenador", 150));
        servicios.add(new ServicioExtraDTO(2, "Plan Alimenticio", 150));
        servicios.add(new ServicioExtraDTO(3, "Clases de yoga (Lu, Mi, Vi 6-7:30 AM)", 100));
        servicios.add(new ServicioExtraDTO(4, "Spinning (Ma, Ju 6-7:30 AM)", 50));
        servicios.add(new ServicioExtraDTO(5, "Masaje relajante", 200));
        servicios.add(new ServicioExtraDTO(6, "Asesoría Nutricional", 180));

        new ServiciosExtras(servicios).setVisible(true);
    }
    
}
