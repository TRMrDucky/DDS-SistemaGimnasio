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
public class CompraDTO {
    private ClienteDTO clienteDTO;
    private String membresiaDTO;//cambiar string por MembresiaDTO
    private List<String> serviciosExtras;//cambiar String por serviciosExtras
    private double total;

    public CompraDTO() {
    }

    public CompraDTO(ClienteDTO clienteDTO, String membresiaDTO, List<String> serviciosExtras, double total) {
        this.clienteDTO = clienteDTO;
        this.membresiaDTO = membresiaDTO;
        this.serviciosExtras = serviciosExtras;
        this.total = total;
    }

    public ClienteDTO getClienteDTO() {
        return clienteDTO;
    }

    public String getMembresiaDTO() {
        return membresiaDTO;
    }

    public List<String> getServiciosExtras() {
        return serviciosExtras;
    }

    public double getTotal() {
        return total;
    }

    public void setClienteDTO(ClienteDTO clienteDTO) {
        this.clienteDTO = clienteDTO;
    }

    public void setMembresiaDTO(String membresiaDTO) {
        this.membresiaDTO = membresiaDTO;
    }

    public void setServiciosExtras(List<String> serviciosExtras) {
        this.serviciosExtras = serviciosExtras;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
