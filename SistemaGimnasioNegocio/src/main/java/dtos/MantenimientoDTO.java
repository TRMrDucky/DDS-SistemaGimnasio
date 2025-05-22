/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
/**
 * DTO que representa la información de un mantenimiento realizado a un equipo.
 * Contiene datos como el identificador del mantenimiento, el id del equipo al que pertenece,
 * la fecha del mantenimiento, tipo de mantenimiento, costo, observaciones y fecha de seguimiento.
 * 
 * 
 * 
 * @author Cricri
 */
public class MantenimientoDTO {
    
    /** Identificador único del mantenimiento */
    private String id;
    
    /** Identificador del equipo al que se le realizó el mantenimiento */
    private String idEquipo;
    
    /** Fecha en la que se realizó el mantenimiento */
    private Date fechaMantenimiento;
    
    /** Tipo o nombre del mantenimiento realizado */
    private String tipoMantenimiento;
    
    /** Costo del mantenimiento */
    private float costo;
    
    /** Observaciones adicionales sobre el mantenimiento */
    private String observaciones;
    
    /** Fecha para seguimiento o próxima revisión relacionada al mantenimiento */
    private Date fechaSeguimiento;

    /**
     * Constructor vacío para crear una instancia de MantenimientoDTO sin inicializar sus atributos.
     */
    public MantenimientoDTO() {
    }

    /**
     * Constructor que inicializa el DTO con los datos principales del mantenimiento.
     * 
     * @param idEquipo Identificador del equipo.
     * @param fechaMantenimiento Fecha en que se realizó el mantenimiento.
     * @param tipoMantenimiento Tipo o nombre del mantenimiento.
     * @param costo Costo del mantenimiento.
     * @param observaciones Observaciones adicionales sobre el mantenimiento.
     * @param fechaSeguimiento Fecha para seguimiento o próxima revisión.
     */
    public MantenimientoDTO(String idEquipo, Date fechaMantenimiento, String tipoMantenimiento, float costo, String observaciones, Date fechaSeguimiento) {
        this.idEquipo = idEquipo;
        this.fechaMantenimiento = fechaMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
        this.costo = costo;
        this.observaciones = observaciones;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    /** @return el identificador único del mantenimiento */
    public String getId() {
        return id;
    }

    /** @param id establece el identificador único del mantenimiento */
    public void setId(String id) {
        this.id = id;
    }

    /** @return el identificador del equipo */
    public String getIdEquipo() {
        return idEquipo;
    }

    /** @param idEquipo establece el identificador del equipo */
    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    /** @return la fecha en que se realizó el mantenimiento */
    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }

    /** @param fechaMantenimiento establece la fecha del mantenimiento */
    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }

    /** @return el tipo o nombre del mantenimiento */
    public String getTipoMantenimiento() {
        return tipoMantenimiento;
    }

    /** @param tipoMantenimiento establece el tipo o nombre del mantenimiento */
    public void setTipoMantenimiento(String tipoMantenimiento) {
        this.tipoMantenimiento = tipoMantenimiento;
    }

    /** @return el costo del mantenimiento */
    public float getCosto() {
        return costo;
    }

    /** @param costo establece el costo del mantenimiento */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /** @return las observaciones adicionales sobre el mantenimiento */
    public String getObservaciones() {
        return observaciones;
    }

    /** @param observaciones establece las observaciones adicionales */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /** @return la fecha de seguimiento o próxima revisión */
    public Date getFechaSeguimiento() {
        return fechaSeguimiento;
    }

    /** @param fechaSeguimiento establece la fecha de seguimiento o próxima revisión */
    public void setFechaSeguimiento(Date fechaSeguimiento) {
        this.fechaSeguimiento = fechaSeguimiento;
    }

    /**
     * Devuelve una representación en texto del objeto MantenimientoDTO.
     * 
     * @return String con los valores de todos los atributos del mantenimiento.
     */
    @Override
    public String toString() {
        return "MantenimientoDTO{" +
                "id='" + id + '\'' +
                ", idEquipo='" + idEquipo + '\'' +
                ", fechaMantenimiento=" + fechaMantenimiento +
                ", tipoMantenimiento='" + tipoMantenimiento + '\'' +
                ", costo=" + costo +
                ", observaciones='" + observaciones + '\'' +
                ", fechaSeguimiento=" + fechaSeguimiento +
                '}';
    }
}
