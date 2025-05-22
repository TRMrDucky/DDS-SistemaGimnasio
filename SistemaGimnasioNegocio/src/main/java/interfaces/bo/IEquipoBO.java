/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.bo;

import bos.MantenimientoBO;
import dtos.EquipoDTO;
import excepciones.NegocioException;
import java.util.List;
/**
 * Interfaz que define las operaciones de negocio relacionadas con la gestión de equipos.
 * Incluye métodos para obtener, buscar, agregar y eliminar equipos, así como eliminar un equipo junto con sus datos asociados.
 * 
 * @author Cricri
 */
public interface IEquipoBO {

    /**
     * Obtiene la lista completa de equipos registrados.
     * 
     * @return Lista de objetos {@link EquipoDTO} que representan todos los equipos.
     * @throws NegocioException Si ocurre un error en la operación de negocio.
     */
    public List<EquipoDTO> obtenerTodosEquipos() throws NegocioException;

    /**
     * Busca equipos que coincidan con un filtro dado.
     * 
     * @param filtro Texto para filtrar la búsqueda de equipos.
     * @return Lista de objetos {@link EquipoDTO} que cumplen con el filtro.
     * @throws NegocioException Si ocurre un error en la operación de negocio.
     */
    public List<EquipoDTO> buscarEquiposPorFiltro(String filtro) throws NegocioException;

    /**
     * Obtiene un equipo por su identificador único.
     * 
     * @param id Identificador único del equipo.
     * @return Objeto {@link EquipoDTO} que representa el equipo encontrado.
     * @throws NegocioException Si ocurre un error o el equipo no es encontrado.
     */
    public EquipoDTO obtenerEquipoPorId(String id) throws NegocioException;

    /**
     * Agrega un nuevo equipo a la base de datos.
     * 
     * @param equipoDTO Objeto {@link EquipoDTO} con los datos del equipo a agregar.
     * @return Objeto {@link EquipoDTO} con los datos del equipo agregado, incluyendo su ID generado.
     * @throws NegocioException Si ocurre un error al agregar el equipo.
     */
    public EquipoDTO agregarEquipo(EquipoDTO equipoDTO) throws NegocioException;

    /**
     * Elimina un equipo por su identificador.
     * 
     * @param id Identificador único del equipo a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error al eliminar el equipo.
     */
    public boolean eliminarEquipo(String id) throws NegocioException;

    /**
     * Elimina un equipo junto con sus datos asociados, como mantenimientos.
     * 
     * @param id Identificador único del equipo a eliminar.
     * @return {@code true} si la eliminación fue exitosa, {@code false} en caso contrario.
     * @throws NegocioException Si ocurre un error al eliminar el equipo o sus datos asociados.
     */
    public boolean eliminarEquipoYAsociados(String id) throws NegocioException;
}


