/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author Ramón Zamudio
 */
public class ConsultarServicioExtraNegocioException extends Exception{

    public ConsultarServicioExtraNegocioException() {
    }

    public ConsultarServicioExtraNegocioException(String message) {
        super(message);
    }

    public ConsultarServicioExtraNegocioException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
