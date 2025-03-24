/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sistemagimnasiopresentacion;
import com.subsistemacompramembresia.IManejadorComprasMembresia;
import implementaciones.ManejadorComprasMembresia;

/**
 *
 * @author 52644
 */
public class SistemaGimnasioPresentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
									IManejadorComprasMembresias subsistema = new ControlManejadorComprasMembresia();
        ControlNavegacionCompraMembresia CNCM = new ControlNavegacionCompraMembresia();
        CNCM.openFormBuscarCliente();
    }
}
