/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacion;

import Interfaz.ISubsistemaModificarCliente;
import bos.FabricaBOs;
import dtos.ClienteRegistradoDTO;
import excepciones.ModificarClienteException;
import interfaces.bo.IRegistrarClienteBO;

/**
 *
 * @author 52644
 */
public class SubsistemaModificarCliente implements ISubsistemaModificarCliente {
    
    private IRegistrarClienteBO registrarClienteBO;
    
    public SubsistemaModificarCliente(){
        this.registrarClienteBO = FabricaBOs.getInstanceRegistrarClienteBO();
    }
    
    @Override 
    public ClienteRegistradoDTO eliminarCliente(ClienteRegistradoDTO cliente)throws ModificarClienteException{
        return this.registrarClienteBO.eliminarCliente(cliente);
        
    }
        
}
