/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author 52644
 */
public class Cliente {
    private String nombres;
    private String apellidos;
    private String email;
    private String numeroTelefono;
    private List<Membresia> membresias;
    private List<Date> asistencia;
    private ObjectId id;

    public Cliente(String nombres, String apellidos, String email, String numeroTelefono, String id) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.id = new ObjectId(id);
        this.membresias = new LinkedList();
        this.asistencia = new LinkedList();
    }

    public Cliente(String nombres, String apellidos, String email, String numeroTelefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.membresias = new LinkedList();
        this.asistencia = new LinkedList();
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

    public ObjectId getId() {
        return id;
    }

    public void setId(String id) {
        this.id = new ObjectId(id);
    }

    public Cliente() {
    }

    public List<Membresia> getMembresias() {
        return membresias;
    }

    public void setMembresias(List<Membresia> membresias) {
        this.membresias = membresias;
    }

    public List<Date> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Date> asistencia) {
        this.asistencia = asistencia;
    }
    
    public Date addAsistencia(Date asistencia){
        this.asistencia.add(asistencia);
        return asistencia;
    }
    
    

}
