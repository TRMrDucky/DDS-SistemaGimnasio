/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import Enumeradores.EnumEstadoMembresia;
import clases.mock.Membresia;
import clases.mock.MembresiaReemplazar;
import clases.mock.ServicioExtra;
import dtos.ServicioExtraDTO;
import dtos.MembresiaDTO;
import dtos.MembresiaPagadaDTO;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaMapper {

    public static Membresia toEntity(MembresiaDTO membresia) {
        return new Membresia(
                membresia.getNombre(),
                membresia.getId(),
                membresia.getPrecio(),
                ServicioExtraMapper.toListEntity(membresia.getServiciosExtra()),
                membresia.getEstado()
        );
    }

    public static MembresiaDTO toDTO(Membresia membresia) {
        return new MembresiaDTO(
                membresia.getNombre(),
                membresia.getId(),
                membresia.getPrecio(),
                ServicioExtraMapper.toListDTO(membresia.getServiciosExtra()),
                membresia.getEstado()
        );
    }

    public static List<MembresiaDTO> toListDTO(List<Membresia> membresias) {
        return membresias.stream()
                .map(MembresiaMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    

   
}
