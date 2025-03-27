/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author 52644
 */
public class ConsultaDatosClienteException extends Exception{
    public ConsultaDatosClienteException() {
    }

    public ConsultaDatosClienteException(String message) {
        super(message);
    }

    public ConsultaDatosClienteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConsultaDatosClienteException(Throwable cause) {
        super(cause);
    }

    public ConsultaDatosClienteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
