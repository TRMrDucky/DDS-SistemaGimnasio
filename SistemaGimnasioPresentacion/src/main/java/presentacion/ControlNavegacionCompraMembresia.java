/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;

import interfaces.IManejadorComprasMembresias;

/**
 *
 * @author 52644
 */
public class ControlNavegacionCompraMembresia {

    public static void openFormRegistrarCliente(IManejadorComprasMembresias subsistema) {
        RegistrarCliente rc = new RegistrarCliente(subsistema);
        rc.setVisible(true);
    }

    public static void openFormBuscarCliente(IManejadorComprasMembresias subsistema) {
        BuscarCliente bc = new BuscarCliente(subsistema);
        bc.setVisible(true);
    }

    public static void seleccionarMembresia(IManejadorComprasMembresias subsistema) {
        SeleccionarMembresia sm = new SeleccionarMembresia(subsistema);
        sm.setVisible(true);
    }

    public static void openFormSeleccionarMembresia(IManejadorComprasMembresias subsistema) {
        SeleccionarMembresia em = new SeleccionarMembresia(subsistema);
        em.setVisible(true);

    }
}
