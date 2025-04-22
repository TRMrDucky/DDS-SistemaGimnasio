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
public class Visita extends Membresia {

    private Date inicio;
    private Date fin;

    public Visita(String nombre, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        super(nombre, precio, serviciosExtra, estado);
        super.setId(6);
    }

    public Visita(String nombre, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Date inicio) {
        super(nombre, precio, serviciosExtra, estado);
        super.setId(6);
        this.inicio = inicio;
        this.fin = new Date(inicio.getTime() + 86400000L);
    }

    public Visita() {
    }

}
