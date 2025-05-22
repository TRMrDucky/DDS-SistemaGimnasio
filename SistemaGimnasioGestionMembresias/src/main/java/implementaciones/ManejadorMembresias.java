/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Enumeradores.EnumEstadoMembresia;
import bos.FabricaBOs;
import clases.mock.Membresia;
import dtos.MembresiaDTO;
import excepciones.ActualizarMembresiaException;
import excepciones.DuracionException;
import excepciones.NegocioException;
import excepciones.NombreVacioException;
import excepciones.PrecioVacioException;
import excepciones.SubsistemaMembresiaException;
import interfaces.bo.IMembresiaBO; 
import interfaz.IManejadorMembresia;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ManejadorMembresias implements IManejadorMembresia{
    private IMembresiaBO membresiaBO;

    public ManejadorMembresias() {
        this.membresiaBO = FabricaBOs.getInstanceMembresiaBO();
        System.out.println(membresiaBO);
    }
    
    @Override
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws SubsistemaMembresiaException, NombreVacioException, PrecioVacioException, DuracionException{
        if(validarNombreVacio(membresia.getNombre())){
            throw new NombreVacioException("El nombre de la membresia no puede estar vacio");
            
        }
        if(!validarPrecio(membresia.getPrecio())){
            throw new PrecioVacioException("El costo de la membresia no puede estar vacio");
        }
        if(!validarDuracion(membresia.getDuracion())){
            throw new DuracionException("La duracion de la membresia debe ser minimo de 1 dia");
        }
        try{
            System.out.println("Membresía recibida en ManejadorMembresias: " + membresia);

//            if (membresia == null) {
//                throw new SubsistemaMembresiaException("Error: La membresía es NULL en ManejadorMembresias.");
//            }
            System.out.println("antes de enviar a bo"+ membresia);
            if (membresiaBO == null) {
                throw new SubsistemaMembresiaException("la bo es null en el manejador");
            }
           // MembresiaDTO resultado = membresiaBO.agregarMembresia(membresia);
            //return resultado;
          //  System.out.println("si se mando a bo"+resultado);
           // return resultado;
           return membresiaBO.agregarMembresia(membresia);
        } catch (NegocioException ex) {
            throw new SubsistemaMembresiaException("Error al agregar la membresia "+ex.getMessage());
        }
        
        
    }
    
    
   
    public List<MembresiaDTO> consultarMembresias() throws SubsistemaMembresiaException{
        try{
        return membresiaBO.consultarMembresias();
        } catch(NegocioException e){
            throw new SubsistemaMembresiaException("error al consultar las membresias", e.getCause());
        }
    }
    
    public List<MembresiaDTO> consultarMembresiasPorEstado(EnumEstadoMembresia estado) throws SubsistemaMembresiaException{
        try{
        return membresiaBO.consultarMembresiasPorEstado(estado);
        } catch (NegocioException e){
            throw new SubsistemaMembresiaException("error al consultar membresias por estado", e.getCause());
        }
    }
    
    
    public boolean eliminarMembresia(String id) throws SubsistemaMembresiaException{
        try{
         if (validarIdNulo(id)){
             throw new NegocioException("error, membresia con ID nulo");
         }
         return membresiaBO.eliminarMembresia(id);
        } catch(NegocioException e){
            throw new SubsistemaMembresiaException("error al eliminar membresias", e.getCause()); 
        }
         
    }
    
    public MembresiaDTO actualizarMembresia(MembresiaDTO membresiaActualizada) throws SubsistemaMembresiaException, PrecioVacioException, DuracionException{
        if(!validarPrecio(membresiaActualizada.getPrecio())){
            throw new PrecioVacioException("El costo de la membresia no puede estar vacio");
        } if(!validarDuracion(membresiaActualizada.getDuracion())){
            throw new DuracionException("La duracion de la membresia debe ser minimo de 1 dia");
        }
        
           
                try {
                   return membresiaBO.actualizarMembresia(membresiaActualizada);
                } catch (NegocioException ex) {
                    throw new SubsistemaMembresiaException("Error al actualizar la membresia "+ex.getMessage());
                }
            }
           
           
      
        
    
    
     public boolean validarIdNulo(String id){
        return id.isEmpty();
    }
    
    
    
    public boolean validarNombreVacio(String nombre){
       return nombre==null && nombre.trim().isEmpty();
        }
    
    public boolean validarPrecio(double costo){
        return (costo>0);
    }
    
    public boolean validarDuracion(Long duracion){
        return (duracion != null && duracion> 0);
            
        }
    
    public boolean validarEstado(EnumEstadoMembresia estado){
        return estado != null && Arrays.asList(EnumEstadoMembresia.values()).contains(estado);
     }
        
    }
    
    

//public boolean validarDiasVacio

