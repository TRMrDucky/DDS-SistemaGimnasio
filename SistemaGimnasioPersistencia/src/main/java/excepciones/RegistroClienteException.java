/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author 52644
 */
public class RegistroClienteException extends Exception{

    public RegistroClienteException() {
    }

    public RegistroClienteException(String message) {
        super(message);
    }

    public RegistroClienteException(String message, Throwable cause) {
        super(message, cause);
    }

    public RegistroClienteException(Throwable cause) {
        super(cause);
    }

    public RegistroClienteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
