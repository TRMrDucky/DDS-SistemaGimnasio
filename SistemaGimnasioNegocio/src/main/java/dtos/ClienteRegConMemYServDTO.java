/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 * Clase que representa a un cliente con una membresía y servicios adicionales.
 *
 * @author Ramón Zamudio
 */
public class ClienteRegConMemYServDTO {

    private ClienteRegistradoDTO cliente;
    private MembresiaDTO membresia;
    private List<ServicioExtraDTO> servicios;

    public ClienteRegConMemYServDTO(ClienteRegistradoDTO cliente, MembresiaDTO membresia, List<ServicioExtraDTO> servicios) {
        this.cliente = cliente;
        this.membresia = membresia;
        this.servicios = servicios;
        
    }

   public ClienteRegConMemYServDTO(){}

    public ClienteRegistradoDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRegistradoDTO cliente) {
        this.cliente = cliente;
    }

    public MembresiaDTO getMembresia() {
        return membresia;
    }

    public void setMembresia(MembresiaDTO membresia) {
        this.membresia = membresia;
    }

    public List<ServicioExtraDTO> getServicios() {
        return servicios;
    }

    public void setServicios(List<ServicioExtraDTO> servicios) {
        this.servicios = servicios;
    }

   
}
