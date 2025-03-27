/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package presentacion;

import implementaciones.ManejadorComprasMembresias;
import interfaces.IManejadorComprasMembresias;

/**
 *
 * @author 52644
 */

public class SistemaGimnasioPresentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IManejadorComprasMembresias subsistema = new ManejadorComprasMembresias();
        ControlNavegacionCompraMembresia control = new ControlNavegacionCompraMembresia(subsistema);
        control.openFormBuscarCliente();
    }
}
