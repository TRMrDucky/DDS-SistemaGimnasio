/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import static Enumeradores.EnumEstadoMembresia.ACTIVA;
import clases.mock.Membresia;
import clases.mock.ServicioExtra;
import clases.mock.membresias.DayPass;
import clases.mock.membresias.FifteenDaysPass;
import clases.mock.membresias.MonthlyPass;
import clases.mock.membresias.SevenDaysPass;
import clases.mock.membresias.TenDaysPass;

import interfaces.dao.IMembresiaDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaDAO implements IMembresiaDAO {

    private static final MembresiaDAO instancia = new MembresiaDAO();
    private List<Membresia> listaMembresias;

    private MembresiaDAO() {

        listaMembresias = new LinkedList<>();
        List<ServicioExtra> servicios = new LinkedList<>();

        listaMembresias.add(new DayPass("Day Pass",1,15, new LinkedList<>(), ACTIVA));
        listaMembresias.add(new SevenDaysPass("Seven Days Pass",2, 105, obtenerServicio(), ACTIVA));
        listaMembresias.add(new TenDaysPass("Ten Days Pass",3,150, obtenerServicio(), ACTIVA));
        listaMembresias.add(new FifteenDaysPass("Fiteen Days Pass",4,225, obtenerServicio(), ACTIVA));
        listaMembresias.add(new MonthlyPass("Monthly Pass",5,300, new LinkedList<>(), ACTIVA));
    }

    public List<ServicioExtra> obtenerServicio() {
        List<ServicioExtra> servicios = new LinkedList<>();
        List<ServicioExtra> serviciosDisponibles = ServicioExtraDAO.getInstance().obtenerServiciosExtrasDTO();

        if (!serviciosDisponibles.isEmpty()) {
            servicios.add(serviciosDisponibles.get(0));

        }
        return servicios;
    }
    
    

    public static MembresiaDAO getInstance() {
        return instancia;
    }

    public List<Membresia> obtenerMembresias() {
        return listaMembresias;
    }
    
    @Override
    public Membresia setearFecha(Membresia membresia){
        return membresia;
    }
}
