/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import dtos.ClienteRegistradoDTO;
import excepciones.ModificarClienteException;

/**
 *
 * @author 52644
 */
public interface ISubsistemaModificarCliente {
    public abstract ClienteRegistradoDTO eliminarCliente(ClienteRegistradoDTO cliente) throws ModificarClienteException;
}
