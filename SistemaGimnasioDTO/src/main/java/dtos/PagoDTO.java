/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;

/**
 *
 * @author Jose
 */
public class PagoDTO {
     private int idCliente;
    private double monto;
    private boolean aprobado;
    
    public PagoDTO(int idCliente, double monto, boolean aprobado) {
        this.idCliente = idCliente;
        this.monto = monto;
        this.aprobado = aprobado;
    }

    public int getIdCliente() { 
        return idCliente; 
    }
   
    public double getMonto() { 
        return monto; 
    }
    
    public boolean isAprobado() { 
        return aprobado; 
    }

    public void setAprobado(boolean aprobado) { 
        this.aprobado = aprobado; 
    }

    @Override
    public String toString() {
        return "PagoDTO{" + "idCliente=" + idCliente + ", monto=" + monto + ", aprobado=" + aprobado + '}';
    }
}
    
    

