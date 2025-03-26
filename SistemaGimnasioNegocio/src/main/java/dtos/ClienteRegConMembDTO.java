/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ClienteRegConMembDTO {
    private String tipoMembresia;
    private double precio;
    private List<ServicioExtraDTO>servicios;
    private int idCliente;
    
    //todo
    public ClienteRegConMembDTO(String tipoMembresia, double precio, List<ServicioExtraDTO> servicios, int idCliente) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.servicios = servicios;
        this.idCliente = idCliente;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<ServicioExtraDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioExtraDTO> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "SeleccionarMembresiaDTO{" + "tipoMembresia=" + tipoMembresia + ", precio=" + precio + ", servicios=" + servicios + '}';
    }
    
    

}


