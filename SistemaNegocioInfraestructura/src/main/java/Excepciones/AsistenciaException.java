/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excepciones;

/**
 *
 * @author 52644
 */
public class AsistenciaException extends Exception{

    public AsistenciaException() {
    }

    public AsistenciaException(String message) {
        super(message);
    }

    public AsistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    public AsistenciaException(Throwable cause) {
        super(cause);
    }

    public AsistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
