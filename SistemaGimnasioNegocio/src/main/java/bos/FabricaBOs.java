/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import daos.ClienteDAO;
import daos.EquipoDAO;
import daos.MantenimientoDAO;
import daos.MembresiaDAO;
import daos.MembresiaMockDAO;
import daos.ServicioExtraDAO;

/**
 *
 * @author 52644
 */
public class FabricaBOs {
    
    public static ServicioExtraBO getInstanceServicioExtraBO(){
        ServicioExtraDAO servicioExtraDAO = ServicioExtraDAO.getInstance();
        MembresiaDAO membresiaDAO= MembresiaDAO.getInstance();
        ServicioExtraBO servicioExtraBO = new ServicioExtraBO(servicioExtraDAO, membresiaDAO);
        return servicioExtraBO;
    }
    
    public static RegistrarClienteBO getInstanceRegistrarClienteBO(){
        ClienteDAO clienteDAO = ClienteDAO.getInstance();
        RegistrarClienteBO registrarClienteBO = new RegistrarClienteBO(clienteDAO);
        return registrarClienteBO;
    }
    
    public static MembresiaBO getInstanceMembresiaBO(){
        MembresiaDAO membresiaDAO= MembresiaDAO.getInstance();
        MembresiaBO membresiaBO= new MembresiaBO(membresiaDAO);
        return membresiaBO;
    }
    
     public static MantenimientoBO getInstanceMantenimientoBO() {
        MantenimientoDAO mantenimientoDAO = MantenimientoDAO.getInstance();
        MantenimientoBO mantenimientoBO = new MantenimientoBO(mantenimientoDAO);
        return mantenimientoBO;
    }

    public static EquipoBO getInstanceEquipoBO() {
        EquipoDAO equipoDAO = EquipoDAO.getInstance();
        MantenimientoBO mantenimientoBO = getInstanceMantenimientoBO();
        EquipoBO equipoBO = new EquipoBO(equipoDAO, mantenimientoBO);
        return equipoBO;
    }
}
    

