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
public class SevenDaysPass extends Membresia {
    
    private Date inicio;
    private Date fin;
    private final Long DURACION = 604800000L;

    public SevenDaysPass(double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(precio, serviciosExtra,estado);
        super.setId(2);
    }

    public SevenDaysPass(Date inicio, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(precio, serviciosExtra, estado);
        super.setId(2);
        this.inicio = inicio;
        this.fin = new Date((inicio.getTime()+DURACION));
    }
    
    
    public SevenDaysPass() {
    }
    
    
}
