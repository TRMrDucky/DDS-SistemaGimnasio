/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package daos;

import clases.mock.Equipo;
import excepciones.AgregarEquipoException;
import excepciones.ConsultarEquipoException;
import excepciones.EliminarEquipoException;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class EquipoDAOTest {

    private EquipoDAO equipoDAO;
    private Equipo equipoGuardado;

    @BeforeAll
    public static void setUpClass() {
      
    }

    @AfterAll
    public static void tearDownClass() {
       
    }

    @BeforeEach
    public void setUp() {
        equipoDAO = EquipoDAO.getInstance();
        equipoGuardado = null;
    }

    @AfterEach
    public void tearDown() {
        // Limpiar el equipo guardado después de cada prueba
        if (equipoGuardado != null && equipoGuardado.getIdEquipo() != null) {
            try {
                equipoDAO.eliminarEquipo(equipoGuardado.getIdEquipoString());
            } catch (EliminarEquipoException e) {
                System.err.println("Error al limpiar equipoGuardado: " + e.getMessage());
            }
        }
    }

    // --- Helper Methods ---
    private Equipo crearEquipoTest(String nombre, String marca, String modelo, String numeroSerie) {
        Equipo equipo = new Equipo();
        equipo.setNombre(nombre);
        equipo.setMarca(marca);
        equipo.setModelo(modelo);
        equipo.setNumeroSerie(numeroSerie);
        equipo.setFechaAdquisicion(new Date());
        return equipo;
    }

    // --- Tests ---

    @Test
    public void testAgregarEquipo_Exitoso() throws AgregarEquipoException {
        System.out.println("agregarEquipo_Exitoso");
        
        Equipo equipo = crearEquipoTest("Equipo Test", "Marca Test", "Modelo Test", "SN12345");
        equipoGuardado = equipoDAO.agregarEquipo(equipo);
        
        assertNotNull(equipoGuardado);
        assertNotNull(equipoGuardado.getIdEquipo());
        assertEquals("Equipo Test", equipoGuardado.getNombre());
        assertEquals("Marca Test", equipoGuardado.getMarca());
        assertEquals("Modelo Test", equipoGuardado.getModelo());
        assertEquals("SN12345", equipoGuardado.getNumeroSerie());
        assertNotNull(equipoGuardado.getFechaAdquisicion());
    }

    @Test
    public void testObtenerEquipos_Exitoso() throws ConsultarEquipoException, AgregarEquipoException {
        System.out.println("obtenerEquipos_Exitoso");
        
    
        equipoGuardado = equipoDAO.agregarEquipo(
            crearEquipoTest("Equipo Lista", "Marca Lista", "Modelo Lista", "SN67890"));
        
        List<Equipo> equipos = equipoDAO.obtenerEquipos();
        
        assertNotNull(equipos);
        assertFalse(equipos.isEmpty());
        
   
        boolean encontrado = equipos.stream()
            .anyMatch(e -> e.getIdEquipo().equals(equipoGuardado.getIdEquipo()));
        assertTrue(encontrado);
    }

    
    @Test
    public void testObtenerEquipo_Exitoso() throws ConsultarEquipoException, AgregarEquipoException {
        System.out.println("obtenerEquipo_Exitoso");
        
        equipoGuardado = equipoDAO.agregarEquipo(
            crearEquipoTest("Equipo Individual", "Marca Individual", "Modelo Individual", "SN13579"));
        
        Equipo equipoObtenido = equipoDAO.obtenerEquipo(equipoGuardado.getIdEquipoString());
        
        assertNotNull(equipoObtenido);
        assertEquals(equipoGuardado.getIdEquipo(), equipoObtenido.getIdEquipo());
        assertEquals("Equipo Individual", equipoObtenido.getNombre());
        assertEquals("Marca Individual", equipoObtenido.getMarca());
        assertEquals("Modelo Individual", equipoObtenido.getModelo());
        assertEquals("SN13579", equipoObtenido.getNumeroSerie());
    }



    @Test
    public void testIdEquipoString() throws AgregarEquipoException {
        System.out.println("idEquipoString");
        
        equipoGuardado = equipoDAO.agregarEquipo(
            crearEquipoTest("Equipo ID Test", "Marca ID", "Modelo ID", "SN99999"));
        
        String idString = equipoGuardado.getIdEquipoString();
        assertNotNull(idString);
        assertFalse(idString.isEmpty());
        
       
        ObjectId nuevoId = new ObjectId(idString);
        assertEquals(equipoGuardado.getIdEquipo(), nuevoId);
    }

    @Test
    public void testSetIdEquipoString() {
        System.out.println("setIdEquipoString");
        
        Equipo equipo = new Equipo();
        String testId = "507f1f77bcf86cd799439011";
        equipo.setIdEquipoString(testId);
        
        assertNotNull(equipo.getIdEquipo());
        assertEquals(testId, equipo.getIdEquipoString());
    }

    @Test
    public void testToString() throws AgregarEquipoException {
        System.out.println("toString");
        
        equipoGuardado = equipoDAO.agregarEquipo(
            crearEquipoTest("Equipo ToString", "Marca ToString", "Modelo ToString", "SN11111"));
        
        String str = equipoGuardado.toString();
        assertNotNull(str);
        assertTrue(str.contains("Equipo ToString"));
        assertTrue(str.contains("Marca ToString"));
        assertTrue(str.contains("Modelo ToString"));
        assertTrue(str.contains("SN11111"));
        assertTrue(str.contains(equipoGuardado.getIdEquipo().toString()));
    }
}