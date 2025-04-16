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
   private String nombreTitular;
    private String numero;
    private int cvv;
    private int vencimiento;
    private double saldo;

    public Tarjeta(String nombreTitular, String numero, int cvv, int vencimiento, double saldo) {
        this.nombreTitular = nombreTitular;
        this.numero = numero;
        this.cvv = cvv;
        this.vencimiento = vencimiento;
        this.saldo = saldo;
    }

    public Tarjeta() {
    }
     
    
    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public int getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(int vencimiento) {
        this.vencimiento = vencimiento;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
     public void descontar(double monto) {
        this.saldo -= monto;
    }
    
    @Override
    public String toString() {
        return "PagoTarjeta{" + "nombreTitular=" + nombreTitular + ", numero=" + numero + ", cvv=" + cvv + ", vencimiento=" + vencimiento + ", saldo=" + saldo + '}';
    }
    
   
}

   


