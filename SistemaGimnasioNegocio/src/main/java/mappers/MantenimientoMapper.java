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
 * Clase de utilidad para mapear entre la entidad {@link Mantenimiento} y su DTO {@link MantenimientoDTO}.
 * Proporciona métodos estáticos para convertir objetos individuales y listas entre ambos tipos.
 * 
 * @author Cricri
 */
public class MantenimientoMapper {

    /**
     * Convierte un {@link MantenimientoDTO} a una entidad {@link Mantenimiento}.
     * 
     * @param dto DTO con los datos del mantenimiento.
     * @return Entidad {@link Mantenimiento} creada a partir del DTO.
     */
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

    /**
     * Convierte una entidad {@link Mantenimiento} a un {@link MantenimientoDTO}.
     * 
     * @param entidad Entidad mantenimiento.
     * @return DTO con los datos del mantenimiento.
     */
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

    /**
     * Convierte una lista de entidades {@link Mantenimiento} a una lista de {@link MantenimientoDTO}.
     * 
     * @param listaEntidades Lista de entidades mantenimiento.
     * @return Lista de DTOs de mantenimiento.
     */
    public static List<MantenimientoDTO> toListDTO(List<Mantenimiento> listaEntidades) {
        List<MantenimientoDTO> listaDTO = new ArrayList<>();
        for (Mantenimiento m : listaEntidades) {
            listaDTO.add(toDTO(m));
        }
        return listaDTO;
    }

    /**
     * Convierte una lista de {@link MantenimientoDTO} a una lista de entidades {@link Mantenimiento}.
     * 
     * @param listaDTO Lista de DTOs mantenimiento.
     * @return Lista de entidades mantenimiento.
     */
    public static List<Mantenimiento> toListEntity(List<MantenimientoDTO> listaDTO) {
        List<Mantenimiento> listaEntidades = new ArrayList<>();
        for (MantenimientoDTO dto : listaDTO) {
            listaEntidades.add(toEntity(dto));
        }
        return listaEntidades;
    }
}
