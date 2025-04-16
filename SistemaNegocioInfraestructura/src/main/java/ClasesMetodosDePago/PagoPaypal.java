/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesMetodosDePago;

import formaspago.Paypal;
import interfaces.infraestructura.IMetodosPago;

/**
 *
 * @author Cricri
 */
public class PagoPaypal implements IMetodosPago {
    
    private Paypal cuenta;

    public PagoPaypal(Paypal cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public boolean pago(int montoPagar) {
        if (cuenta.getSaldo() >= montoPagar) {
            cuenta.descontar(montoPagar);
            System.out.println("Pago con PayPal realizado. Saldo restante: $" + cuenta.getSaldo());
            return true;
        } else {
            System.out.println("Saldo insuficiente en PayPal.");
            return false;
        }
    }
}


