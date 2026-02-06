package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Clase abstracta que define la estructura base para todas las operaciones matemáticas.
 * Aplica el Principio de Sustitución de Liskov (LSP) permitiendo que cualquier
 * subclase sea tratada como una Operacion genérica.
 */
public abstract class Operacion {
    /**
     * Método abstracto para aplicar la operación matemática.
     *
     * @param a Primer operando (su significado depende de la operación concreta).
     * @param b Segundo operando (su significado depende de la operación concreta).
     * @return El resultado entero de la operación.
     * @throws ArithmeticException Si ocurre un error matemático (ej. división por cero).
     */
    public abstract int apply(int a, int b);
}
