/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clasesmock.ServicioExtra;
import dtos.ServicioExtraDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraMapper {
    public static ServicioExtra toEntity(ServicioExtraDTO servicioExtra){
        return new ServicioExtra(servicioExtra.getNombreServicio(), servicioExtra.getPrecio());
    }
    public static ServicioExtraDTO toDTO(ServicioExtra se){
        return new ServicioExtraDTO(se.getNombreServicio(),se.getPrecio());
    }
    public static List<ServicioExtraDTO> toListDTO(List<ServicioExtra> serviciosExtra){
        List<ServicioExtraDTO>servicios = new LinkedList<>();
        for(ServicioExtra se : serviciosExtra){
            servicios.add(new ServicioExtraDTO(se.getNombreServicio(),se.getPrecio()));
        }
        return servicios;
    }
}
