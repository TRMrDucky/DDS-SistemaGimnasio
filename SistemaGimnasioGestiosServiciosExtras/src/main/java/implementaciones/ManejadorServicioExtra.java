/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import bos.FabricaBOs;
import dtos.ServicioExtraDTO;
import excepciones.NegocioException;
import interfaces.bo.IServicioExtraBO;
import java.util.List;
import interfaz.IManejadorServicioExtra;

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
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return servicioExtraBO.obtenerServiciosExtrasDTO();
    }

    @Override
    public ServicioExtraDTO obtenerServicioExtra(Long id) {
        if(id == null || id<0){
            throw new NullPointerException("EL id no puede ser nulo");
        }
        return servicioExtraBO.obtenerServicioExtra(id);
    }

    @Override
    public ServicioExtraDTO añadirServicio(ServicioExtraDTO servicio) throws NegocioException {
        if(servicio == null){
            throw new NullPointerException("El servicio no puede ser nulo");
        }
        if(servicio.getNombreServicio().isEmpty()){
            throw new NullPointerException("El nombre del servicio no puede ser nulo");
        }
        if(servicio.getPrecio()<0){
            throw new NegocioException("El precio no puede ser negativo");
        }
        return servicioExtraBO.añadirServicio(servicio);
    }

    @Override
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio) throws NegocioException {
        if(servicio == null){
            throw new NullPointerException("El servicio no puede ser nulo");
        }
        if(servicio.getNombreServicio().isEmpty()){
            throw new NullPointerException("El nombre del servicio no puede ser nulo");
        }
        if(servicio.getPrecio()<0){
            throw new NegocioException("El precio no puede ser negativo");
        }
        return servicioExtraBO.editarServicio(servicio);
    }

    @Override
    public boolean eliinarServicioExtra(Long id) {
        if(id == null || id<0){
            throw new NullPointerException("EL id no puede ser nulo");
        }
        return servicioExtraBO.eliinarServicioExtra(id);
    }
    
}
