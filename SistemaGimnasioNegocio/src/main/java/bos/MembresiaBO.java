/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Membresia;
import dtos.MembresiaDTO;
import dtos.ServicioExtraDTO;
import excepciones.ActualizarMembresiaException;
import excepciones.AgregarMembresiaException;
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

    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws NegocioException {
        try {
            System.out.println("lllegbo");
            System.out.println(membresia);
            return MembresiaMapper.toDTO(membresiaDAO.agregarMembresia(MembresiaMapper.toEntity(membresia)));
        } catch (AgregarMembresiaException e) {
            throw new NegocioException("Error al agregar membresia " + e);
        }

    }

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

    @Override
    public List<MembresiaDTO> consultarMembresias() {
        return membresiaDAO.consultarMembresias()
                .stream()
                .map(MembresiaMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public boolean eliminarMembresia(String id) throws NegocioException{
        try {
            return membresiaDAO.eliminarMembresia(id);
        } catch (EliminarMembresiaException ex) {
            return false;
        }
        
    }
    
    public MembresiaDTO actualizarMembresia(String idMembresia, Map<String, Object> cambios) throws NegocioException{
        try{
            return MembresiaMapper.toDTO(membresiaDAO.actualizarMembresia(idMembresia, cambios));
        } catch(ActualizarMembresiaException e){
            throw new NegocioException("Error al actualizar membresia");
        }
    }
    
    public boolean eliminarServicioDeMembresias(String idServicio)throws  EliminarServicioDeMembresiasException{
        try{
            return membresiaDAO.eliminarServicioDeMembresias(idServicio);
        } catch(EliminarServicioDeMembresiasException e){
            throw new EliminarServicioDeMembresiasException("Error al eliminar servicio de membresia");
        }
    }
    
    public boolean editarServicioDeMembresias(String idServicio, ServicioExtraDTO servicioActualizado) throws EditarServicioEnMembresiaException{
        try{
            return membresiaDAO.editarServicioEnMembresias(idServicio, ServicioExtraMapper.toEntity(servicioActualizado));
            
        } catch(EditarServicioEnMembresiaException e){
            throw new EditarServicioEnMembresiaException("error al editar servicio en membresia");
        }
    }

    @Override
    public MembresiaDTO setearFecha(MembresiaDTO membresia) {
        Membresia membresiaActu = MembresiaMapper.toEntity(membresia);
        return MembresiaMapper.toDTO(membresiaDAO.setearFecha(membresiaActu));
    }
    
    

}
