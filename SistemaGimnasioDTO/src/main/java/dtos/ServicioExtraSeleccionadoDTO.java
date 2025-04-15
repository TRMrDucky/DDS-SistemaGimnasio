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
public class ServicioExtraSeleccionadoDTO {
    private long idCliente;
    private long id;
    private List<String>servicios;//cambiar String por servicios

    public ServicioExtraSeleccionadoDTO() {
    }

    
    public ServicioExtraSeleccionadoDTO(long idCliente, long id, List<String> servicios) {
        this.idCliente = idCliente;
        this.id = id;
        this.servicios = servicios;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public long getId() {
        return id;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setServicios(List<String> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "ServicioExtraSeleccionadoDTO{" + "idCliente=" + idCliente + ", id=" + id + ", servicios=" + servicios + '}';
    }
    
    
}
