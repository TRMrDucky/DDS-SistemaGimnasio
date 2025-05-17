/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;

/**
 *
 * @author Cricri
 */
public class HistorialEquipoDTO {
    
    private String nombreMantenimiento;
    private Date fechaMantenimiento;
    private String nombreEquipo;
    private float costo;
    private String observaciones;
    private Date fechaSeguimiento;

    public HistorialEquipoDTO() {
    }

    public HistorialEquipoDTO(String nombreMantenimiento, Date fechaMantenimiento, String nombreEquipo, float costo, String observaciones, Date fechaSeguimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
        this.nombreEquipo = nombreEquipo;
        this.costo = costo;
        this.observaciones = observaciones;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getNombreMantenimiento() {
        return nombreMantenimiento;
    }

    public void setNombreMantenimiento(String nombreMantenimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
    }

    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
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
        return "HistorialEquipoDTO{" + "nombreMantenimiento=" + nombreMantenimiento + ", fechaMantenimiento=" + fechaMantenimiento + ", nombreEquipo=" + nombreEquipo + ", costo=" + costo + ", observaciones=" + observaciones + ", fechaSeguimiento=" + fechaSeguimiento + '}';
    }
    
    
    
}
