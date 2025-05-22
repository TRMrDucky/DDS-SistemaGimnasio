/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author 52644
 */
public class AsistenciaDTO {

    public String nombres;
    public String apellidos;
    public Date fecha;

    public AsistenciaDTO(String nombres, String apellidos, Date fecha) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha = fecha;
    }

    public AsistenciaDTO(String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public AsistenciaDTO() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Asistencia registrada" + "\nnombres=" + nombres + "\napellidos=" + apellidos + "\nfecha=" + fecha;
    }

}
