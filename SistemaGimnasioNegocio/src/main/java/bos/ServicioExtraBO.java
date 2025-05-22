/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import interfaces.dao.IServicioExtraDAO;
import dtos.ServicioExtraDTO;
import excepciones.AgregarServicioExtraException;
import excepciones.AgregarServicioExtraNegocioException;
import excepciones.ConsultarServicioExtraNegocioException;
import excepciones.ConsultarServiciosExtraException;
import excepciones.EditarServicioEnMembresiaException;
import excepciones.EditarServicioExtraException;
import excepciones.EditarServicioExtraNegocioException;
import excepciones.EliminarServicioDeMembresiasException;
import excepciones.EliminarServicioExtraException;
import interfaces.bo.IServicioExtraBO;
import interfaces.dao.IMembresiaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mappers.ServicioExtraMapper;

/**
 * Clase de lógica de negocio para gestionar los servicios extra.
 * Implementa la interfaz IServicioExtraBO y actúa como intermediario entre
 * la capa de acceso a datos (DAO) y los controladores o servicios de más alto nivel.
 * @author Ramón Zamudio
 */
public class ServicioExtraBO implements IServicioExtraBO{
    private IServicioExtraDAO servicioDAO;
    private IMembresiaDAO membresiaDAO;
    /**
     * Constructor que recibe las dependencias necesarias para operar.
     *
     * @param servicioDAO DAO para manejar operaciones sobre servicios extra
     * @param membresiaDAO DAO para manejar operaciones relacionadas con membresías
     */
    public ServicioExtraBO(IServicioExtraDAO servicioDAO, IMembresiaDAO membresiaDAO)  {
        this.servicioDAO = servicioDAO;
        this.membresiaDAO= membresiaDAO;
    }

    /**
     * Obtiene la lista de servicios extra y los convierte a DTOs.
     *
     * @return lista de objetos ServicioExtraDTO
     * @throws ConsultarServicioExtraNegocioException si ocurre un error al consultar en la capa DAO
     */
    @Override
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() throws ConsultarServicioExtraNegocioException {
        try {
            return ServicioExtraMapper.toListDTO(servicioDAO.obtenerServiciosExtras());
        } catch (ConsultarServiciosExtraException ex) {
            throw new ConsultarServicioExtraNegocioException("Error al consultar los servicios extra", ex.getCause());
        }
    }

    /**
     * Obtiene un servicio extra por su ID y lo convierte a DTO.
     *
     * @param id ID del servicio extra
     * @return objeto ServicioExtraDTO correspondiente al ID
     * @throws ConsultarServicioExtraNegocioException si ocurre un error en la consulta
     */
    @Override
    public ServicioExtraDTO obtenerServicioExtra(String id) throws ConsultarServicioExtraNegocioException {
        try {
            return ServicioExtraMapper.toDTO(servicioDAO.obtenerServicioExtra(id));
        } catch (ConsultarServiciosExtraException ex) {
            throw new ConsultarServicioExtraNegocioException("Error al consultar los servicios extra", ex.getCause());
        }
    }

    /**
     * Agrega un nuevo servicio extra.
     *
     * @param servicio objeto DTO del servicio a agregar
     * @return el objeto ServicioExtraDTO agregado
     * @throws AgregarServicioExtraNegocioException si ocurre un error al agregar en la base de datos
     */
    @Override
    public ServicioExtraDTO agregarServicio(ServicioExtraDTO servicio)throws AgregarServicioExtraNegocioException {
        try {
            return ServicioExtraMapper.toDTO(servicioDAO.agregarServicio(ServicioExtraMapper.toEntity(servicio)));
        } catch (AgregarServicioExtraException ex) {
            throw new AgregarServicioExtraNegocioException("Error al agregar el servicio", ex.getCause());
        }
    }

    /**
     * Edita un servicio extra existente y actualiza las membresías que lo contienen.
     *
     * @param servicio el objeto DTO con los datos actualizados
     * @return el objeto ServicioExtraDTO actualizado, o null si ocurrió un error al actualizar en membresías
     * @throws EditarServicioExtraNegocioException si ocurre un error al editar en la base de datos
     */
    @Override
    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws EditarServicioExtraNegocioException {
        try {
            ServicioExtraDTO servicioEditado= ServicioExtraMapper.toDTO(servicioDAO.editarServicio(ServicioExtraMapper.toEntity(servicio)));
            if(servicioEditado!=null){
                boolean membActualizada= membresiaDAO.editarServicioEnMembresias(servicioEditado.getId(), ServicioExtraMapper.toEntity(servicioEditado));
                
            }
            return servicioEditado;
        } catch (EditarServicioExtraException ex) {
            throw new EditarServicioExtraNegocioException("Error al actualizar el servicio", ex.getCause());
        } catch (EditarServicioEnMembresiaException ex) {
          //  Logger.getLogger(ServicioExtraBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Elimina un servicio extra por su ID y también lo elimina de las membresías donde esté incluido.
     *
     * @param id ID del servicio a eliminar
     * @return true si se eliminó correctamente en ambas capas (servicio y membresías), false en caso contrario
     */
    @Override
    public boolean eliminarServicioExtra(String id) {
        try {
            boolean servicioEliminado= servicioDAO.eliminarServicioExtra(id);
            if(servicioEliminado){
                boolean actualizadoEnMembresias= membresiaDAO.eliminarServicioDeMembresias(id);
                return actualizadoEnMembresias;
            }
            return false;
        } catch (EliminarServicioExtraException ex) {
            return false;
        
    }   catch (EliminarServicioDeMembresiasException ex) {
            //Logger.getLogger(ServicioExtraBO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }


}
}
