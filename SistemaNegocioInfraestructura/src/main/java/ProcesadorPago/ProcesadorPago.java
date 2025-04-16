/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesadorPago;

import ClasesMetodosDePago.PagoEfectivo;
import ClasesMetodosDePago.PagoPaypal;
import ClasesMetodosDePago.PagoTarjeta;
import Enums.MetodosPagoEnum;
import formaspago.Paypal;
import formaspago.Tarjeta;
import interfaces.IMetodosPago;

/**
 *
 * @author Cricri
 */
public class ProcesadorPago {
     public boolean procesarPago(MetodosPagoEnum metodo, int monto, Object datos) {
        IMetodosPago metodoPago;

        switch (metodo) {
            case EFECTIVO:
                metodoPago = new PagoEfectivo();
                break;

            case TARJETA:
                if (datos instanceof Tarjeta) {
                    metodoPago = new PagoTarjeta((Tarjeta) datos);
                } else {
                    System.out.println("Datos inválidos para pago con tarjeta.");
                    return false;
                }
                break;

            case PAYPAL:
                if (datos instanceof Paypal) {
                    metodoPago = new PagoPaypal((Paypal) datos);
                } else {
                    System.out.println("Datos inválidos para pago con PayPal.");
                    return false;
                }
                break;

            default:
                System.out.println("Método de pago no soportado.");
                return false;
        }

        return metodoPago.pago(monto);
    }
}

