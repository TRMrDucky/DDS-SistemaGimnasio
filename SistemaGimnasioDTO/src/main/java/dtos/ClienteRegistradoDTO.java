/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import clases.mock.Membresia;
import java.util.List;

/**
 *
 * @author 52644
 */
public class ClienteRegistradoDTO {

    private String id;
    private String nombre;
    private String apellidos;
    private String email;
    private String numeroTelefono;

    public ClienteRegistradoDTO(String nombre, String apellidos, String email, String numeroTelefono, String id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.id = id;
    }

    public ClienteRegistradoDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nCliente:" + "\nNombre=" + nombre + "\nApellidos=" + apellidos + "\nEmail=" + email
                + "\nNumeroTelefono=" + numeroTelefono + "\nId=" + id;
    }

}
