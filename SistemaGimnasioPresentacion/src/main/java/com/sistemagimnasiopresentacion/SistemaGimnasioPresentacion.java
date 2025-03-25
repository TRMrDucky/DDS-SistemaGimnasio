/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.sistemagimnasiopresentacion;


import com.subsistemacompramembresia.IManejadorComprasMembresias;
import implementaciones.ManejadorComprasMembresias;

/**
 *
 * @author 52644
 */

public class SistemaGimnasioPresentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IManejadorComprasMembresias subsistema = new ManejadorComprasMembresias();
        ControlNavegacionCompraMembresia CNCM = new ControlNavegacionCompraMembresia();
        CNCM.openFormBuscarCliente(subsistema);
    }
}
