/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import bos.FabricaBOs;
import dtos.ServicioExtraDTO;
import excepciones.NegocioException;
import excepciones.SubsistemaServicioExtraException;
import interfaces.bo.IServicioExtraBO;
import java.util.List;
import interfaz.IManejadorServicioExtra;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ramón Zamudio
 */
public class ManejadorServicioExtra implements IManejadorServicioExtra{
    private IServicioExtraBO servicioExtraBO;

    public ManejadorServicioExtra() {
        this.servicioExtraBO = FabricaBOs.getInstanceServicioExtraBO();
    }
    
    @Override
    public ServicioExtraDTO obtenerServicioExtra(String id)throws SubsistemaServicioExtraException {
        try {
            return servicioExtraBO.obtenerServicioExtra(id);
        } catch (NegocioException ex) {
            return null;
        }
    }

    @Override
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws SubsistemaServicioExtraException{
        if(validarServicioNulo(servicio)){
            throw new NullPointerException("El servicio no puede ser nulo");
        }
        if(validarNombreVacio(servicio.getNombreServicio())){
            throw new NullPointerException("El nombre del servicio no puede ser nulo");
        }
        if(validarPrecioNulo(servicio.getPrecio())){
            throw new SubsistemaServicioExtraException("El precio no puede ser negativo");
        }
        if(validarNombreServicioRepetido(servicio.getNombreServicio())){
            throw new SubsistemaServicioExtraException("El nombre de un servicio no se puede repetir");
        }
        try {
            return servicioExtraBO.agregarServicio(servicio);
        } catch (NegocioException ex) {
            throw new SubsistemaServicioExtraException("Error al agregar el servicio",ex.getCause());
        }
    }

    @Override
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio) throws SubsistemaServicioExtraException{
        if(validarServicioNulo(servicio)){
            throw new NullPointerException("El servicio no puede ser nulo");
        }
        if(validarNombreVacio(servicio.getNombreServicio())){
            throw new NullPointerException("El nombre del servicio no puede ser nulo");
        }
        if(validarPrecioNulo(servicio.getPrecio())){
            throw new SubsistemaServicioExtraException("El precio no puede ser negativo");
        }
        if(validarIdNulo(servicio.getId())){
            throw new SubsistemaServicioExtraException("El id no puede ser nulo");
        }
        try {
            return servicioExtraBO.editarServicio(servicio);
        } catch (NegocioException ex) {
            throw new SubsistemaServicioExtraException("Error al editar el servicio",ex.getCause());
        }
    }

    @Override
    public boolean eliminarServicioExtra(String id)throws SubsistemaServicioExtraException {
        try {
            if(validarIdNulo(id)){
                throw new NegocioException("El id no puede ser nulo");
            }      
            return servicioExtraBO.eliminarServicioExtra(id);
        } catch (NegocioException ex) {
            return false;
        }
    }

    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO()throws SubsistemaServicioExtraException {
        try {
            return servicioExtraBO.obtenerServiciosExtrasDTO();
        } catch (NegocioException ex) {
            return null;
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
    
    public boolean validarNombreServicioRepetido(String nombre)throws SubsistemaServicioExtraException{
        List<ServicioExtraDTO> servicios;
        try {
            servicios = servicioExtraBO.obtenerServiciosExtrasDTO();
        } catch (NegocioException ex) {
            throw new SubsistemaServicioExtraException("Error al obtener los servicios",ex.getCause());
        }
        for(ServicioExtraDTO se : servicios){
            if(se.getNombreServicio().equals(nombre)){
                return true;
            }
        }
        return false;
    }
}
