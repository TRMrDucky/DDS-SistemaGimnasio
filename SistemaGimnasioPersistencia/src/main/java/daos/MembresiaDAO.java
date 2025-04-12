/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import clases.mock.Membresia;
import dtos.ServicioExtraDTO;
import dtos.TipoMembresiaDTO;
import interfaces.dao.IMembresiaDAO;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaDAO implements IMembresiaDAO {
    
    private static MembresiaDAO instancia;
    private List<Membresia> listaMembresias;
    
        private MembresiaDAO(){
          
        listaMembresias = new LinkedList<>();
        List<ServicioExtraDTO> servicios = new LinkedList<>();
        
        servicios.add(new ServicioExtraDTO(1, "Entrenador", 150));

        listaMembresias.add(new Membresia("Day Pass", 15));
        listaMembresias.add(new Membresia("7 dias", 105, servicios));
        listaMembresias.add(new Membresia("10 dias", 150, servicios));
        listaMembresias.add(new Membresia("15 dias", 225, servicios));
        listaMembresias.add(new Membresia("Mensual", 300));
        listaMembresias.add(new Membresia("Por visita", 13));
        
    }
        
        
        public static MembresiaDAO getInstance(){
            if(instancia==null){
                instancia= new MembresiaDAO();
            }
            return instancia;
        }
        
        
        public List<Membresia> obtenerMembresias(){
            return listaMembresias;
        }
}
