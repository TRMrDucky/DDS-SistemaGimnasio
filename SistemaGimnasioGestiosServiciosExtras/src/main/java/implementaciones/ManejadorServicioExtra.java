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
import excepciones.NegocioException;
import excepciones.SubsistemaServicioExtraException;
import interfaces.bo.IServicioExtraBO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import interfaz.IManejadorServiciosExtra;

/**
 *
 * @author Ramón Zamudio
 */
public class ManejadorServicioExtra implements IManejadorServiciosExtra{
    private IServicioExtraBO servicioExtraBO;

    public ManejadorServicioExtra() {
        this.servicioExtraBO = FabricaBOs.getInstanceServicioExtraBO();
    }
    
    @Override
    public ServicioExtraDTO obtenerServicioExtra(String id)throws ConsultarServicioExtraSubsistemaException {
        try {
            return servicioExtraBO.obtenerServicioExtra(id);
        } catch (ConsultarServicioExtraNegocioException ex) {
            return null;
        }
    }

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

    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() throws ConsultarServicioExtraSubsistemaException{
        try {
            return servicioExtraBO.obtenerServiciosExtrasDTO();
        } catch (ConsultarServicioExtraNegocioException ex) {
            throw new ConsultarServicioExtraSubsistemaException("", ex);
        }
    }
    
    public boolean validarServicioNulo(ServicioExtraDTO servicio){
        return servicio == null;
    }
    
    public boolean validarNombreVacio(String nombre){
        return nombre.isEmpty();
    }
    
    public boolean validarPrecioNulo(double precio){
        return precio<0;
    }
    
    public boolean validarIdNulo(String id){
        return id.isEmpty();
    }
    
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
