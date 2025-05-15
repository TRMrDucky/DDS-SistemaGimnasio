/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class PrecioVacioException extends Exception {

    public PrecioVacioException() {
    }

    public PrecioVacioException(String message) {
        super(message);
    }

    public PrecioVacioException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
