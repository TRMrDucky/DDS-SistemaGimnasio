/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Ramón Zamudio
 */
public class AgregarServicioExtraException extends Exception{

    public AgregarServicioExtraException() {
    }

    public AgregarServicioExtraException(String message) {
        super(message);
    }

    public AgregarServicioExtraException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
