/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formaspago;

/**
 *
 * @author 52644
 */
public class Tarjeta {

    String titular;
    String numeroTarjta;
    int ccv;
    int fechaVencimiento;
    double fondos;

    public Tarjeta() {
    }

    public Tarjeta(String titular, String numeroTarjeta, int ccv, int fechaVencimiento, double fondos) {
        this.titular = titular;
        this.numeroTarjta = numeroTarjeta;
        this.ccv = ccv;
        this.fechaVencimiento = fechaVencimiento;
        this.fondos = fondos;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroTarjta() {
        return numeroTarjta;
    }

    public void setNumeroTarjta(String numeroTarjta) {
        this.numeroTarjta = numeroTarjta;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int ccv) {
        this.ccv = ccv;
    }

    public int getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(int fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public double getFondos() {
        return fondos;
    }

    public void setFondos(double fondos) {
        this.fondos = fondos;
    }

}
