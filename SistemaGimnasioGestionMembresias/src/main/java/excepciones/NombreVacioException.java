/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class NombreVacioException extends Exception {

    public NombreVacioException() {
    }

    public NombreVacioException(String message) {
        super(message);
    }

    public NombreVacioException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
