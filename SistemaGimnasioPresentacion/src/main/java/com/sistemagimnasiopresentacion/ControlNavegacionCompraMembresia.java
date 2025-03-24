/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistemagimnasiopresentacion;

import com.subsistemacompramembresia.IManejadorComprasMembresias;

/**
 *
 * @author 52644
 */
public class ControlNavegacionCompraMembresia {
    public void openFormRegistrarCliente(IManejadorComprasMembresias subsistema){
        RegistrarCliente rc = new RegistrarCliente(subsistema);
        rc.setVisible(true);
    }
    
   public void openFormBuscarCliente(){
       BuscarCliente bc = new BuscarCliente();
       bc.setVisible(true);
   }

		public void seleccionarMembresia(IManejadorComprasMembresias subsistema){
			SeleccionarMembresia sm = new SeleccionarMembresia(subsistema);
			sm.setVisible(true);
 }
                
                
   public void openFormSeleccionarMembresia(IManejadorComprasMembresias subsistema){
       SeleccionarMembresia em= new SeleccionarMembresia(subsistema);
       em.setVisible(true);
       
   }
}