package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación División.
 * Extiende de Resta para reutilizar la lógica sustractiva (división como restas iteradas).
 */
public class Division extends Resta {
    /**
     * Realiza la división entera de dos números utilizando restas sucesivas.
     *
     * @param a Dividendo.
     * @param b Divisor.
     * @return El cociente entero de la división.
     * @throws ArithmeticException Si el divisor es 0.
     */
    @Override
    public int apply(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        int cociente = 0;
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        // Resta el divisor del dividendo mientras sea posible
        while (absA >= absB) {
            absA = super.apply(absA, absB);
            cociente++;
        }

        // Ajuste de signo
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return -cociente;
        }
        return cociente;
    }
}
