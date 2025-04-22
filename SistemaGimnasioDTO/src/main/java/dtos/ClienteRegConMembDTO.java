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
    private ClienteRegistradoDTO cliente;
    private MembresiaDTO membresia;
    
    //todo
    public ClienteRegConMembDTO(ClienteRegistradoDTO cliente, MembresiaDTO membresia){
        this.cliente = cliente;
        this.membresia = membresia;
    }

    public ClienteRegConMembDTO(){}

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
    
}


