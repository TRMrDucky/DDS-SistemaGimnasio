/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class ClienteRegConMemYServDTO {
    private String tipoMembresia;
    private double precio;
    private List<ServicioExtraDTO>servicios;
    private int idCliente;

    public ClienteRegConMemYServDTO(String tipoMembresia, double precio, List<ServicioExtraDTO> servicios, int idCliente) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
        this.servicios = servicios;
        this.idCliente = idCliente;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public double getPrecio() {
        return precio;
    }

    public List<ServicioExtraDTO> getServicios() {
        return servicios;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setServicios(List<ServicioExtraDTO> servicios) {
        this.servicios = servicios;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        return "ClienteRegConMemYServ{" + "tipoMembresia=" + tipoMembresia + ", precio=" + precio + ", servicios=" + servicios + ", idCliente=" + idCliente + '}';
    }
    
    
}
