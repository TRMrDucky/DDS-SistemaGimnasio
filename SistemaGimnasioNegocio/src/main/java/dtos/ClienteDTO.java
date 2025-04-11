/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Ramón Zamudio
 */
public class ClienteDTO {
    private String nombre;
    private String correo;
    private String direccion;
    private String telefono;
    private String apellidoPaterno;
    private String apellidoMaterno;
    public ClienteDTO() {
    }
    
    public ClienteDTO(String nombre,String apellidoPaterno, String apellidoMaterno, String correo, String direccion, String telefono) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public ClienteDTO(String nombre, String correo, String telefono, String apellidoPaterno, String apellidoMaterno) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "nombre=" + nombre + ", correo=" + correo + ", direccion=" + direccion + ", telefono=" + telefono + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + '}';
    }

    
    
    
    
}
