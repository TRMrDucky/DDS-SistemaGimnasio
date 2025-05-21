/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces.infraestructura;

import dtos.ClienteRegistradoDTO;

/**
 *
 * @author 52644
 */
public interface IAsistencia {
    public abstract ClienteRegistradoDTO registrarAsistencia(String identificador);
    public abstract void generarReporteAsistencia(String identificador);
}
