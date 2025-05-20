/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.Membresia;
import clases.mock.MembresiaReemplazar;
import clases.mock.ServicioExtra;
import dtos.ServicioExtraDTO;
import dtos.MembresiaDTO;
import dtos.MembresiaPagadaDTO;
import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ramón Zamudio
 */
public class MembresiaMapper {

    public static Membresia toEntity(MembresiaDTO membresia) {
        Membresia membresiaEntidad=  new Membresia(
                membresia.getNombre(),
              //  membresia.getId(),
                membresia.getPrecio(),
                ServicioExtraMapper.toListEntity(membresia.getServiciosExtra()),
                membresia.getEstado(),
                membresia.getDuracion()
        );
        if(membresia.getId() !=null && !membresia.getId().isEmpty()){
            membresiaEntidad.setIdString(membresia.getId());
        }
        return membresiaEntidad;
    }

    public static MembresiaDTO toDTO(Membresia membresia) {
        MembresiaDTO membresiaDTO= new MembresiaDTO(
                membresia.getNombre(),
             //   membresia.getId(),
                membresia.getPrecio(),
                ServicioExtraMapper.toListDTO(membresia.getServiciosExtra()),
                membresia.getEstado(),
                membresia.getDuracion()
                
        );
         membresiaDTO.setId(membresia.getIdString());
         return membresiaDTO;
    }

    public static List<MembresiaDTO> toListDTO(List<Membresia> membresias) {
       List<MembresiaDTO> membresiasDTO= new LinkedList<>();
        for (Membresia membresia: membresias){
            membresiasDTO.add(MembresiaMapper.toDTO(membresia));
            
        }
        return membresiasDTO;
       
    }
    
    public static MembresiaPagadaDTO memToMemPagadaDTO(Membresia mem){
        if(mem.getServiciosExtra()!=null){
            List<ServicioExtraDTO> servicios = ServicioExtraMapper.toListDTO(mem.getServiciosExtra());
            return new MembresiaPagadaDTO(mem.getNombre(), mem.getIdString(), mem.getPrecio(), servicios, mem.getEstado(), mem.getInicio(), mem.getFin());
        }
        return new MembresiaPagadaDTO(mem.getNombre(), mem.getIdString(), mem.getPrecio(), new  LinkedList<ServicioExtraDTO>(), mem.getEstado(), mem.getInicio(), mem.getFin());
    }
    
    

   
}
