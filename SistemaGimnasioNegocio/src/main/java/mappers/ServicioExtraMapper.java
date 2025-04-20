/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.ServicioExtra;
import dtos.ServicioExtraDTO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraMapper {
    public static ServicioExtra toEntity(ServicioExtraDTO servicioExtra){
        return new ServicioExtra(servicioExtra.getId(),servicioExtra.getNombreServicio(), servicioExtra.getPrecio(),servicioExtra.getDescripcion());
    }
    public static ServicioExtraDTO toDTO(ServicioExtra se){
        return new ServicioExtraDTO(se.getId(),se.getNombreServicio(),se.getPrecio(),se.getDescripcion());
    }
    public static List<ServicioExtraDTO> toListDTO(List<ServicioExtra> serviciosExtra){
        List<ServicioExtraDTO>servicios = new LinkedList<>();
        for(ServicioExtra se : serviciosExtra){
            servicios.add(new ServicioExtraDTO(se.getId(),se.getNombreServicio(),se.getPrecio(),se.getDescripcion()));
        }
        return servicios;
    }
}
