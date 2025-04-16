/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesMetodosDePago;

import formaspago.Tarjeta;
import interfaces.IMetodosPago;

/**
 *
 * @author Cricri
 */
public class PagoTarjeta implements IMetodosPago {
     private Tarjeta tarjeta;

    public PagoTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public boolean pago(int montoPagar) {
        if (tarjeta.getSaldo() >= montoPagar) {
            tarjeta.descontar(montoPagar);
            System.out.println("Pago con tarjeta realizado. Saldo restante: $" + tarjeta.getSaldo());
            return true;
        } else {
            System.out.println("Saldo insuficiente en la tarjeta.");
            return false;
        }
    
    
    }
}
