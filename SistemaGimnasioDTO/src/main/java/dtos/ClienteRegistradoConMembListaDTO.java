/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.List;

/**
 *
 * @author Cricri
 */
public class ClienteRegistradoConMembListaDTO {
     private ClienteRegistradoDTO cliente;
    private List<MembresiaPagadaDTO> membresias; 

    public ClienteRegistradoConMembListaDTO(ClienteRegistradoDTO cliente, List<MembresiaPagadaDTO> membresias){
        this.cliente = cliente;
        this.membresias = membresias;
    }

    public ClienteRegistradoConMembListaDTO(){}

    public ClienteRegistradoDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteRegistradoDTO cliente) {
        this.cliente = cliente;
    }

    public List<MembresiaPagadaDTO> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<MembresiaPagadaDTO> membresias) {
        this.membresias = membresias;
    }

    @Override
    public String toString() {
        return "ClienteRegistradoConMembListaDTO{" + "cliente=" + cliente + ", membresias=" + membresias + '}';
    }
    
    
    
}

