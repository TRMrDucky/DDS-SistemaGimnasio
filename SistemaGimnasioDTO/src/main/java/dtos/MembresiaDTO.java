/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import Enumeradores.EnumEstadoMembresia;
import clases.mock.ServicioExtra;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaDTO {

    private String nombre;
    private int id;
    private double precio;
    private List<ServicioExtraDTO> serviciosExtra;
    private EnumEstadoMembresia estado;

    public MembresiaDTO(String nombre, int id, double precio, List<ServicioExtraDTO> serviciosExtra, EnumEstadoMembresia estado) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;

    }

    public MembresiaDTO() {
    }

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

    public List<ServicioExtraDTO> getServiciosExtra() {
        return serviciosExtra;
    }

    public void setServiciosExtra(List<ServicioExtraDTO> serviciosExtra) {
        this.serviciosExtra = serviciosExtra;
    }

    public EnumEstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EnumEstadoMembresia estado) {
        this.estado = estado;
    }

}
