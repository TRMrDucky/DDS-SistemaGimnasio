/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fabricasBOs;

import bos.RegistrarClienteBO;
import bos.ServicioExtraBO;
import daos.ClienteDAO;
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
    
}
