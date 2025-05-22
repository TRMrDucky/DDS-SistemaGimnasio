/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import Enumeradores.EnumEstadoMembresia;
import clases.mock.Membresia;
import dtos.MembresiaDTO;
import dtos.ServicioExtraDTO;
import excepciones.ActualizarMembresiaException;
import excepciones.AgregarMembresiaException;
import excepciones.ConsultarMembPorEstadoException;
import excepciones.ConsultarMembresiasDesactivadasException;
import excepciones.ConsultarMembresiasException;
import excepciones.EditarServicioEnMembresiaException;
import excepciones.EliminarMembresiaException;
import excepciones.EliminarServicioDeMembresiasException;
import excepciones.NegocioException;
import interfaces.bo.IMembresiaBO;
import interfaces.dao.IMembresiaDAO;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import mappers.MembresiaMapper;
import mappers.ServicioExtraMapper;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaBO implements IMembresiaBO {

    private final IMembresiaDAO membresiaDAO;

    public MembresiaBO(IMembresiaDAO membresiaDAO) {
        this.membresiaDAO = membresiaDAO;
    }
/**
 * 
 * @param membresia los datos de la membresia como DTO para agregarla 
 * @return MembresiaDTO con los datos guardados
 * @throws NegocioException en caso de ocurrir error en negocio al agregarla
 */
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws NegocioException {
        try {
           
            return MembresiaMapper.toDTO(membresiaDAO.agregarMembresia(MembresiaMapper.toEntity(membresia)));
        } catch (AgregarMembresiaException e) {
            throw new NegocioException("Error al agregar membresia " + e);
        }

    }
/**
 * 
 * @return la lista de todas las membresias de la lista mock
 */
    @Override
    public List<MembresiaDTO> obtenerMembresiasDTO() {
        List<Membresia> listaMembresias = membresiaDAO.obtenerMembresias();
        for (Membresia membresia : listaMembresias) {
            System.out.println(membresia);
        }

        return listaMembresias.stream()
                .map(MembresiaMapper::toDTO)
                .collect(Collectors.toList());

    }
/**
 * 
 * @return la lista de membresias dto sin ningun filtro que existen en la base de datos
 * @throws NegocioException en caso de ocurrir error al consultarlas
 */
    @Override
    public List<MembresiaDTO> consultarMembresias() throws NegocioException{
        try{
        return membresiaDAO.consultarMembresias()
                .stream()
                .map(MembresiaMapper::toDTO)
                .collect(Collectors.toList());
    } catch(ConsultarMembresiasException e){
        throw new NegocioException("Error al consultar membresias", e.getCause());
    }
    }
    
    /**
     * 
     * @param estado enum por el que queremos consultar las membresias
     * @return la lista de membresias dto con ese estado
     * @throws NegocioException 
     */
     public List<MembresiaDTO> consultarMembresiasPorEstado(EnumEstadoMembresia estado) throws NegocioException{
         try{
        return membresiaDAO.consultarMembresiasPorEstado(estado)
                .stream()
                .map(MembresiaMapper::toDTO)
                .collect(Collectors.toList());
         } catch(ConsultarMembPorEstadoException e){
             throw new NegocioException("Error al consultar membresias por estados", e.getCause());
         }
    }
    /**
     * 
     * @param id pasamos el id de la membresia que queremos eliminar
     * @return valor booleano para identficar si se elimino o no 
     * @throws NegocioException excepcion en caso de error al eliminarla
     */
    @Override
    public boolean eliminarMembresia(String id) throws NegocioException{
        try {
            return membresiaDAO.eliminarMembresia(id);
        } catch (EliminarMembresiaException e) {
            throw new NegocioException("Error al eliminar membresia", e.getCause());
           
        }
        
    }
    /**
     * 
     * @param membresiaActualizada pasamos la membresia dto con los datos que queremos actualizar
     * @return la membresia dto con los datos ya actualizada en la base de datos
     * @throws NegocioException excepcion en caso de no poder actualizarse
     */
    public MembresiaDTO actualizarMembresia(MembresiaDTO membresiaActualizada) throws NegocioException{
      
        try{
            return MembresiaMapper.toDTO(membresiaDAO.actualizarMembresia(MembresiaMapper.toEntity(membresiaActualizada)));
        } catch(ActualizarMembresiaException e){
            throw new NegocioException("Error al actualizar membresia" +e.getMessage());
        }
    }
    /**
     * 
     * @param idServicio el id del servicio que queremos eliminar
     * @return valor booleano para identificar si se elimino de la membresia en la base de datos
     * @throws NegocioException excepcion en casop de no poder eliminarse
     */
    public boolean eliminarServicioDeMembresias(String idServicio)throws NegocioException{
        try{
            return membresiaDAO.eliminarServicioDeMembresias(idServicio);
        } catch(EliminarServicioDeMembresiasException e){
            throw new NegocioException("Error al eliminar servicio de membresia");
        }
    }
    /**
     * 
     * @param idServicio el id del servicio que queremos editar de la membresia
     * @param servicioActualizado el servicio dto con los datos que queremos actualizar
     * @return valor booleano para identificar si se edito de la membresia en la base de datos
     * @throws NegocioException excepcion en casop de no poder editarse de la membresia
     */
    public boolean editarServicioDeMembresias(String idServicio, ServicioExtraDTO servicioActualizado) throws NegocioException{
        try{
            return membresiaDAO.editarServicioEnMembresias(idServicio, ServicioExtraMapper.toEntity(servicioActualizado));
            
        } catch(EditarServicioEnMembresiaException e){
            throw new NegocioException("error al editar servicio en membresia");
        }
    }
/**
 * 
 * @param membresia la membresia dto de la membresia que queremos cambiarle la fecha
 * @return la membresia dto con la fecha ya modificada
 */
    @Override
    public MembresiaDTO setearFecha(MembresiaDTO membresia) {
        Membresia membresiaActu = MembresiaMapper.toEntity(membresia);
        return MembresiaMapper.toDTO(membresiaDAO.setearFecha(membresiaActu));
    }
    
    

}
