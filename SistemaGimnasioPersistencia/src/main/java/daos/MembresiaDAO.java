/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import clases.mock.Membresia;
import clases.mock.ServicioExtra;

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

        listaMembresias.add(new Membresia("Day Pass", 15));
        listaMembresias.add(new Membresia("7 dias", 105, obtenerServicio()));
        listaMembresias.add(new Membresia("10 dias", 150, obtenerServicio()));
        listaMembresias.add(new Membresia("15 dias", 225, obtenerServicio()));
        listaMembresias.add(new Membresia("Mensual", 300));
        listaMembresias.add(new Membresia("Por visita", 13));

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
}
