package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Potencia.
 * Extiende de Multiplicacion, ya que la potencia es una serie de multiplicaciones iteradas.
 */
public class Potencia extends Multiplicacion {
    /**
     * Eleva un número base a un exponente entero positivo.
     *
     * @param base La base.
     * @param exponente El exponente (debe ser >= 0).
     * @return El resultado de base^exponente.
     * @throws ArithmeticException Si el exponente es negativo (no soportado en enteros).
     */
    @Override
    public int apply(int base, int exponente) {
        if (exponente < 0) {
            throw new ArithmeticException("Potencia con exponente negativo no soportada en enteros");
        }
        if (exponente == 0) return 1;

        int resultado = 1;
        
        // Multiplica la base por sí misma 'exponente' veces
        for (int i = 0; i < exponente; i++) {
            resultado = super.apply(resultado, base);
        }
        
        return resultado;
    }
}
