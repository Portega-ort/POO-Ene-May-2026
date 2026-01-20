package edu.pedro.ortega.actividad2.calculadora.process;

/**
 * Clase que implementa la operación de módulo (residuo).
 */
public class Modulo {
    /**
     * Calcula el residuo de la división de dos números utilizando restas iterativas.
     * Se basa en la lógica de la división pero retorna lo que sobra.
     *
     * @param a Dividendo.
     * @param b Divisor.
     * @return El residuo de a dividido por b.
     */
    public static double ejecutar(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede calcular el módulo con divisor cero");
        }
        
        double absA = Math.abs(a);
        double absB = Math.abs(b);

        // Restar el divisor del dividendo hasta que quede el residuo
        while (absA >= absB) {
            absA = Resta.ejecutar(absA, absB);
        }
        
        // El signo del módulo depende del dividendo en Java
        return (a < 0) ? -absA : absA;
    }
}
