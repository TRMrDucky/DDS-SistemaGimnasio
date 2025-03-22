/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;

/**
 *
 * @author Ramón Zamudio
 */
public class PagoProcesadoDTO {
    private long idTransaccion;
    private String estado;
    private LocalDate fechaHora;

    public PagoProcesadoDTO() {
    }

    public PagoProcesadoDTO(long idTransaccion, String estado, LocalDate fechaHora) {
        this.idTransaccion = idTransaccion;
        this.estado = estado;
        this.fechaHora = fechaHora;
    }

    public long getIdTransaccion() {
        return idTransaccion;
    }

    public String getEstado() {
        return estado;
    }

    public LocalDate getFechaHora() {
        return fechaHora;
    }

    public void setIdTransaccion(long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setFechaHora(LocalDate fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return "PagoProcesadoDTO{" + "idTransaccion=" + idTransaccion + ", estado=" + estado + ", fechaHora=" + fechaHora + '}';
    }
    
    
}
