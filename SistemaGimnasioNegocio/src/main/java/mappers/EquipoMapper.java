/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mappers;

import clases.mock.Equipo;
import dtos.EquipoDTO;
import java.util.ArrayList;
import java.util.List;
/**
 * Clase de utilidad para mapear entre la entidad {@link Equipo} y su DTO {@link EquipoDTO}.
 * Proporciona métodos estáticos para convertir objetos individuales y listas entre ambos tipos.
 * 
 * @author Cricri
 */
public class EquipoMapper {

    /**
     * Convierte un {@link EquipoDTO} a una entidad {@link Equipo}.
     * 
     * @param dto DTO con datos del equipo.
     * @return Entidad {@link Equipo} creada a partir del DTO.
     */
    public static Equipo toEntity(EquipoDTO dto) {
        Equipo equipo = new Equipo();
        equipo.setNombre(dto.getNombre());
        equipo.setMarca(dto.getMarca());
        equipo.setModelo(dto.getModelo());
        equipo.setNumeroSerie(dto.getNumeroSerie());
        equipo.setFechaAdquisicion(dto.getFechaAdquisicion());

        if (dto.getId() != null && !dto.getId().isEmpty()) {
            equipo.setIdEquipoString(dto.getId());
        }
        return equipo;
    }

    /**
     * Convierte una entidad {@link Equipo} a un {@link EquipoDTO}.
     * 
     * @param entidad Entidad equipo.
     * @return DTO con datos del equipo.
     */
    public static EquipoDTO toDTO(Equipo entidad) {
        EquipoDTO dto = new EquipoDTO(
            entidad.getNombre(),
            entidad.getMarca(),
            entidad.getModelo(),
            entidad.getNumeroSerie(),
            entidad.getFechaAdquisicion()
        );
        dto.setId(entidad.getIdEquipoString());
        return dto;
    }

    /**
     * Convierte una lista de entidades {@link Equipo} a una lista de {@link EquipoDTO}.
     * 
     * @param listaEntidades Lista de entidades equipo.
     * @return Lista de DTOs de equipo.
     */
    public static List<EquipoDTO> toListDTO(List<Equipo> listaEntidades) {
        List<EquipoDTO> listaDTO = new ArrayList<>();
        for (Equipo equipo : listaEntidades) {
            listaDTO.add(toDTO(equipo));
        }
        return listaDTO;
    }

    /**
     * Convierte una lista de {@link EquipoDTO} a una lista de entidades {@link Equipo}.
     * 
     * @param listaDTO Lista de DTOs de equipo.
     * @return Lista de entidades equipo.
     */
    public static List<Equipo> toListEntity(List<EquipoDTO> listaDTO) {
        List<Equipo> listaEntidades = new ArrayList<>();
        for (EquipoDTO dto : listaDTO) {
            listaEntidades.add(toEntity(dto));
        }
        return listaEntidades;
    }
}
