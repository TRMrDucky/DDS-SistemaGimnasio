/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;


import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class Membresia {

    private int idMembresia;
    private String tipo;
    private String estado;
    private double costo;
    private List<ServicioExtra> serviciosExtras;

    public Membresia() {
    }

    public Membresia(int idMembresia, String tipo, String estado, Double costo) {
        this.idMembresia = idMembresia;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
    }
    
    public Membresia(String tipo, double costo, List<ServicioExtra> serviciosExtras) {
        this.tipo= tipo;
        this.costo= costo;
        this.serviciosExtras = serviciosExtras;
        
    }

    public Membresia(int idMembresia, String tipo, String estado, double costo, List<ServicioExtra> serviciosExtras) {
        this.idMembresia = idMembresia;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
        this.serviciosExtras = serviciosExtras;
    }
    
    
    
    

    public Membresia(String tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public Membresia(String tipoMembresia, double precio, Stream<Object> map) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public List<ServicioExtra> getServiciosExtras() {
        return serviciosExtras;
    }

    public void setServiciosExtras(List<ServicioExtra> serviciosExtras) {
        this.serviciosExtras = serviciosExtras;
    }
    
    

}
