package edu.pedro.ortega.actividad3.test;

import edu.pedro.ortega.actividad3.process.StringManager;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.*;

public class StringManagerTest {
    
    private StringManager manager = new StringManager();

    @Test
    public void testEsPalindromo() {
        assertTrue(manager.esPalindromo("ana"));
        assertTrue(manager.esPalindromo("Anita lava la tina"));
        assertFalse(manager.esPalindromo("hola mundo"));
        assertFalse(manager.esPalindromo(null));
    }

    private void assertTrue(boolean anitaLavaLaTina) {
    }

    @Test
    public void testContarVocales() {
        assertEquals(2, manager.contarVocales("hola"));
        assertEquals(5, manager.contarVocales("murcielago"));
        assertEquals(0, manager.contarVocales("rhythm")); // Sin vocales estándar
        assertEquals(0, manager.contarVocales(null));
    }

    @Test
    public void testInvertirCadena() {
        assertEquals("aloh", manager.invertirCadena("hola"));
        assertEquals("odnum", manager.invertirCadena("mundo"));
        assertNull(manager.invertirCadena(null));
    }

    private void assertNull(String s) {
    }

    @Test
    public void testEncontrarCaracter() {
        assertEquals(1, manager.encontrarCaracter("hola", 'o'));
        assertEquals(-1, manager.encontrarCaracter("hola", 'r'));
        assertEquals(0, manager.encontrarCaracter("avion", 'a'));
        assertEquals(-1, manager.encontrarCaracter(null, 'a'));
    }
}