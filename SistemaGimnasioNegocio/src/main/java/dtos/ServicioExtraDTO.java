/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *Clase que representa un servicio extra con su ID, nombre y precio.
 * @author Ramón Zamudio
 */
public class ServicioExtraDTO {
    private String id;
    private String nombreServicio;
    private double precio;
    private String descripcion;
    /**
     * Constructor vacío.
     */
    public ServicioExtraDTO() {
    }
    /**
     * Constructor con parámetros.
     * @param id id del servicio
     * @param nombreServicio nombre del servicioExtra
     * @param precio precio del servicio
     */
    public ServicioExtraDTO(String id, String nombreServicio, double precio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
    }

    public ServicioExtraDTO(String nombreServicio, double precio) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
    }
    
    

    public ServicioExtraDTO(String nombreServicio, double precio, String descripcion) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public ServicioExtraDTO(String id, String nombreServicio, double precio, String descripcion) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    public String getId() {
        return id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     *  Método toString para representar el objeto como una cadena de texto.
     * @return regresa el objeto como cadena de texto
     */
    @Override
    public String toString() {
        return "ServicioExtraDTO{" + "id=" + id + ", nombreServicio=" + nombreServicio + ", precio=" + precio + ", descripcion=" + descripcion + '}';
    }
    
    
    
}
