/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaMapper {
    public static Membresia toEntity(TipoMembresiaDTO membresia){
        return new Membresia(membresia.getTipoMembresia(), membresia.getPrecio(),
                membresia.getServiciosExtras().stream()
                .map(servicioDTO -> new ServicioExtra(servicioDTO.getId(), servicioDTO.getNombreServicio(), servicioDTO.getPrecio()))
                 .collect(Collectors.toList())
        );
    }

    
    
    public static TipoMembresiaDTO toDTO(Membresia membresia){
        List<ServicioExtraDTO> servicios = (membresia.getServiciosExtras() != null) ?
                membresia.getServiciosExtras().stream()
                .map(servicio -> new ServicioExtraDTO(servicio.getId(), servicio.getNombreServicio(), servicio.getPrecio()))
                .collect(Collectors.toList()) :
                Collections.emptyList();
        return new TipoMembresiaDTO(membresia.getTipo(), membresia.getCosto(), servicios);
    }
    
    
    public static List<TipoMembresiaDTO> toListDTO(List<Membresia>membresias){
        return membresias.stream()
                .map(MembresiaMapper:: toDTO)
                .collect(Collectors.toList());
    }
    
  
}
