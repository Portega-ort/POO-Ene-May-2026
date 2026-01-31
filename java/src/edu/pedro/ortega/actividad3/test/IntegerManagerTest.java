package edu.pedro.ortega.actividad3.test;

import edu.pedro.ortega.actividad3.process.IntegerManager;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class IntegerManagerTest {

    private IntegerManager manager = new IntegerManager();

    @Test
    public void testMoverCerosDerecha() {
        List<Integer> input = Arrays.asList(0, 2, 1, 4, 0, 2);
        List<Integer> expected = Arrays.asList(2, 1, 4, 2, 0, 0);
        assertEquals(expected, manager.moverCerosDerecha(input));

        List<Integer> input2 = Arrays.asList(0, 0, 1);
        List<Integer> expected2 = Arrays.asList(1, 0, 0);
        assertEquals(expected2, manager.moverCerosDerecha(input2));
    }

    @Test
    public void testContarPares() {
        List<Integer> input = Arrays.asList(3, 4, 5, 7, 6);
        assertEquals(2, manager.contarPares(input));

        List<Integer> input2 = Arrays.asList(1, 3, 5);
        assertEquals(0, manager.contarPares(input2));
        
        assertEquals(0, manager.contarPares(null));
    }
}