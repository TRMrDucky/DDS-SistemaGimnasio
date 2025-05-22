/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import Enumeradores.EnumEstadoMembresia;
import bos.FabricaBOs;
import clases.mock.Membresia;
import dtos.MembresiaDTO;
import excepciones.ActualizarMembresiaException;
import excepciones.DuracionException;
import excepciones.NegocioException;
import excepciones.NombreVacioException;
import excepciones.PrecioVacioException;
import excepciones.SubsistemaMembresiaException;
import interfaces.bo.IMembresiaBO;
import interfaz.IManejadorMembresia;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janethcristinagalvanquinonez
 */
public class ManejadorMembresias implements IManejadorMembresia {

    private IMembresiaBO membresiaBO;

    public ManejadorMembresias() {
        this.membresiaBO = FabricaBOs.getInstanceMembresiaBO();
        System.out.println(membresiaBO);
    }
/**
 * 
 * @param membresia la membresia dto con los datos de la nueva membresia
 * @return la membresia dto ya agregada en la base de datos
 * @throws SubsistemaMembresiaException en caso de ocurrir un error en el subsistema
 * @throws NombreVacioException si su nombre es vacio
 * @throws PrecioVacioException si el precio no es valido
 * @throws DuracionException  si la diracion es menor a 1 dia
 */
    @Override
    public MembresiaDTO agregarMembresia(MembresiaDTO membresia) throws SubsistemaMembresiaException, NombreVacioException, PrecioVacioException, DuracionException {
        if (validarNombreVacio(membresia.getNombre())) {
            throw new NombreVacioException("El nombre de la membresia no puede estar vacio");

        }
        if (!validarPrecio(membresia.getPrecio())) {
            throw new PrecioVacioException("El costo de la membresia no puede estar vacio");
        }
        if (!validarDuracion(membresia.getDuracion())) {
            throw new DuracionException("La duracion de la membresia debe ser minimo de 1 dia");
        }
        try {

            if (membresiaBO == null) {
                throw new SubsistemaMembresiaException("la bo es null en el manejador");
            }

            return membresiaBO.agregarMembresia(membresia);
        } catch (NegocioException ex) {
            throw new SubsistemaMembresiaException("Error al agregar la membresia " + ex.getMessage());
        }

    }
/**
 * 
 * @return consulta todas las membresías disponibles 
 * @throws SubsistemaMembresiaException  si hay un error en la consulta.
 */
    
    public List<MembresiaDTO> consultarMembresias() throws SubsistemaMembresiaException {
        try {
            return membresiaBO.consultarMembresias();
        } catch (NegocioException e) {
            throw new SubsistemaMembresiaException("error al consultar las membresias", e.getCause());
        }
    }
/**
 * consulta membresias con filtro de estado, ya sea activa o inactiva
 * @param estado ele estado por el que las queremos filtrar
 * @return la lista de membresias dto obtenidas de la base con ese filtro
 * @throws SubsistemaMembresiaException si hay un error a consultarlas
 */
    public List<MembresiaDTO> consultarMembresiasPorEstado(EnumEstadoMembresia estado) throws SubsistemaMembresiaException {
        try {
            return membresiaBO.consultarMembresiasPorEstado(estado);
        } catch (NegocioException e) {
            throw new SubsistemaMembresiaException("error al consultar membresias por estado", e.getCause());
        }
    }
/**
 * 
 * @param id el id de la membresia a eliminar
 * @return valor booleano para identificar si se elimino o no
 * @throws SubsistemaMembresiaException si hay un error al eliminarla
 */
    public boolean eliminarMembresia(String id) throws SubsistemaMembresiaException {
        try {
            if (validarIdNulo(id)) {
                throw new NegocioException("error, membresia con ID nulo");
            }
            return membresiaBO.eliminarMembresia(id);
        } catch (NegocioException e) {
            throw new SubsistemaMembresiaException("error al eliminar membresias", e.getCause());
        }

    }
/**
 * 
 * @param membresiaActualizada la membresia dto con los datos a actualizar
 * @return la membresia actualizada dto de la base de datos
 * @throws SubsistemaMembresiaException si hay un error al actualizarla
 * @throws PrecioVacioException si el precio no es valido
 * @throws DuracionException si la duracion es menor a 1 dia
 */
    public MembresiaDTO actualizarMembresia(MembresiaDTO membresiaActualizada) throws SubsistemaMembresiaException, PrecioVacioException, DuracionException {
        if (!validarPrecio(membresiaActualizada.getPrecio())) {
            throw new PrecioVacioException("El costo de la membresia no puede estar vacio");
        }
        if (!validarDuracion(membresiaActualizada.getDuracion())) {
            throw new DuracionException("La duracion de la membresia debe ser minimo de 1 dia");
        }

        try {
            return membresiaBO.actualizarMembresia(membresiaActualizada);
        } catch (NegocioException ex) {
            throw new SubsistemaMembresiaException("Error al actualizar la membresia " + ex.getMessage());
        }
    }
/**
 * 
 * @param id el id de la membresia
 * @return valor booleano dependiendo si es null o no
 */
    public boolean validarIdNulo(String id) {
        return id.isEmpty();
    }
/**
 * 
 * @param nombre el nombre que se quiere agregar a la membresia, ya que una excepcion al agregar es que el nombre es obligatorio
 * @return valor booleano dependiendo si es null o no
 */
    public boolean validarNombreVacio(String nombre) {
        return nombre == null && nombre.trim().isEmpty();
    }
/**
 * 
 * @param costo el costo que queremos validar
 * @return  valor booleano dependiendo si es mayor a 0 o no
 */
    public boolean validarPrecio(double costo) {
        return (costo > 0);
    }
/**
 * 
 * @param duracion recibimos la duracion de la membresia en dias
 * @return valor booleano dependiendo si no es vacio o mayor a 0
 */
    public boolean validarDuracion(Long duracion) {
        return (duracion != null && duracion > 0);

    }
/**
 * 
 * @param estado estado de la membresia
 * @return  valor booleanopara ver si pertenece al enum
 */
    public boolean validarEstado(EnumEstadoMembresia estado) {
        return estado != null && Arrays.asList(EnumEstadoMembresia.values()).contains(estado);
    }

}
