/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import ClasesMetodosDePago.PagoPaypal;
import formaspago.Paypal;

/**
 *
 * @author Cricri
 */
public class pruebaPago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Paypal cuenta = new Paypal("josee@gmail.com", "12345", 5000);
        PagoPaypal pago = new PagoPaypal(cuenta);
        
        boolean resultado = pago.pago(3000);
        System.out.println("¿Pago exitoso?: " + resultado);
    }
    
}
