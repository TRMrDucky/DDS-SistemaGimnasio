/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases.mock;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Cricri
 */
public class Equipo {
    
    private ObjectId idEquipo;
    private String nombre;
    private String marca;
    private String modelo;
    private String numeroSerie;
    private Date fechaAdquisicion;
   

  public Equipo() {
    }

    public Equipo(String nombre, String marca, String modelo, String numeroSerie, Date fechaAdquisicion) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.fechaAdquisicion = fechaAdquisicion;
      
    }
  
    public ObjectId getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(ObjectId idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }


    @Override
    public String toString() {
        return "Equipo{" + "idEquipo=" + idEquipo + ", nombre=" + nombre + ", marca=" + marca + ", modelo=" + modelo + ", numeroSerie=" + numeroSerie + ", fechaAdquisicion=" + fechaAdquisicion + '}';
    }
    
    
  
    
    

}
