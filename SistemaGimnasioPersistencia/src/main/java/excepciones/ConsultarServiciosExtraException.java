/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Ramón Zamudio
 */
public class ConsultarServiciosExtraException extends Exception{

    public ConsultarServiciosExtraException() {
    }

    public ConsultarServiciosExtraException(String message) {
        super(message);
    }

    public ConsultarServiciosExtraException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
