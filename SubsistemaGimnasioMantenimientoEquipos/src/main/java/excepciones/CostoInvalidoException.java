/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Cricri
 */
public class CostoInvalidoException extends Exception {

    public CostoInvalidoException() {
    }

    public CostoInvalidoException(String message) {
        super(message);
    }

    public CostoInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
