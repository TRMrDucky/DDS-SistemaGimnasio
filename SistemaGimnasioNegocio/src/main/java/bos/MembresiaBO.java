/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import dtos.TipoMembresiaDTO;
import interfaces.dao.IMembresiaDAO;
import java.util.List;
import mappers.MembresiaMapper;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaBO {
    
    IMembresiaDAO membresiaDAO;

    public MembresiaBO(IMembresiaDAO membresiaDAO) {
        this.membresiaDAO = membresiaDAO;
    }
    
    public List<TipoMembresiaDTO> obtenerMembresiasDTO(){
        return MembresiaMapper.toListDTO(membresiaDAO.obtenerMembresiasDTO());
    }
}
