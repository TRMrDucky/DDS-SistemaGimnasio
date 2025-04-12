/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.Membresia;
import dtos.TipoMembresiaDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaMapper {
    public static Membresia toMembresia(TipoMembresiaDTO membresia){
        return new Membresia(membresia.getTipoMembresia(), membresia.getPrecio());
    }
    public static TipoMembresiaDTO toDTO(Membresia membresia){
        return new TipoMembresiaDTO( membresia.getTipo(), membresia.getCosto());
    }
    public static List<TipoMembresiaDTO> toListDTO(List<Membresia>membresias){
        List<TipoMembresiaDTO> listaMembresias = new LinkedList<>();
        for(Membresia membresia : membresias){
            listaMembresias.add(new TipoMembresiaDTO( membresia.getTipo(), membresia.getCosto()));
        }
        return listaMembresias;
    }
}
