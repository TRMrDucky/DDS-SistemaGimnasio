/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package presentacion;

import implementaciones.ManejadorComprasMembresias;
import implementaciones.ManejadorMantenimientoEquipos;
import implementaciones.ManejadorMembresias;
import implementaciones.ManejadorServicioExtra;
import interfaces.IManejadorComprasMembresias;
import interfaz.IManejadorMantenimientoEquipos;
import interfaz.IManejadorMembresia;
import interfaz.IManejadorServiciosExtra;

/**
 *
 * @author 52644
 */

public class SistemaGimnasioPresentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IManejadorComprasMembresias subsistema = new ManejadorComprasMembresias();
        IManejadorServiciosExtra subsistema2 = new ManejadorServicioExtra();
        IManejadorMembresia subsistemaMembresias= new ManejadorMembresias();
        IManejadorMantenimientoEquipos subsistemaMantenimientoEquipos=new ManejadorMantenimientoEquipos();
        ControlNavegacionCompraMembresia control = new ControlNavegacionCompraMembresia(subsistema,subsistema2, subsistemaMembresias, subsistemaMantenimientoEquipos);
        control.openFormPantallaPrincipal();
    }
}
