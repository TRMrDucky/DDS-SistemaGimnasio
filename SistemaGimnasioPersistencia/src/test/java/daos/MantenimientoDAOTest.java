
package daos;

import clases.mock.Mantenimiento;
import dtos.HistorialEquipoDTO;
import excepciones.ConsultarMantenimientoException;
import excepciones.EliminarMantenimientoException;
import excepciones.RegistrarMantenimientoException;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class MantenimientoDAOTest {
    

    private MantenimientoDAO mantenimientoDAO;
    private Mantenimiento mantenimientoGuardado;
    private ObjectId idEquipoTest;

    @BeforeAll
    public static void setUpClass() {
        // Configuración inicial para todas las pruebas
    }

    @AfterAll
    public static void tearDownClass() {
        // Limpieza después de todas las pruebas
    }

    @BeforeEach
    public void setUp() {
        mantenimientoDAO = MantenimientoDAO.getInstance();
        mantenimientoGuardado = null;
        idEquipoTest = new ObjectId(); 
    }

    @AfterEach
    public void tearDown() {
        // Limpiar el mantenimiento guardado después de cada prueba
        if (mantenimientoGuardado != null && mantenimientoGuardado.getIdMantenimiento() != null) {
            try {
                mantenimientoDAO.eliminarMantenimientosPorEquipo(mantenimientoGuardado.getIdEquipoString());
            } catch (EliminarMantenimientoException e) {
                System.err.println("Error al limpiar mantenimientoGuardado: " + e.getMessage());
            }
        }
    }

    // --- Helper Methods ---
    private Mantenimiento crearMantenimientoTest(ObjectId idEquipo, String nombre, float costo) {
        Mantenimiento mantenimiento = new Mantenimiento();
        mantenimiento.setIdEquipo(idEquipo);
        mantenimiento.setNombreMantenimiento(nombre);
        mantenimiento.setCosto(costo);
        mantenimiento.setFechaMantenimiento(new Date());
        mantenimiento.setObservaciones("Observaciones de prueba");
        mantenimiento.setFechaSeguimiento(new Date(System.currentTimeMillis() + 86400000)); 
        return mantenimiento;
    }

    // --- Tests ---

    
    @Test
    public void testRegistrarMantenimiento_Nulo() {
        System.out.println("registrarMantenimiento_Nulo");
        
        assertThrows(RegistrarMantenimientoException.class, () -> {
            mantenimientoDAO.registrarMantenimiento(null);
        });
    }

    

    @Test
    public void testObtenerHistorialPorEquipo_SinResultados() throws ConsultarMantenimientoException {
        System.out.println("obtenerHistorialPorEquipo_SinResultados");
        
        ObjectId idEquipoInexistente = new ObjectId();
        List<HistorialEquipoDTO> historial = mantenimientoDAO.obtenerHistorialPorEquipo(idEquipoInexistente.toString());
        
        assertNotNull(historial);
        assertTrue(historial.isEmpty());
    }

    @Test
    public void testEliminarMantenimientosPorEquipo_Exitoso() throws RegistrarMantenimientoException, EliminarMantenimientoException, ConsultarMantenimientoException {
        System.out.println("eliminarMantenimientosPorEquipo_Exitoso");
        
        // Registrar varios mantenimientos para el mismo equipo
        mantenimientoGuardado = mantenimientoDAO.registrarMantenimiento(
            crearMantenimientoTest(idEquipoTest, "Mantenimiento a Eliminar", 500f));
        
        // Eliminar todos los mantenimientos del equipo
        boolean resultado = mantenimientoDAO.eliminarMantenimientosPorEquipo(idEquipoTest.toString());
        assertTrue(resultado);
        
        // Verificar que ya no existen
        List<HistorialEquipoDTO> historial = mantenimientoDAO.obtenerHistorialPorEquipo(idEquipoTest.toString());
        assertTrue(historial.isEmpty());
        
        mantenimientoGuardado = null; // Para que el @AfterEach no intente eliminarlo de nuevo
    }

    @Test
    public void testEliminarMantenimientosPorEquipo_SinMantenimientos() throws EliminarMantenimientoException {
        System.out.println("eliminarMantenimientosPorEquipo_SinMantenimientos");
        
        ObjectId idEquipoSinMantenimientos = new ObjectId();
        boolean resultado = mantenimientoDAO.eliminarMantenimientosPorEquipo(idEquipoSinMantenimientos.toString());
        
        assertTrue(resultado);
    }

    @Test
    public void testSingletonInstance() {
        System.out.println("singletonInstance");
        
        MantenimientoDAO instancia1 = MantenimientoDAO.getInstance();
        MantenimientoDAO instancia2 = MantenimientoDAO.getInstance();
        
        assertSame(instancia1, instancia2, "Ambas instancias deberían ser la misma (Singleton)");
    }

  
    @Test
    public void testSetIdMantenimientoString() {
        System.out.println("setIdMantenimientoString");
        
        Mantenimiento mantenimiento = new Mantenimiento();
        String testId = "507f1f77bcf86cd799439011";
        mantenimiento.setIdMantenimientoString(testId);
        
        assertNotNull(mantenimiento.getIdMantenimiento());
        assertEquals(testId, mantenimiento.getIdMantenimientoString());
    }

    @Test
    public void testIdEquipoString() {
        System.out.println("idEquipoString");
        
        Mantenimiento mantenimiento = new Mantenimiento();
        String testId = "507f1f77bcf86cd799439012";
        mantenimiento.setIdEquipoString(testId);
        
        assertNotNull(mantenimiento.getIdEquipo());
        assertEquals(testId, mantenimiento.getIdEquipoString());
    }
}
