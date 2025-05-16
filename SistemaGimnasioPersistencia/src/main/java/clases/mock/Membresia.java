/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.List;
import Enumeradores.EnumEstadoMembresia;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author 52644
 */
public class Membresia {

    private String nombre;
    private ObjectId id;
    private double precio;
    private List<ServicioExtra> serviciosExtra;
    private EnumEstadoMembresia estado;
    private Date inicio;
    private Date fin;
    private Long duracion;
    private final Long DURACION_DIA = 86400000L;

    public Membresia(String nombre, ObjectId id, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Date inicio, Long duracion) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.inicio = new Date();
        this.duracion = duracion;
        this.fin =  new Date(this.inicio.getTime() + (duracion * DURACION_DIA));
    }

    public Membresia(String nombre, double precio, List<ServicioExtra> serviciosExtra, Long duracion) {
       
        this.nombre = nombre;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.duracion = duracion;
    }

    public Membresia(String nombre, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
    }
    
    
    

    public Membresia(String nombre, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Date inicio, Date fin, Long duracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.inicio = inicio;
        this.fin = fin;
        this.duracion = duracion;
    }

    public Membresia(String nombre, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Long duracion) {
        this.nombre = nombre;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.duracion = duracion;
    }
    
    
    

    public Membresia(String nombre, ObjectId id, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
    }

    public Membresia(String nombre, ObjectId id, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Date inicio, Date fin) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.inicio = inicio;
        this.fin = fin;
    }

    public Membresia(String nombre, ObjectId id, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Date inicio, Date fin, Long duracion) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.inicio = inicio;
        this.fin = fin;
        this.duracion = duracion;
    }

    public Membresia(String nombre, ObjectId id, double precio, List<ServicioExtra> serviciosExtra, EnumEstadoMembresia estado, Long duracion) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.serviciosExtra = serviciosExtra;
        this.estado = estado;
        this.duracion = duracion;
    }
    
    
    

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }
    
    public Membresia() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<ServicioExtra> getServiciosExtra() {
        return serviciosExtra;
    }

    public void setServiciosExtra(List<ServicioExtra> serviciosExtra) {
        this.serviciosExtra = serviciosExtra;
    }

    public EnumEstadoMembresia getEstado() {
        return estado;
    }

    public void setEstado(EnumEstadoMembresia estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }
    
    
//
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 17 * hash + this.id;
//        return hash;
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membresia other = (Membresia) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Membresia{" + "nombre=" + nombre + ", id=" + id + ", precio=" + precio + ", serviciosExtra=" + serviciosExtra + ", estado=" + estado + ", inicio=" + inicio + ", fin=" + fin + ", duracion=" + duracion + ", DURACION_DIA=" +  '}';
    }

    
    public String getIdString(){
        return id.toString();
    }
    
    public void setIdString(String id){
        this.id= new ObjectId(id);
    }
    
}
