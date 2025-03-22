/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author 52644
 */
public class ClienteRegistradoDTO {

    String nombre;
    String apellidos;
    String email;
    String numeroTelefono;
    int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ClienteRegistradoDTO(String nombre, String apellidos, String email, String numeroTelefono, int id) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.id = id;
    }
    
    
}
