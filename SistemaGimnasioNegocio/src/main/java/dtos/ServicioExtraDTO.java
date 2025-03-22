/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtraDTO {
    private long id;
    private String nombreServicio;
    private double precio;

    public ServicioExtraDTO() {
    }

    public ServicioExtraDTO(long id, String nombreServicio, double precio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "ServicioExtraDTO{" + "id=" + id + ", nombreServicio=" + nombreServicio + ", precio=" + precio + '}';
    }
    
}
