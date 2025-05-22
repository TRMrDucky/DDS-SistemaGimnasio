/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import bos.FabricaBOs;
import dtos.ServicioExtraDTO;
import excepciones.AgregarServicioExtraNegocioException;
import excepciones.AgregarServicioExtraSubsistemaException;
import excepciones.ConsultarServicioExtraNegocioException;
import excepciones.ConsultarServicioExtraSubsistemaException;
import excepciones.EditarServicioExtraNegocioException;
import excepciones.EditarServicioExtraSubsitemaException;
import excepciones.SubsistemaServicioExtraException;
import interfaces.bo.IServicioExtraBO;
import java.util.List;
import interfaz.IManejadorServiciosExtra;

/**
 * Clase encargada de manejar las operaciones del subsistema relacionadas con los servicios extra.
 * Implementa la interfaz IManejadorServiciosExtra y realiza validaciones antes de delegar a la capa de negocio.
 * @author Ramón Zamudio
 */
public class ManejadorServicioExtra implements IManejadorServiciosExtra{
    private IServicioExtraBO servicioExtraBO;
    /**
     * Constructor por defecto. Obtiene la instancia del BO de servicios extra desde la fábrica.
     */
    public ManejadorServicioExtra() {
        this.servicioExtraBO = FabricaBOs.getInstanceServicioExtraBO();
    }
    
    /**
     * Obtiene un servicio extra por su ID.
     *
     * @param id ID del servicio
     * @return ServicioExtraDTO correspondiente
     * @throws ConsultarServicioExtraSubsistemaException si ocurre un error al consultar
     */
    @Override
    public ServicioExtraDTO obtenerServicioExtra(String id)throws ConsultarServicioExtraSubsistemaException {
        try {
            return servicioExtraBO.obtenerServicioExtra(id);
        } catch (ConsultarServicioExtraNegocioException ex) {
            return null;
        }
    }

    /**
     * Agrega un nuevo servicio extra después de validar los datos.
     *
     * @param servicio el objeto a agregar
     * @return ServicioExtraDTO agregado
     * @throws AgregarServicioExtraSubsistemaException si hay errores en validación o en la lógica de negocio
     */
    @Override
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws AgregarServicioExtraSubsistemaException{
        try {
            if(validarServicioNulo(servicio)){
                throw new NullPointerException("El servicio no puede ser nulo");
            }
            if(validarNombreVacio(servicio.getNombreServicio())){
                throw new NullPointerException("El nombre del servicio no puede ser nulo");
            }
            if(validarPrecioNulo(servicio.getPrecio())){
                throw new AgregarServicioExtraSubsistemaException("El precio no puede ser negativo");
            }
            if(validarNombreServicioRepetido(servicio.getNombreServicio())){
                throw new AgregarServicioExtraSubsistemaException("El nombre de un servicio no se puede repetir");
            }
            return servicioExtraBO.agregarServicio(servicio);
        } catch (AgregarServicioExtraNegocioException | ConsultarServicioExtraSubsistemaException ex) {
            throw new AgregarServicioExtraSubsistemaException("Error al agregar el servicio",ex.getCause());
        }
    }

    /**
     * Edita un servicio extra existente tras realizar validaciones.
     *
     * @param servicio el servicio actualizado
     * @return ServicioExtraDTO editado
     * @throws EditarServicioExtraSubsitemaException si ocurre un error en validaciones o negocio
     */
    @Override
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio) throws EditarServicioExtraSubsitemaException{
        if(validarServicioNulo(servicio)){
            throw new NullPointerException("El servicio no puede ser nulo");
        }
        if(validarNombreVacio(servicio.getNombreServicio())){
            throw new NullPointerException("El nombre del servicio no puede ser nulo");
        }
        if(validarPrecioNulo(servicio.getPrecio())){
            throw new EditarServicioExtraSubsitemaException("El precio no puede ser negativo");
        }
        if(validarIdNulo(servicio.getId())){
            throw new EditarServicioExtraSubsitemaException("El id no puede ser nulo");
        }
        try {
            return servicioExtraBO.editarServicio(servicio);
        } catch (EditarServicioExtraNegocioException ex) {
            throw new EditarServicioExtraSubsitemaException("Error al editar el servicio",ex.getCause());
        }
    }

    /**
     * Elimina un servicio extra por su ID tras validarlo.
     *
     * @param id ID del servicio a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws SubsistemaServicioExtraException si el ID es inválido
     */
    @Override
    public boolean eliminarServicioExtra(String id)throws SubsistemaServicioExtraException {
        try {
            if(validarIdNulo(id)){
                throw new SubsistemaServicioExtraException("El id no puede ser nulo");
            }      
            return servicioExtraBO.eliminarServicioExtra(id);
        } catch (SubsistemaServicioExtraException ex) {
            return false;
        }
    }

    /**
     * Obtiene una lista de todos los servicios extra.
     *
     * @return lista de objetos ServicioExtraDTO
     * @throws ConsultarServicioExtraSubsistemaException si ocurre un error al consultar
     */
    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() throws ConsultarServicioExtraSubsistemaException{
        try {
            return servicioExtraBO.obtenerServiciosExtrasDTO();
        } catch (ConsultarServicioExtraNegocioException ex) {
            throw new ConsultarServicioExtraSubsistemaException("", ex);
        }
    }
    /**
     * Valida si el servicio recibido es nulo.
     */
    public boolean validarServicioNulo(ServicioExtraDTO servicio){
        return servicio == null;
    }
    /**
     * Valida si el nombre del servicio es vacío.
     */
    public boolean validarNombreVacio(String nombre){
        return nombre.isEmpty();
    }
    /**
     * Valida si el precio del servicio es negativo.
     */
    public boolean validarPrecioNulo(double precio){
        return precio<0;
    }
    /**
     * Valida si el ID del servicio es vacío.
     */
    public boolean validarIdNulo(String id){
        return id.isEmpty();
    }
    /**
     * Verifica si el nombre de un servicio ya está en uso.
     *
     * @param nombre nombre del servicio a verificar
     * @return true si el nombre ya existe, false en caso contrario
     * @throws ConsultarServicioExtraSubsistemaException si ocurre un error en la obtención de datos
     */
    public boolean validarNombreServicioRepetido(String nombre)throws ConsultarServicioExtraSubsistemaException{
        List<ServicioExtraDTO> servicios;
        try {
            servicios = servicioExtraBO.obtenerServiciosExtrasDTO();
        } catch (ConsultarServicioExtraNegocioException ex) {
            throw new ConsultarServicioExtraSubsistemaException("Error al obtener los servicios",ex.getCause());
        }
        for(ServicioExtraDTO se : servicios){
            if(se.getNombreServicio().equals(nombre)){
                return true;
            }
        }
        return false;
    }
}
