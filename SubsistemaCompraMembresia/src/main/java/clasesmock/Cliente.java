/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesmock;

/**
 *
 * @author 52644
 */
public class Cliente {
    private String nombres;
    private String Apellidos;
    private String email;
    private String numeroTelefono;
    private int id;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
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

    public Cliente(String nombres, String Apellidos, String email, String numeroTelefono, int id) {
        this.nombres = nombres;
        this.Apellidos = Apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.id = id;
    }
    
    
}
