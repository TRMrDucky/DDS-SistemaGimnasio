/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Ramón Zamudio
 */
public class TipoMembresiaDTO {
    private String tipoMembresia;
    private double precio;

    public TipoMembresiaDTO() {
    }

    public TipoMembresiaDTO(String tipoMembresia, double precio) {
        this.tipoMembresia = tipoMembresia;
        this.precio = precio;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
