package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Resta.
 * Es la operación base para la aritmética sustractiva.
 */
public class Resta extends Operacion {
    /**
     * Realiza la resta de dos números enteros.
     *
     * @param a Minuendo.
     * @param b Sustraendo.
     * @return La diferencia (a - b).
     */
    @Override
    public int apply(int a, int b) {
        return a - b;
    }
}
