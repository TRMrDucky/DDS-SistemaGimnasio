/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.dao;

import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import excepciones.ConsultarServiciosExtraException;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public interface IMembresiaDAO {
    
    
    public List<Membresia> obtenerMembresias();
    public List<ServicioExtra> obtenerServicio()throws ConsultarServiciosExtraException;
    public Membresia setearFecha(Membresia membresia);
}
