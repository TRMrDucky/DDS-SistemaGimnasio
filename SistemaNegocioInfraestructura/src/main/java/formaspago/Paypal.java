/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formaspago;

import ClasesMetodosDePago.PagoPaypal;

/**
 *
 * @author 52644
 */
public class Paypal {
   private String correo;
    private String contraseña;
    private double saldo;

    public Paypal(String correo, String contraseña, double saldo) {
        this.correo = correo;
        this.contraseña = contraseña;
        this.saldo = saldo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getSaldo() {
        return saldo;
    }

    public void descontar(double monto) {
        this.saldo -= monto;
    }

    @Override
    public String toString() {
        return "Paypal{" + "correo=" + correo + ", contrase\u00f1a=" + contraseña + ", saldo=" + saldo + '}';
    }
    
    
}

