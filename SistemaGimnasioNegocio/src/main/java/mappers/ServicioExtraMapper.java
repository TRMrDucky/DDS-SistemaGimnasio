/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.ServicioExtra;
import dtos.ServicioExtraDTO;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraMapper {

    public static ServicioExtra toEntity(ServicioExtraDTO servicioExtra) {
        System.out.println("se mapper antes"+servicioExtra);
    ServicioExtra se = new ServicioExtra(servicioExtra.getNombreServicio(),servicioExtra.getPrecio(),servicioExtra.getDescripcion());
    if (servicioExtra.getId() != null && !servicioExtra.getId().isEmpty()) {
        se.setIdString(servicioExtra.getId());
    }
    return se;
}
    
    

    public static ServicioExtraDTO toDTO(ServicioExtra se) {
        ServicioExtraDTO servicio =  new ServicioExtraDTO(se.getNombreServicio(), se.getPrecio(), se.getDescripcion());
        servicio.setId(se.getIdString());
        return servicio;
    }

    public static List<ServicioExtraDTO> toListDTO(List<ServicioExtra> serviciosExtra) {
        List<ServicioExtraDTO> servicios = new LinkedList<>();
        for (ServicioExtra se : serviciosExtra) {
            servicios.add(ServicioExtraMapper.toDTO(se));
        }
        return servicios;
    }

    public static List<ServicioExtra> toListEntity(List<ServicioExtraDTO> serviciosExtra) {
        System.out.println("antes de convertir "+serviciosExtra);
        List<ServicioExtra> servicios = new LinkedList<>();
        for (ServicioExtraDTO se : serviciosExtra) {
            
            System.out.println("antes:" +se);
            ServicioExtra entidad = ServicioExtraMapper.toEntity(se);
            System.out.println("despues "+entidad);
            servicios.add(entidad);
        }
        return servicios;
    }
}
