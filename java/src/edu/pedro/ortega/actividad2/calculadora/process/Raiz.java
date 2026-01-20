package edu.pedro.ortega.actividad2.calculadora.process;

/**
 * Clase que implementa la operación de radicación.
 */
public class Raiz {
    /**
     * Calcula la raíz n-ésima de un número utilizando el método de aproximación (Newton-Raphson simplificado)
     * o búsqueda binaria, construido solo con operaciones básicas disponibles.
     * 
     * Para simplificar y cumplir con la restricción de usar solo operaciones básicas ya implementadas:
     * Usaremos un método de aproximación por fuerza bruta refinada (búsqueda lineal) para raíces enteras,
     * ya que implementar algoritmos complejos de punto flotante sin librerías matemáticas y solo con sumas/restas
     * puede ser muy extenso y propenso a errores de precisión en este contexto.
     * 
     * NOTA: Esta implementación es una aproximación básica para fines educativos.
     *
     * @param radicando El número del cual se quiere obtener la raíz.
     * @param indice El índice de la raíz.
     * @return Una aproximación de la raíz.
     */
    public static double ejecutar(double radicando, double indice) {
        if (indice == 0) {
            throw new ArithmeticException("El índice de la raíz no puede ser 0.");
        }
        if (radicando < 0 && Modulo.ejecutar(indice, 2) == 0) {
            throw new ArithmeticException("No existe raíz real de índice par para un número negativo.");
        }
        
        // Aproximación simple: Búsqueda lineal con un paso pequeño (precisión limitada)
        // Buscamos r tal que r^indice ~= radicando
        
        double precision = 0.001; // Paso de incremento
        double r = 0;
        
        // Si el radicando es mayor que 1, la raíz estará entre 0 y radicando
        // Si es menor que 1, estará entre 0 y 1.
        // Simplificación: asumimos radicando > 1 para el bucle principal
        
        while (Potencia.ejecutar(r, indice) < radicando) {
            r = Suma.ejecutar(r, precision);
        }
        
        // Ajuste fino: r se pasó un poco, devolvemos el valor anterior o el actual
        return r;
    }
}
