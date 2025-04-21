/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.Date;
import java.util.List;
import Enumeradores.EnumEstadoMembresia;

/**
 *
 * @author 52644
 */
public class Membresia {
    private int id;
    private double precio;
    private List<ServicioExtra> serviciosExtra;
    private EnumEstadoMembresia estado;

    public Membresia(double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
    }

    public Membresia() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<ServicioExtra> getServiciosExtra() {
        return serviciosExtra;
    }

    public void setServiciosExtra(List<ServicioExtra> serviciosExtra) {
        this.serviciosExtra = serviciosExtra;
    }

    public EnumEstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EnumEstadoMembresia estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membresia other = (Membresia) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Membresia{" + "id=" + id + ", precio=" + precio + ", serviciosExtra=" + serviciosExtra + ", estado=" + estado + '}';
    }

    
    
}
