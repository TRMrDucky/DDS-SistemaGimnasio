/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.infraestructura;

import DTOs.AsistenciaDTO;
import DTOs.ReporteAsistenciaDTO;

/**
 *
 * @author 52644
 */
public interface IAsistencia {
    public abstract AsistenciaDTO registrarAsistencia(String identificador);
    public abstract ReporteAsistenciaDTO generarReporteAsistencia(String identificador);
}
