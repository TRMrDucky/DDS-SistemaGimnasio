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
 *
 * @author Cricri
 */
public class EquipoMapper {
    
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

    public static List<EquipoDTO> toListDTO(List<Equipo> listaEntidades) {
        List<EquipoDTO> listaDTO = new ArrayList<>();
        for (Equipo equipo : listaEntidades) {
            listaDTO.add(toDTO(equipo));
        }
        return listaDTO;
    }

    public static List<Equipo> toListEntity(List<EquipoDTO> listaDTO) {
        List<Equipo> listaEntidades = new ArrayList<>();
        for (EquipoDTO dto : listaDTO) {
            listaEntidades.add(toEntity(dto));
        }
        return listaEntidades;
    }
}

