/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
/**
 * DTO que representa la información de un equipo.
 * Contiene los datos principales para la transferencia de información entre capas,
 * tales como el identificador, nombre, marca, modelo, número de serie y fecha de adquisición.
 * 
 * @author Cricri
 */
public class EquipoDTO {
    
    /** Identificador único del equipo */
    private String id;
    
    /** Nombre del equipo */
    private String nombre;
    
    /** Marca del equipo */
    private String marca;
    
    /** Modelo del equipo */
    private String modelo;
    
    /** Número de serie del equipo */
    private String numeroSerie;
    
    /** Fecha en que se adquirió el equipo */
    private Date fechaAdquisicion;

    /**
     * Constructor vacío para crear una instancia de EquipoDTO sin inicializar sus atributos.
     */
    public EquipoDTO() {
    }

    /**
     * Constructor que inicializa el DTO con los datos principales del equipo.
     * 
     * @param nombre Nombre del equipo.
     * @param marca Marca del equipo.
     * @param modelo Modelo del equipo.
     * @param numeroSerie Número de serie del equipo.
     * @param fechaAdquisicion Fecha de adquisición del equipo.
     */
    public EquipoDTO(String nombre, String marca, String modelo, String numeroSerie, Date fechaAdquisicion) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /** @return el identificador único del equipo */
    public String getId() {
        return id;
    }

    /** @param id establece el identificador único del equipo */
    public void setId(String id) {
        this.id = id;
    }

    /** @return el nombre del equipo */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre establece el nombre del equipo */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return la marca del equipo */
    public String getMarca() {
        return marca;
    }

    /** @param marca establece la marca del equipo */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /** @return el modelo del equipo */
    public String getModelo() {
        return modelo;
    }

    /** @param modelo establece el modelo del equipo */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /** @return el número de serie del equipo */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /** @param numeroSerie establece el número de serie del equipo */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /** @return la fecha de adquisición del equipo */
    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    /** @param fechaAdquisicion establece la fecha de adquisición del equipo */
    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    /**
     * Devuelve una representación en texto del objeto EquipoDTO.
     * 
     * @return String con los valores de todos los atributos del equipo.
     */
    @Override
    public String toString() {
        return "EquipoDTO{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", numeroSerie='" + numeroSerie + '\'' +
                ", fechaAdquisicion=" + fechaAdquisicion +
                '}';
    }
}
