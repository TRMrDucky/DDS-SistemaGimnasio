///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//
//import Enumeradores.EnumEstadoMembresia;
//import clases.mock.Membresia;
//import daos.MembresiaDAO;
//import excepciones.ActualizarMembresiaException;
//import excepciones.AgregarMembresiaException;
//import excepciones.ConsultarMembresiasException;
//import excepciones.EliminarMembresiaException;
//import java.util.List;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// *
// * @author janethcristinagalvanquinonez
// */
//public class TestMembresia {
//    
//    private MembresiaDAO membresiaDAO;
//    private Membresia membresiaGuardada;
//    public TestMembresia() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//        membresiaDAO = MembresiaDAO.getInstance();
//        membresiaGuardada = null;
//    }
//    
//    @AfterEach
//    public void tearDown() {
//        if (membresiaGuardada != null && membresiaGuardada.getId() != null) {
//            try {
//                 membresiaDAO.eliminarMembresia(membresiaGuardada.getId().toString());
//            } catch(EliminarMembresiaException e){
//                System.err.println("Error al limpiar membresíaGuardada: " +e.getMessage());
//            }
//        }
//    }
//    
//     private Membresia crearMembresiaTest(String nombre, double precio, int duracion) {
//          Membresia membresia = new Membresia();
//          membresia.setNombre(nombre);
//          membresia.setPrecio(precio);
//          membresia.setDuracion((long) duracion * 86400000L);
//          membresia.setEstado(EnumEstadoMembresia.ACTIVA);
//          return membresia;
//     }
//     
//     public void testAgregarMembresia() throws AgregarMembresiaException {
//         Membresia membresia = crearMembresiaTest("Membresía Test", 500, 30);
//          membresiaGuardada = membresiaDAO.agregarMembresia(membresia);
//          assertNotNull(membresiaGuardada);
//          assertNotNull(membresiaGuardada.getId());
//          assertEquals("Membresía Test", membresiaGuardada.getNombre());
//          assertEquals(500, membresiaGuardada.getPrecio());
//          assertEquals(30 * 86400000L, membresiaGuardada.getDuracion());
//          assertEquals(EnumEstadoMembresia.ACTIVA, membresiaGuardada.getEstado());
//     }
//     
//     public void testConsultarMembresias() throws ConsultarMembresiasException, AgregarMembresiaException {
//         membresiaGuardada = membresiaDAO.agregarMembresia(crearMembresiaTest("Membresía guardar", 600, 45));
//         List<Membresia> membresias = membresiaDAO.consultarMembresias();
// 
//         assertFalse(membresias.isEmpty());
//         
//         assertFalse(membresias.isEmpty());
//         
//         boolean encontrada = membresias.stream()
//                 .anyMatch(m -> m.getId().equals(membresiaGuardada.getId()));
//                 assertTrue(encontrada);
//         
//     }
//     
//     public void testEliminarMembresia() throws AgregarMembresiaException, EliminarMembresiaException {
//         membresiaGuardada = membresiaDAO.agregarMembresia( crearMembresiaTest("Membresía eliminar", 400, 20));
//         boolean eliminado = membresiaDAO.eliminarMembresia(membresiaGuardada.getId().toString());
//         assertTrue(eliminado);
//         
//     }
//     
//     public void testActualizarMembresia() throws AgregarMembresiaException, ActualizarMembresiaException {
//         membresiaGuardada = membresiaDAO.agregarMembresia(crearMembresiaTest("Membresía Original", 700, 60));
//         membresiaGuardada.setNombre("Membresía Modificada");
//         membresiaGuardada.setPrecio(750);
//         Membresia membresiaActualizada = membresiaDAO.actualizarMembresia(membresiaGuardada);
//         
//         
//         assertNotNull(membresiaActualizada);
//         assertEquals("Membresía Modificada", membresiaActualizada.getNombre());
//         assertEquals(750, membresiaActualizada.getPrecio());
//     }
//
//
//}
//
