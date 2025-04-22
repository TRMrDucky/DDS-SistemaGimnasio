/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock.membresias;

import Enumeradores.EnumEstadoMembresia;
import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 52644
 */
public class FifteenDaysPass extends Membresia {

    private Date inicio;
    private Date fin;
    private final Long DURACION = 1296000000L;

    public FifteenDaysPass(String nombre, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(nombre, precio, serviciosExtra, estado);
        super.setId(4);
    }

    public FifteenDaysPass(String nombre, Date inicio, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(nombre, precio, serviciosExtra, estado);
        this.inicio = inicio;
        super.setId(4);
        this.fin = new Date(inicio.getTime()+DURACION);
    }
    
    

    public FifteenDaysPass() {
    }
    
    
}
