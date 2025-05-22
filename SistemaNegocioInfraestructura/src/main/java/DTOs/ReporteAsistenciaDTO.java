/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 52644
 */
public class ReporteAsistenciaDTO {
    public String nombre;
    public String apellido;
    public List<Date> asistencia;

    public ReporteAsistenciaDTO(String nombre, String apellidos, List<Date> asistencia) {
        this.nombre = nombre;
        this.apellido = apellidos;
        this.asistencia = asistencia;
    }

    public ReporteAsistenciaDTO() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellidos) {
        this.apellido = apellidos;
    }

    public List<Date> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Date> asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
