/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package implementaciones;

import clasesmock.Cliente;
import dtos.ClienteRegistradoDTO;
import dtos.RegistrarClienteDTO;
import excepciones.RegistroClienteException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author 52644
 */
public class ManejadorComprasMembresiasTest {

    public ManejadorComprasMembresiasTest() {
    }

    /**
     * Test of registrarCliente method, of class ManejadorComprasMembresias.
     */
    @Test
    public void testRegistrarClienteValoresCorrectosOk() throws Exception {
        ManejadorComprasMembresias mcm = new ManejadorComprasMembresias();
        RegistrarClienteDTO rcDTO = new RegistrarClienteDTO("Jose", "Reynaga", "vv65454524@gmail.com", "6541254298");
        mcm.registrarCliente(rcDTO);

        assertEquals(4, mcm.getListaClientes().values().size());

    }

    @Test
    public void testRegistrarClienteDevuelveClienteRegistradoDTOConId() throws Exception {
        ManejadorComprasMembresias mcm = new ManejadorComprasMembresias();
        RegistrarClienteDTO rcDTO = new RegistrarClienteDTO("Jose", "Reynaga", "vv65454524@gmail.com", "6541254298");

        ClienteRegistradoDTO resultado = mcm.registrarCliente(rcDTO);

        assertTrue(resultado instanceof ClienteRegistradoDTO);
        assertNotNull(resultado.getId());
    }

    @Test
    public void testRegistrarCamposVaciosLanzaExcepcion() throws Exception {
        ManejadorComprasMembresias mcm = new ManejadorComprasMembresias();
        RegistrarClienteDTO rcDTO = new RegistrarClienteDTO("Jose", "Reynaga",
                "", "6541254298");

        RegistroClienteException e = assertThrows(RegistroClienteException.class,
                () -> mcm.registrarCliente(rcDTO));

        String mensajeEsperado = "Ningun campo puede permanecer vacio";
        assertEquals(mensajeEsperado, e.getMessage());
    }

    @Test
    public void testRegistrarMismoCorreoGeneraExcepcion() throws Exception {
        ManejadorComprasMembresias mcm = new ManejadorComprasMembresias();
        RegistrarClienteDTO rcDTO = new RegistrarClienteDTO("Jose", "Reynaga",
                "vv22222@gmail.com", "6541254298");
        mcm.registrarCliente(rcDTO);

        RegistroClienteException e = assertThrows(RegistroClienteException.class,
                () -> mcm.registrarCliente(rcDTO));

        String mensajeEsperado = "Correo ya registrado";
        assertEquals(mensajeEsperado, e.getMessage());
    }

    @Test
    public void testRegistrarClienteEmailFormatoInvalidoGeneraExcepcion() throws Exception {
        ManejadorComprasMembresias mcm = new ManejadorComprasMembresias();
        RegistrarClienteDTO rcDTO = new RegistrarClienteDTO("Jose", "Reynaga",
                "vv22222", "6541254298");
        

        RegistroClienteException e = assertThrows(RegistroClienteException.class,
                () -> mcm.registrarCliente(rcDTO));

        String mensajeEsperado = "Formato Email no valido";
        assertEquals(mensajeEsperado, e.getMessage());
    }
    
    @Test
    public void testRegistrarClienteConNumeroTelefonicoYaRegistradoGeneraExcepcion() throws Exception{
        ManejadorComprasMembresias mcm = new ManejadorComprasMembresias();
        RegistrarClienteDTO rcDTO = new RegistrarClienteDTO("Jose", "Reynaga",
                "vv22222@gmail.com", "6541254298");
        mcm.registrarCliente(rcDTO);
        
        RegistrarClienteDTO rc2DTO = new RegistrarClienteDTO("Antonio", "Diaz Coronado",
        "vv4546845412315@gmail.com","6541254298");
        RegistroClienteException e = assertThrows(RegistroClienteException.class,
                () -> mcm.registrarCliente(rc2DTO));

        String mensajeEsperado = "Numero telefonico ya registrado";
        assertEquals(mensajeEsperado, e.getMessage());
    }
}
