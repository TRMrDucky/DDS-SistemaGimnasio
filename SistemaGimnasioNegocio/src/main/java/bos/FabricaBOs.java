/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import daos.ClienteDAO;
import daos.MembresiaMockDAO;
import daos.ServicioExtraDAO;

/**
 *
 * @author 52644
 */
public class FabricaBOs {
    
    public static ServicioExtraBO getInstanceServicioExtraBO(){
        ServicioExtraDAO servicioExtraDAO = ServicioExtraDAO.getInstance();
        ServicioExtraBO servicioExtraBO = new ServicioExtraBO(servicioExtraDAO);
        return servicioExtraBO;
    }
    
    public static RegistrarClienteBO getInstanceRegistrarClienteBO(){
        ClienteDAO clienteDAO = ClienteDAO.getInstance();
        RegistrarClienteBO registrarClienteBO = new RegistrarClienteBO(clienteDAO);
        return registrarClienteBO;
    }
    
    public static MembresiaBO getInstanceMembresiaBO(){
        MembresiaMockDAO membresiaDAO= MembresiaMockDAO.getInstance();
        MembresiaBO membresiaBO= new MembresiaBO(membresiaDAO);
        return membresiaBO;
    }
    
}
