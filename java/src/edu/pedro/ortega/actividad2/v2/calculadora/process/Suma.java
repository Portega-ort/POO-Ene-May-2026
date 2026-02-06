package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Suma.
 * Es la operación base para la aritmética aditiva.
 */
public class Suma extends Operacion {
    /**
     * Realiza la suma de dos números enteros.
     *
     * @param a Primer sumando.
     * @param b Segundo sumando.
     * @return La suma de a y b.
     */
    @Override
    public int apply(int a, int b) {
        return a + b;
    }
}
