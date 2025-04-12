/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistemagimnasiopersistencia.interfaces.dao;

import dtos.ClienteDTO;
import dtos.ClienteRegistradoDTO;

/**
 *
 * @author 52644
 */
public interface IClientesDAO {
    
    public abstract ClienteRegistradoDTO registrarCliente(ClienteDTO cliente);
    
}
