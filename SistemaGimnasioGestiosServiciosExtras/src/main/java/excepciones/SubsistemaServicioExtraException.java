/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Ramón Zamudio
 */
public class SubsistemaServicioExtraException extends Exception{

    public SubsistemaServicioExtraException() {
    }

    public SubsistemaServicioExtraException(String message) {
        super(message);
    }

    public SubsistemaServicioExtraException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
