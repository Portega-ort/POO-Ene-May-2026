package edu.pedro.ortega.actividad2.calculadora.process;

/**
 * Clase que implementa la operación de potenciación.
 */
public class Potencia {
    /**
     * Eleva un número base a un exponente dado utilizando multiplicaciones iterativas.
     *
     * @param base La base.
     * @param exponente El exponente (se asume entero para esta implementación iterativa).
     * @return El resultado de base elevado a exponente.
     */
    public static double ejecutar(double base, double exponente) {
        if (exponente == 0) return 1;
        
        double resultado = 1;
        double absExponente = Math.abs(exponente);
        
        for (int i = 0; i < absExponente; i++) {
            resultado = Multiplicacion.ejecutar(resultado, base);
        }
        
        // Si el exponente es negativo, el resultado es 1 / resultado
        if (exponente < 0) {
            return Division.ejecutar(1, resultado);
        }
        
        return resultado;
    }
}
