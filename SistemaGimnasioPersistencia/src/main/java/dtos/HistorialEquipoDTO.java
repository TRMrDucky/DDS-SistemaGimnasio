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
    private String nombreEquipo;
    private String marca;
    private String tipoMantenimiento;
    private Date fechaMantenimiento;
    private float costo;
    private String observaciones;

    public HistorialEquipoDTO(String nombreEquipo, String marca, String tipoMantenimiento, Date fechaMantenimiento, float costo, String observaciones) {
        this.nombreEquipo = nombreEquipo;
        this.marca = marca;
        this.tipoMantenimiento = tipoMantenimiento;
        this.fechaMantenimiento = fechaMantenimiento;
        this.costo = costo;
        this.observaciones = observaciones;
    }
}
