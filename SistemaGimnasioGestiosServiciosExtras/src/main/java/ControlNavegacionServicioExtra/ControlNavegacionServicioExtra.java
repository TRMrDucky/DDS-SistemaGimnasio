/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlNavegacionServicioExtra;

import dtos.ServicioExtraDTO;
import excepciones.NegocioException;
import interfaces.AgregarServicioExtra;
import interfaces.SeleccionOpcionServicioExtra;
import interfaces.SeleccionarServicioExtra;
import interfaz.IManejadorServicioExtra;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public class ControlNavegacionServicioExtra {
    private IManejadorServicioExtra subsistema;

    public ControlNavegacionServicioExtra(IManejadorServicioExtra subsistema) {
        this.subsistema = subsistema;
    }

    public void openFormAgregarServicio(){
        new AgregarServicioExtra(this).setVisible(true);
    }
    public void openFormSeleecionOpcionServicioExtra(){
        new SeleccionOpcionServicioExtra(this).setVisible(true);
    }
    public void openFormSeleccionarServicioExtra(String origen){
        new SeleccionarServicioExtra(this, origen).setVisible(true);
    }
    
    public ServicioExtraDTO obtenerServicioExtra(Long id) {
        return subsistema.obtenerServicioExtra(id);
    }

    public ServicioExtraDTO añadirServicio(ServicioExtraDTO servicio)throws NegocioException {
        return subsistema.agregarServicio(servicio);
    }


    public ServicioExtraDTO editarServicio(ServicioExtraDTO servicio)throws NegocioException {
        return subsistema.editarServicio(servicio);
    }


    public boolean eliminarServicioExtra(Long id) {
        return subsistema.eliminarServicioExtra(id);
    }
    
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO() {
        return subsistema.obtenerServiciosExtrasDTO();
    }
    
}
