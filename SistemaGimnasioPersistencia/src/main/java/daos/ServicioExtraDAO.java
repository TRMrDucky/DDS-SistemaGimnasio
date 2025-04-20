/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import clases.mock.ServicioExtra;
import interfaces.dao.IServicioExtraDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraDAO implements IServicioExtraDAO {
    
    private static ServicioExtraDAO instancia;
    private List<ServicioExtra> listaserviciosExtras;
    
    private ServicioExtraDAO() {
        listaserviciosExtras = new LinkedList<>();
        listaserviciosExtras.add(new ServicioExtra(1, "Entrenador", 150,"Entrenador personalizado"));
        listaserviciosExtras.add(new ServicioExtra(2, "Plan Alimenticio", 150,"Plan alimenticio personalizado"));
        listaserviciosExtras.add(new ServicioExtra(3, "Clases de yoga ", 100,"(Lu, Mi, Vi 6-7:30 AM)"));
        listaserviciosExtras.add(new ServicioExtra(4, "Spinning ", 50,"(Ma, Ju 6-7:30 AM)"));
        listaserviciosExtras.add(new ServicioExtra(5, "Masaje relajante", 200,"masaje muy relajante"));
        listaserviciosExtras.add(new ServicioExtra(6, "Asesoría Nutricional", 180,"Asesorias de nutricion"));
    }
    
    public static ServicioExtraDAO getInstance() {
        if (instancia == null) {
            instancia = new ServicioExtraDAO();
        }
        return instancia;
    }
    @Override
    public List<ServicioExtra> obtenerServiciosExtrasDTO() {
        return listaserviciosExtras;
    }
    
    @Override
    public ServicioExtra obtenerServicioExtra(Long id){
        for(ServicioExtra se : listaserviciosExtras){
            if(se.getId()==id){
                return se;
            }
        }
        return null;
    }
    
    @Override
    public ServicioExtra agregarServicio(ServicioExtra servicio){
        listaserviciosExtras.add(servicio);
        return servicio;
    }

    @Override
    public ServicioExtra editarServicio(ServicioExtra servicio) {
       for(ServicioExtra se : listaserviciosExtras){
           if(se.getId() == servicio.getId()){
               se.setPrecio(servicio.getPrecio());
               se.setDescripcion(servicio.getDescripcion());
               return se;
           }
       }
       return null;
    }

    @Override
    public boolean eliinarServicioExtra(Long id) {
        for(ServicioExtra se : listaserviciosExtras){
           if(se.getId() == id){
               listaserviciosExtras.remove(se);
               return true;
           }
       }
       return false;
    }
    
    
    
    
}
