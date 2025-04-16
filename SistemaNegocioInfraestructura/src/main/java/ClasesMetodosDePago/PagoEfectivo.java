/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasesMetodosDePago;

import interfaces.IMetodosPago;

/**
 *
 * @author Cricri
 */
public class PagoEfectivo implements IMetodosPago{
     @Override
    public boolean pago(int montoPagar) {
        System.out.println("Pago en efectivo realizado por $" + montoPagar);
        return true;
    }
}
