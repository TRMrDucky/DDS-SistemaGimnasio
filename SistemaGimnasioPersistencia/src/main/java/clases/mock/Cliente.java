/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.Date;
import java.util.List;

/**
 *
 * @author 52644
 */
public class Cliente {
    private String nombres;
    private String apellidos;
    private String email;
    private String numeroTelefono;
    private List<MembresiaReemplazar> membresias;
    private List<Date> asistencia;
    private int id;

    public Cliente(String nombres, String apellidos, String email, String numeroTelefono, int id) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.id = id;
    }

    public Cliente(String nombres, String apellidos, String email, String numeroTelefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente() {
    }
    
    

}
