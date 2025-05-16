/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import Enumeradores.EnumEstadoMembresia;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaDTO {

    private String nombre;
    private String id;
    private double precio;
    private List<ServicioExtraDTO> serviciosExtra;
    private EnumEstadoMembresia estado;
    private Long duracion;

    public MembresiaDTO(String nombre, String id, double precio, List<ServicioExtraDTO> serviciosExtra, EnumEstadoMembresia estado) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
//
    }

    public MembresiaDTO(String nombre, double precio, List<ServicioExtraDTO> serviciosExtra, Long duracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.duracion = duracion;
    }
    
    

    public MembresiaDTO(String nombre, String id, double precio, List<ServicioExtraDTO> serviciosExtra, EnumEstadoMembresia estado, Long duracion) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.duracion = duracion;
    }

    public MembresiaDTO(String nombre, double precio, List<ServicioExtraDTO> serviciosExtra, EnumEstadoMembresia estado, Long duracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.duracion = duracion;
    }

    public MembresiaDTO(String nombre, double precio, List<ServicioExtraDTO> serviciosExtra, EnumEstadoMembresia estado) {
        this.nombre = nombre;
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

    public String getId() {
        return id;
    }
//
    public void setId(String id) {
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

    public Long getDuracion() {
        return duracion;
    }
//
    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "MembresiaDTO{" + "nombre=" + nombre + ", id=" + id + ", precio=" + precio + ", serviciosExtra=" + serviciosExtra + ", estado=" + estado + ", duracion=" + duracion + '}';
    }
    
    
    

}
