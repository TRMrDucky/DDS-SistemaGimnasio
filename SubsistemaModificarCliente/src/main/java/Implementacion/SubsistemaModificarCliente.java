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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author 52644
 */
public class SubsistemaModificarCliente implements ISubsistemaModificarCliente {

    private IRegistrarClienteBO registrarClienteBO;

    public SubsistemaModificarCliente() {
        this.registrarClienteBO = FabricaBOs.getInstanceRegistrarClienteBO();
    }

    @Override
    public ClienteRegistradoDTO eliminarCliente(ClienteRegistradoDTO cliente) throws ModificarClienteException {
        return this.registrarClienteBO.eliminarCliente(cliente);

    }

    @Override
    public ClienteRegistradoDTO actualizarCliente(ClienteRegistradoDTO cliente) throws ModificarClienteException {
        if (cliente.getNombre().isBlank() || cliente.getApellidos().isBlank()
                || cliente.getEmail().isBlank() || cliente.getNumeroTelefono().isBlank()) {
            throw new ModificarClienteException("Ningun campo puede permanecer vacio");
        }

        if (!validarFormatoCorreo(cliente.getEmail())) {
            throw new ModificarClienteException("Formato Email no valido");
        }

        if (!validarTelefono(cliente.getNumeroTelefono())) {
            throw new ModificarClienteException("Verifica el numero de teléfono");
        }
        return this.registrarClienteBO.actualizarCliente(cliente);
    }

    private boolean validarFormatoCorreo(String email) {
        Pattern patronEmail = Pattern.compile(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
        Matcher matcher = patronEmail.matcher(email);
        return matcher.matches();

    }

    private boolean validarTelefono(String telefono) {
        Pattern patronTelefono = Pattern.compile(
                "^[0-9]{10}$");
        Matcher matcher = patronTelefono.matcher(telefono);
        return matcher.matches();
    }
}
