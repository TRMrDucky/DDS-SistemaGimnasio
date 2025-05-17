/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import excepciones.AgregarMembresiaException;
import excepciones.ConsultarServiciosExtraException;
import excepciones.EliminarMembresiaException;
import java.util.List;

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
}
