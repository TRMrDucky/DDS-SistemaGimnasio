/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bos;

import clases.mock.Membresia;
import dtos.MembresiaDTO;
import interfaces.bo.IMembresiaBO;
import interfaces.dao.IMembresiaDAO;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import mappers.MembresiaMapper;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class MembresiaBO implements IMembresiaBO {
    
    private final IMembresiaDAO membresiaDAO;

    public MembresiaBO(IMembresiaDAO membresiaDAO) {
        this.membresiaDAO = membresiaDAO;
    }
    
    @Override
    public List<MembresiaDTO> obtenerMembresiasDTO(){
        List<Membresia> listaMembresias= membresiaDAO.obtenerMembresias();
        
        if(listaMembresias== null || listaMembresias.isEmpty()){
           return Collections.emptyList();
        }
        
        return listaMembresias.stream()
                .map(MembresiaMapper::toDTO)
                .collect(Collectors.toList());
        
        
    }
}
