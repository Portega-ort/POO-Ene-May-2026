package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Módulo (Residuo).
 * Extiende de Resta, ya que el residuo es lo que queda después de restar el divisor tantas veces como sea posible.
 */
public class Modulo extends Resta {
    /**
     * Calcula el residuo de la división entera.
     *
     * @param a Dividendo.
     * @param b Divisor.
     * @return El residuo de la división a / b.
     * @throws ArithmeticException Si el divisor es 0.
     */
    @Override
    public int apply(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        int absA = Math.abs(a);
        int absB = Math.abs(b);

        // Resta iterativa hasta que quede el residuo
        while (absA >= absB) {
            absA = super.apply(absA, absB);
        }

        // El signo del módulo sigue el signo del dividendo
        return (a < 0) ? -absA : absA;
    }
}
