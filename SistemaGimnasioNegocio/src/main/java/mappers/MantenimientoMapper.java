/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.Mantenimiento;
import dtos.MantenimientoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cricri
 */
public class MantenimientoMapper {
    
    public static Mantenimiento toEntity(MantenimientoDTO dto) {
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setIdEquipoString(dto.getIdEquipo()); 
        mantenimiento.setFechaMantenimiento(dto.getFechaMantenimiento());
        mantenimiento.setNombreMantenimiento(dto.getTipoMantenimiento());
        mantenimiento.setCosto(dto.getCosto());
        mantenimiento.setObservaciones(dto.getObservaciones());
        mantenimiento.setFechaSeguimiento(dto.getFechaSeguimiento());

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            mantenimiento.setIdMantenimientoString(dto.getId()); 
        }
        return mantenimiento;
    }

    public static MantenimientoDTO toDTO(Mantenimiento entidad) {
        MantenimientoDTO dto = new MantenimientoDTO(
            entidad.getIdEquipoString(),
            entidad.getFechaMantenimiento(),
            entidad.getNombreMantenimiento(),
            entidad.getCosto(),
            entidad.getObservaciones(),
            entidad.getFechaSeguimiento()
        );
        dto.setId(entidad.getIdMantenimientoString()); 
        return dto;
    }

    public static List<MantenimientoDTO> toListDTO(List<Mantenimiento> listaEntidades) {
        List<MantenimientoDTO> listaDTO = new ArrayList<>();
        for (Mantenimiento m : listaEntidades) {
            listaDTO.add(toDTO(m));
        }
        return listaDTO;
    }

    public static List<Mantenimiento> toListEntity(List<MantenimientoDTO> listaDTO) {
        List<Mantenimiento> listaEntidades = new ArrayList<>();
        for (MantenimientoDTO dto : listaDTO) {
            listaEntidades.add(toEntity(dto));
        }
        return listaEntidades;
    }
}