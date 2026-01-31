package edu.pedro.ortega.actividad3.test;

import edu.pedro.ortega.actividad3.data.Empleado;
import edu.pedro.ortega.actividad3.process.EmpleadoManager;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class EmpleadoManagerTest {

    private EmpleadoManager manager = new EmpleadoManager();
    private List<Empleado> empleados;

    @Before
    public void setUp() {
        empleados = Arrays.asList(
            new Empleado("Juan", 30, 30000, "Sistemas"),
            new Empleado("Ana", 25, 35000, "RH"),
            new Empleado("Pedro", 30, 40000, "Sistemas"), 
            new Empleado("Luis", 22, 20000, "Ventas"),
            new Empleado("Maria", 35, 50000, "Gerencia"), 
            new Empleado("Sofia", 22, 26000, "Sistemas")
        );
    }

    @Test
    public void testObtenerMejorPagado() {
        Empleado mejor = manager.obtenerMejorPagado(empleados);
        assertNotNull(mejor);
        assertEquals("Maria", mejor.getNombre());
        assertEquals(50000, mejor.getSalario(), 0.01);
    }

    @Test
    public void testObtenerEdadMasComun() {
        // Edades: 30, 25, 30, 22, 35, 22 -> 30 y 22 se repiten 2 veces.
        int edad = manager.obtenerEdadMasComun(empleados);
        assertTrue(edad == 30 || edad == 22);
    }

    @Test
    public void testCalcularPromedioEdad() {
        // (30+25+30+22+35+22) / 6 = 164 / 6 = 27.333...
        assertEquals(27.33, manager.calcularPromedioEdad(empleados), 0.01);
    }

    @Test
    public void testCalcularPromedioSalario() {
        // (30000+35000+40000+20000+50000+26000) / 6 = 201000 / 6 = 33500
        assertEquals(33500, manager.calcularPromedioSalario(empleados), 0.01);
    }

    @Test
    public void testCalcularPromedioEdadSalarioMayor25k() {
        // Ganan > 25k: Juan(30), Ana(25), Pedro(30), Maria(35), Sofia(22)
        // Edades: 30+25+30+35+22 = 142
        // Cantidad: 5
        // Promedio: 142 / 5 = 28.4
        assertEquals(28.4, manager.calcularPromedioEdadSalarioMayor25k(empleados), 0.01);
    }

    @Test
    public void testFiltrarMenoresDe25() {
        List<Empleado> menores = manager.filtrarMenoresDe25(empleados);
        assertEquals(2, menores.size()); // Luis (22) y Sofia (22)
        for (Empleado e : menores) {
            assertTrue(e.getEdad() < 25);
        }
    }

    @Test
    public void testContarEmpleadosSistemas() {
        assertEquals(3, manager.contarEmpleadosSistemas(empleados)); // Juan, Pedro, Sofia
    }

    @Test
    public void testObtenerMejorPagadoMayor30() {
        // Maria tiene 35 y gana 50000. Pedro tiene 30 (no > 30).
        Empleado e = manager.obtenerMejorPagadoMayor30(empleados);
        assertNotNull(e);
        assertEquals("Maria", e.getNombre());
    }

    @Test
    public void testObtenerMenorPagadoEdadMenosComun() {
        // Edades: 30(2), 25(1), 22(2), 35(1).
        // Menos comunes (frecuencia 1): 25 (Ana, 35000) y 35 (Maria, 50000).
        // De estos, el de menor salario es Ana.
        Empleado e = manager.obtenerMenorPagadoEdadMenosComun(empleados);
        assertNotNull(e);
        assertEquals("Ana", e.getNombre());
        assertEquals(35000, e.getSalario(), 0.01);
    }
}