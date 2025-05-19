/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import excepciones.ActualizarMembresiaException;
import excepciones.AgregarMembresiaException;
import excepciones.ConsultarServiciosExtraException;
import excepciones.EditarServicioEnMembresiaException;
import excepciones.EliminarMembresiaException;
import excepciones.EliminarServicioDeMembresiasException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IMembresiaDAO {
    
    
    public List<Membresia> obtenerMembresias();
    public List<ServicioExtra> obtenerServicio()throws ConsultarServiciosExtraException;
    public Membresia setearFecha(Membresia membresia);
     public Membresia agregarMembresia(Membresia membresia) throws AgregarMembresiaException;
     public List<Membresia> consultarMembresias();
     public boolean eliminarMembresia(String id) throws EliminarMembresiaException;
     public Membresia actualizarMembresia(Membresia membresia) throws ActualizarMembresiaException;
     public Membresia actualizarMembresia(String idMembresia, Map<String, Object> cambios) throws ActualizarMembresiaException;
     public boolean eliminarServicioDeMembresias(String idServicio) throws EliminarServicioDeMembresiasException;
     public boolean editarServicioEnMembresias(String idServicio, ServicioExtra servicioActualizado) throws EditarServicioEnMembresiaException;
     
}
