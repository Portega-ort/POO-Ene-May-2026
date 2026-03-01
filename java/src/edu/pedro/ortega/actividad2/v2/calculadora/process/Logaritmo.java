package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Logaritmo Entero.
 * Extiende de Division, ya que el logaritmo se puede calcular contando divisiones sucesivas.
 */
public class Logaritmo extends Division {
    /**
     * Calcula el logaritmo entero de un valor en una base dada.
     * Responde a: ¿A qué potencia debo elevar la base para obtener el valor?
     *
     * @param valor El número del cual se quiere obtener el logaritmo (argumento).
     * @param base La base del logaritmo (debe ser > 1).
     * @return La parte entera del logaritmo.
     * @throws ArithmeticException Si el valor <= 0 o la base <= 1.
     */
    @Override
    public int apply(int valor, int base) {
        if (valor <= 0 || base <= 1) {
            throw new ArithmeticException("Logaritmo no definido para estos valores (valor > 0, base > 1)");
        }

        int resultado = 0;
        int actual = valor;

        // Divide sucesivamente mientras sea posible
        while (actual >= base) {
            actual = super.apply(actual, base);
            resultado++;
        }

        return resultado;
    }
}
