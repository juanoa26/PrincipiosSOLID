package co.unicauca.parqueaderopublico.modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Juan Sebastian Osorio, Diego Vidal Lopez
 */
public class MotoVehiculoCostoTest {
    
    public MotoVehiculoCostoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcularPago method, of class MotoVehiculoCosto.
     */
    @Test
    public void testCalcularPago() {
        //Prueba 1
        System.out.println("calcularPago");
        int minutos = 46;
        MotoVehiculoCosto instance = new MotoVehiculoCosto();
        double expResult = 1000;
        double result = instance.calcularPago(minutos);
        assertEquals(expResult, result, 0.0);
        
        //Prueba 2
        System.out.println("calcularPago");
        minutos = 163;
        expResult = 1900;
        result = instance.calcularPago(minutos);
        assertEquals(expResult, result, 0.0);
        //Prueba 3
        System.out.println("calcularPago");
        minutos = 180;
        expResult = 2000;
        result = instance.calcularPago(minutos);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
