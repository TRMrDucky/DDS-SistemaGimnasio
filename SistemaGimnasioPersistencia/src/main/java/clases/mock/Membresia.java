/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import dtos.ServicioExtraDTO;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class Membresia {

    int idMembresia;
    String tipo;
    String estado;
    double costo;
    private List<ServicioExtraDTO> serviciosExtras;

    public Membresia() {
    }

    public Membresia(int idMembresia, String tipo, String estado, Double costo) {
        this.idMembresia = idMembresia;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
    }
    
    public Membresia(String tipo, double costo, List<ServicioExtraDTO> serviciosExtras) {
        this.tipo= tipo;
        this.costo= costo;
        this.serviciosExtras = serviciosExtras;
        
    }
    
    

    public Membresia(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public int getIdMembresia() {
        return idMembresia;
    }

    public void setIdMembresia(int idMembresia) {
        this.idMembresia = idMembresia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

}
