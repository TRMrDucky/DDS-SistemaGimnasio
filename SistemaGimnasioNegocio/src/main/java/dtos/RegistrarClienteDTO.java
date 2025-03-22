/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author 52644
 */
public class RegistrarClienteDTO {
    String nombre;
    String apellidos;
    String email;
    String numeroTelefono;

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

    public RegistrarClienteDTO(String nombre, String apellidos, String email, String numeroTelefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
    }
    
    
}
