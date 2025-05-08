package clases.mock;

import org.bson.types.ObjectId;

/**
 *
 * @author Ramón Zamudio
 */
public class ServicioExtra {
    private ObjectId id;
    private String nombreServicio;
    private double precio;
    private String descripcion;

    public ServicioExtra() {
    }

    public ServicioExtra(String nombreServicio, double precio,String descripcion) {
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
    public ServicioExtra(ObjectId id, String nombreServicio, double precio) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
    }

    public ServicioExtra(ObjectId id, String nombreServicio, double precio, String descripcion) {
        this.id = id;
        this.nombreServicio = nombreServicio;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public ObjectId getId() {
        return id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(ObjectId id) {
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
