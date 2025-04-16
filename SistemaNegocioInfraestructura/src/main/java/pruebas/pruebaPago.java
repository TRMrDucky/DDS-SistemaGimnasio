/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import ClasesMetodosDePago.PagoPaypal;
import ClasesMetodosDePago.PagoTarjeta;
import formaspago.FormasPago;
import formaspago.Paypal;
import formaspago.Tarjeta;

/**
 *
 * @author Cricri
 */
public class pruebaPago {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //prueba usando formas pago los clientes que estan ahi,sus tarjetas
       // Obtener la instancia única de FormasPago
        FormasPago formasPago = new FormasPago().getFormasPago();

        // Elegimos la primera tarjeta de prueba
        Tarjeta tarjetaSeleccionada = formasPago.obtenerTarjetas().get(0); // José Reynaga

        // Imprimir datos de la tarjeta
        System.out.println("Tarjeta seleccionada de: " + tarjetaSeleccionada.getNombreTitular());

        // Simular pago
        PagoTarjeta pago = new PagoTarjeta(tarjetaSeleccionada);
        boolean resultado = pago.pago(2500); // intenta pagar $2500

        System.out.println("¿El pago fue exitoso? " + resultado);
    }
    }
    

