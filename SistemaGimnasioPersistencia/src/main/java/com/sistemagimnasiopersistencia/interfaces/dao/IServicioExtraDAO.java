/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sistemagimnasiopersistencia.interfaces.dao;

import daos.ServicioExtraDAO;
import dtos.ServicioExtraDTO;
import java.util.List;

/**
 *
 * @author Ramón Zamudio
 */
public interface IServicioExtraDAO {
    public List<ServicioExtraDTO> obtenerServiciosExtrasDTO();
}
