/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Conexion.ConexionBD;
import Enumeradores.EnumEstadoMembresia;
import static Enumeradores.EnumEstadoMembresia.ACTIVA;
import clases.mock.Membresia;
import clases.mock.ServicioExtra;
//import clases.mock.membresias.DayPass;
//import clases.mock.membresias.FifteenDaysPass;
//import clases.mock.membresias.MonthlyPass;
//import clases.mock.membresias.SevenDaysPass;
//import clases.mock.membresias.TenDaysPass;
import com.mongodb.client.MongoCollection;

import excepciones.ConsultarServiciosExtraException;
import excepciones.AgregarMembresiaException;

import interfaces.dao.IMembresiaDAO;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaDAO implements IMembresiaDAO {

    private static MembresiaDAO instancia = new MembresiaDAO();
   // private final MongoCollection<Membresia> coleccion;
  //  private List<Membresia> listaMembresias;
    Long DURACION_DIA = 86400000L;
        

    private MembresiaDAO(){
     //   this.coleccion = ConexionBD.getInstance().getCollection("membresias",Membresia.class);
        
     
        
    }

    @Override
    public List<ServicioExtra> obtenerServicio() throws ConsultarServiciosExtraException{
        List<ServicioExtra> servicios = new LinkedList<>();
        List<ServicioExtra> serviciosDisponibles = ServicioExtraDAO.getInstance().obtenerServiciosExtras();

        if (!serviciosDisponibles.isEmpty()) {
            servicios.add(serviciosDisponibles.get(0));

        }
        return servicios;
    }
    
    

    public static MembresiaDAO getInstance() {
        if(instancia==null){
            instancia= new MembresiaDAO();
        }
        return instancia;
    }
    
    
    
    @Override
    public Membresia agregarMembresia(Membresia membresia) throws AgregarMembresiaException{
            try{
                System.out.println("llegaper");
            MongoCollection<Membresia> coleccion= ConexionBD.getInstance().getCollection("Membresias", Membresia.class);
                System.out.println("a pers llega como "+membresia);
            coleccion.insertOne(membresia);
            
         
                return membresia;
           
            } catch(Exception e){
                throw new AgregarMembresiaException("Error al insertar membresia");
            } 
 
    }

//    public List<Membresia> obtenerMembresias() {
//        return listaMembresias; 
//    }
    
    @Override
    public Membresia setearFecha(Membresia membresia){
        return membresia;
    }

    @Override
    public List<Membresia> obtenerMembresias() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
