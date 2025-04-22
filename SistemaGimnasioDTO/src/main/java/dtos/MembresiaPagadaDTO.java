/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import Enumeradores.EnumEstadoMembresia;
import clases.mock.ServicioExtra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author 52644
 */
public class MembresiaPagadaDTO extends MembresiaDTO{
    
    private Date inicio;
    private Date fin;

    public MembresiaPagadaDTO(String nombre, int id, double precio, List<ServicioExtraDTO> serviciosExtra, EnumEstadoMembresia estado, Date inicio, Date fin) {
        super(nombre, id, precio, serviciosExtra, estado);
        this.inicio = inicio;
        this.fin = fin;
    }

    public MembresiaPagadaDTO(Date inicio, Date fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    
    
}
