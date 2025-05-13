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
import clases.mock.membresias.DayPass;
import clases.mock.membresias.FifteenDaysPass;
import clases.mock.membresias.MonthlyPass;
import clases.mock.membresias.SevenDaysPass;
import clases.mock.membresias.TenDaysPass;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
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
    private final MongoCollection<Membresia> coleccion;
    private List<Membresia> listaMembresias;
    Long DURACION_DIA = 86400000L;
        

    private MembresiaDAO(){
        this.coleccion = ConexionBD.getInstance().getCollection("membresias",Membresia.class);
        
        listaMembresias = new LinkedList<>();
        List<ServicioExtra> servicios = new LinkedList<>();
        
        servicios.add(new ServicioExtra(new ObjectId(), "Entrenador", 150));
        
        
        
       //1 dia
       Date inicioDayPass = new Date();
       Long duracionDayPass = 1L;
       Date finDayPass = new Date(inicioDayPass.getTime() + (duracionDayPass * DURACION_DIA));
       listaMembresias.add(new Membresia("Day Pass", 1, 15, servicios, EnumEstadoMembresia.ACTIVA, inicioDayPass, finDayPass));
       
       
       //7 dias
       Date inicio7Dias = new Date();
       Long duracion7Dias = 7L;
       Date fin7Dias = new Date(inicio7Dias.getTime() + (duracion7Dias * DURACION_DIA));
       listaMembresias.add(new Membresia("7 dias", 2, 105, servicios, EnumEstadoMembresia.ACTIVA, inicio7Dias, fin7Dias));
       
       //10 dias
       Date inicio10Dias = new Date();
       Long duracion10Dias = 10L;
       Date fin10Dias = new Date(inicio10Dias.getTime() + (duracion10Dias * DURACION_DIA));
       listaMembresias.add(new Membresia("10 dias", 3, 150, servicios, EnumEstadoMembresia.ACTIVA, inicio10Dias, fin10Dias));
       
       
       
       //15 dias
        Date inicio15Dias = new Date();
        Long duracion15Dias = 15L;
        Date fin15Dias = new Date(inicio15Dias.getTime() + (duracion15Dias * DURACION_DIA));
        listaMembresias.add(new Membresia("15 dias", 3, 150, servicios, EnumEstadoMembresia.ACTIVA, inicio15Dias, fin15Dias));
        
        
        //30 dias
        Date inicioMensual = new Date();
        Long duracionMensual = 30L;
        Date finMensual = new Date(inicioMensual.getTime() + (duracionMensual * DURACION_DIA));
        listaMembresias.add(new Membresia("Mensual", 5, 300, servicios, EnumEstadoMembresia.ACTIVA, inicioMensual, finMensual));
        
        //1 dia
        Date inicioPorVisita = new Date();
        Long duracionVisita = 1L;
        Date finVisita = new Date(inicioPorVisita.getTime() + (duracionVisita * DURACION_DIA));
        listaMembresias.add(new Membresia("Por visita", 6, 13, servicios, EnumEstadoMembresia.ACTIVA, inicioPorVisita, finVisita));
        
        
        
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
    
    
    
    public Membresia agregarMembresia(Membresia membresia) throws AgregarMembresiaException{
            try{
            InsertOneResult insercion= coleccion.insertOne(membresia);
            if(insercion.wasAcknowledged()){
                System.out.println("Insercion exitosa con ID: "+insercion.getInsertedId());
                return membresia;
            }
            else{
                throw new AgregarMembresiaException("Insercion no confirmada");
            }
            } catch(Exception e){
                throw new AgregarMembresiaException("Error al insertar membresia");
            }
      
 
    }

    public List<Membresia> obtenerMembresias() {
        return listaMembresias; 
    }
    
    @Override
    public Membresia setearFecha(Membresia membresia){
        return membresia;
    }
    
    
}
