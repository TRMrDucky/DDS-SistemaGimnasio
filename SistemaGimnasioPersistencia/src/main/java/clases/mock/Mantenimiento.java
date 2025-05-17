/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.Date;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

/**
 *
 * @author Cricri
 */
public class Mantenimiento {
   //considerarar consistencia,consulta
    private ObjectId idMantenimiento;
    private ObjectId idEquipo;
    private Date fechaMantenimiento;
    private String nombreMantenimiento;
    private float costo;
    private String observaciones;
    private Date fechaSeguimiento;

    public Mantenimiento() {
    }

    public Mantenimiento(ObjectId idEquipo, Date fechaMantenimiento, String nombreMantenimiento, float costo, String observaciones, Date fechaSeguimiento) {
        this.idEquipo = idEquipo;
        this.fechaMantenimiento = fechaMantenimiento;
        this.nombreMantenimiento = nombreMantenimiento;
        this.costo = costo;
        this.observaciones = observaciones;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    

    public ObjectId getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(ObjectId idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public ObjectId getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(ObjectId idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getNombreMantenimiento() {
        return nombreMantenimiento;
    }

    public void setNombreMantenimiento(String nombreMantenimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
    }


    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }
    
       @BsonIgnore
      public String getIdMantenimientoString(){
         return (idMantenimiento != null) ? idMantenimiento.toString() : null;
    }
    
    public void setIdMantenimientoString(String id){
        this.idMantenimiento = new ObjectId(id);
    }    
    
    @BsonIgnore
    public String getIdEquipoString() {
        return idEquipo.toString();
}
    
     public void setIdEquipoString(String id){
        this.idEquipo = new ObjectId(id);
    }    
    

    @Override
    public String toString() {
        return "Mantenimiento{" + "idMantenimiento=" + idMantenimiento + ", idEquipo=" + idEquipo + ", fechaMantenimiento=" + fechaMantenimiento + ", nombreMantenimiento=" + nombreMantenimiento + ", costo=" + costo + ", observaciones=" + observaciones + ", fechaSeguimiento=" + fechaSeguimiento + '}';
    }

    
    

    
}

