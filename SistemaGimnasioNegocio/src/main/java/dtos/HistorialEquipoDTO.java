/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
/**
 * DTO que representa el historial de mantenimiento de un equipo.
 * Contiene información detallada sobre cada mantenimiento realizado,
 * incluyendo el nombre del mantenimiento, fechas relevantes, costo, observaciones y el nombre del equipo.
 * 
 * @author Cricri
 */
public class HistorialEquipoDTO {
    
    /** Nombre del tipo de mantenimiento realizado */
    private String nombreMantenimiento;
    
    /** Fecha en que se realizó el mantenimiento */
    private Date fechaMantenimiento;
    
    /** Nombre del equipo al que se le hizo el mantenimiento */
    private String nombreEquipo;
    
    /** Costo del mantenimiento */
    private float costo;
    
    /** Observaciones o comentarios adicionales sobre el mantenimiento */
    private String observaciones;
    
    /** Fecha de seguimiento posterior al mantenimiento */
    private Date fechaSeguimiento;

    /**
     * Constructor vacío para crear una instancia vacía de HistorialEquipoDTO.
     */
    public HistorialEquipoDTO() {
    }

    /**
     * Constructor que inicializa todos los campos del DTO.
     * 
     * @param nombreMantenimiento Nombre del mantenimiento realizado.
     * @param fechaMantenimiento Fecha en que se realizó el mantenimiento.
     * @param nombreEquipo Nombre del equipo que recibió el mantenimiento.
     * @param costo Costo del mantenimiento.
     * @param observaciones Observaciones adicionales sobre el mantenimiento.
     * @param fechaSeguimiento Fecha de seguimiento posterior al mantenimiento.
     */
    public HistorialEquipoDTO(String nombreMantenimiento, Date fechaMantenimiento, String nombreEquipo, float costo, String observaciones, Date fechaSeguimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
        this.nombreEquipo = nombreEquipo;
        this.costo = costo;
        this.observaciones = observaciones;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    /** @return Nombre del mantenimiento */
    public String getNombreMantenimiento() {
        return nombreMantenimiento;
    }

    /** @param nombreMantenimiento Nombre del mantenimiento a establecer */
    public void setNombreMantenimiento(String nombreMantenimiento) {
        this.nombreMantenimiento = nombreMantenimiento;
    }

    /** @return Fecha del mantenimiento */
    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    /** @param fechaMantenimiento Fecha del mantenimiento a establecer */
    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    /** @return Nombre del equipo */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /** @param nombreEquipo Nombre del equipo a establecer */
    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    /** @return Costo del mantenimiento */
    public float getCosto() {
        return costo;
    }

    /** @param costo Costo del mantenimiento a establecer */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /** @return Observaciones sobre el mantenimiento */
    public String getObservaciones() {
        return observaciones;
    }

    /** @param observaciones Observaciones a establecer */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /** @return Fecha de seguimiento posterior al mantenimiento */
    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    /** @param fechaSeguimiento Fecha de seguimiento a establecer */
    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    /**
     * Devuelve una representación en texto del objeto HistorialEquipoDTO.
     * 
     * @return String con los valores de todos los atributos.
     */
    @Override
    public String toString() {
        return "HistorialEquipoDTO{" + 
            "nombreMantenimiento=" + nombreMantenimiento + 
            ", fechaMantenimiento=" + fechaMantenimiento + 
            ", nombreEquipo=" + nombreEquipo + 
            ", costo=" + costo + 
            ", observaciones=" + observaciones + 
            ", fechaSeguimiento=" + fechaSeguimiento + 
            '}';
    }
}
