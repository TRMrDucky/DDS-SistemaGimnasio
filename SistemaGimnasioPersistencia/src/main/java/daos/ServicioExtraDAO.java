/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import com.sistemagimnasiopersistencia.interfaces.dao.IServicioExtraDAO;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraDAO implements IServicioExtraDAO {
    
    private static ServicioExtraDAO instancia;
    
    private ServicioExtraDAO() {
    }
    
    public static ServicioExtraDAO getInstance() {
        if (instancia == null) {
            instancia = new ServicioExtraDAO();
        }
        return instancia;
    }
    
    
}
