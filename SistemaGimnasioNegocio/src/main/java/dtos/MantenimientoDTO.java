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
public class MantenimientoDTO {
    private String id; 
    private String idEquipo; 
    private Date fechaMantenimiento;
    private String tipoMantenimiento;
    private float costo;
    private String observaciones;
    private Date fechaSeguimiento;

    public MantenimientoDTO() {
    }

    public MantenimientoDTO(String idEquipo, Date fechaMantenimiento, String tipoMantenimiento, float costo, String observaciones, Date fechaSeguimiento) {
        this.idEquipo = idEquipo;
        this.fechaMantenimiento = fechaMantenimiento;
        this.tipoMantenimiento = tipoMantenimiento;
        this.costo = costo;
        this.observaciones = observaciones;
        this.fechaSeguimiento = fechaSeguimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
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

