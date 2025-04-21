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
public class Visita extends Membresia{
    private Date fecha;

    public Visita(double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(precio, serviciosExtra, estado);
        super.setId(6);
    }

    public Visita(Date fecha, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(precio, serviciosExtra, estado);
        this.fecha = fecha;
        super.setId(6);
    }
    
    

    public Visita() {
    }
    
    
}
