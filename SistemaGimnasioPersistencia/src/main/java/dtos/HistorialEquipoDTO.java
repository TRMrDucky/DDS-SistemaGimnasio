/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
/**
 * Clase DTO (Data Transfer Object) que representa el historial de mantenimiento de un equipo.
 * Contiene información detallada sobre cada mantenimiento realizado, incluyendo el nombre del mantenimiento,
 * fechas relevantes, costo, observaciones y el nombre del equipo asociado.
 * 
 * Esta clase se utiliza para transferir datos entre las capas de la aplicación, especialmente para mostrar
 * el historial de mantenimiento en vistas o reportes.
 * 
 * @author Cricri
 */
public class HistorialEquipoDTO {
    
    /** Nombre del mantenimiento realizado. */
    private String nombreMantenimiento;
    
    /** Fecha en que se realizó el mantenimiento. */
    private Date fechaMantenimiento;
    
    /** Nombre del equipo al que se le realizó el mantenimiento. */
    private String nombreEquipo;
    
    /** Costo del mantenimiento. */
    private float costo;
    
    /** Observaciones adicionales sobre el mantenimiento. */
    private String observaciones;
    
    /** Fecha de seguimiento para el mantenimiento, si aplica. */
    private Date fechaSeguimiento;

    /**
     * Constructor vacío por defecto.
     */
    public HistorialEquipoDTO() {
    }

    /**
     * Constructor con todos los campos para inicializar el objeto.
     * 
     * @param nombreMantenimiento Nombre del mantenimiento realizado.
     * @param fechaMantenimiento Fecha en que se realizó el mantenimiento.
     * @param nombreEquipo Nombre del equipo asociado al mantenimiento.
     * @param costo Costo del mantenimiento.
     * @param observaciones Observaciones adicionales del mantenimiento.
     * @param fechaSeguimiento Fecha para seguimiento posterior del mantenimiento.
     */
    public HistorialEquipoDTO(String nombreMantenimiento, Date fechaMantenimiento, String nombreEquipo, float costo, String observaciones, Date fechaSeguimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
        this.nombreEquipo = nombreEquipo;
        this.costo = costo;
        this.observaciones = observaciones;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    // Getters y setters

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

    /**
     * Representación en cadena del objeto {@code HistorialEquipoDTO}, mostrando todos sus atributos.
     * 
     * @return Cadena con la información del historial de mantenimiento.
     */
    @Override
    public String toString() {
        return "HistorialEquipoDTO{" +
                "nombreMantenimiento='" + nombreMantenimiento + '\'' +
                ", fechaMantenimiento=" + fechaMantenimiento +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", costo=" + costo +
                ", observaciones='" + observaciones + '\'' +
                ", fechaSeguimiento=" + fechaSeguimiento +
                '}';
    }
}

