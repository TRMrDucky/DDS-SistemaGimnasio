/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import clases.mock.ServicioExtra;
import com.sistemagimnasiopersistencia.interfaces.dao.IServicioExtraDAO;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraDAO implements IServicioExtraDAO {
    
    private static ServicioExtraDAO instancia;
    private List<ServicioExtra> listaserviciosExtras;
    
    private ServicioExtraDAO() {
        listaserviciosExtras = new LinkedList<>();
        listaserviciosExtras.add(new ServicioExtra(1, "Entrenador", 150));
        listaserviciosExtras.add(new ServicioExtra(2, "Plan Alimenticio", 150));
        listaserviciosExtras.add(new ServicioExtra(3, "Clases de yoga (Lu, Mi, Vi 6-7:30 AM)", 100));
        listaserviciosExtras.add(new ServicioExtra(4, "Spinning (Ma, Ju 6-7:30 AM)", 50));
        listaserviciosExtras.add(new ServicioExtra(5, "Masaje relajante", 200));
        listaserviciosExtras.add(new ServicioExtra(6, "Asesoría Nutricional", 180));
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
    
    
    
}
