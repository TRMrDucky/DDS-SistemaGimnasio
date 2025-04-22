/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import Enumeradores.EnumEstadoMembresia;
import clases.mock.ServicioExtra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaDTO {
    
    private String nombre;
    private int id;
    private double precio;
    private List<ServicioExtra> serviciosExtra;
    private EnumEstadoMembresia estado;
    private Date inicio;
    private Date fin;
    private Date

    public MembresiaDTO(String nombre, int id, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
    }

    public MembresiaDTO(){}
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    
    
}
