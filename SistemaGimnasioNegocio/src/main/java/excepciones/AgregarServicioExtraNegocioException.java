/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Ramón Zamudio
 */
public class AgregarServicioExtraNegocioException extends Exception{

    public AgregarServicioExtraNegocioException() {
    }

    public AgregarServicioExtraNegocioException(String message) {
        super(message);
    }

    public AgregarServicioExtraNegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
