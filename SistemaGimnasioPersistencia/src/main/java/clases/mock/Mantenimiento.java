/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Cricri
 */
public class Mantenimiento {
   
    private ObjectId idMantenimiento;
    private Equipo idEquipo;
    private Date fechaMantenimiento;
    private String tipoMantenimiento;
    private float costo;
    private String observaciones;
    private Date fechaSeguimiento;
    
    public Mantenimiento() {
    }
   
    
    public ObjectId getIdMantenimiento() {
        return idMantenimiento;
    }

    public void setIdMantenimiento(ObjectId idMantenimiento) {
        this.idMantenimiento = idMantenimiento;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }
    
    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
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

    @Override
    public String toString() {
        return "Mantenimiento{" + "idMantenimiento=" + idMantenimiento + ", idEquipo=" + idEquipo + ", fechaMantenimiento=" + fechaMantenimiento + ", tipoMantenimiento=" + tipoMantenimiento + ", costo=" + costo + ", observaciones=" + observaciones + ", fechaSeguimiento=" + fechaSeguimiento + '}';
    }
    
    

    
}

