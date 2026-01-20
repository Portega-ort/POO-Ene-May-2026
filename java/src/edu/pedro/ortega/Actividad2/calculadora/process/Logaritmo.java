package edu.pedro.ortega.Actividad2.calculadora.process;

/**
 * Clase que implementa la operación de logaritmo.
 */
public class Logaritmo {
    /**
     * Calcula el logaritmo entero de un número en una base dada utilizando divisiones iterativas.
     * Log_b(x) = y  <==> b^y <= x
     *
     * @param valor El número del cual se quiere obtener el logaritmo.
     * @param base La base del logaritmo.
     * @return Una aproximación entera del logaritmo.
     */
    public static double ejecutar(double valor, double base) {
        if (valor <= 0 || base <= 0 || base == 1) {
            throw new ArithmeticException("El logaritmo no está definido para estos valores.");
        }
        
        double resultado = 0;
        double actual = valor;
        
        // Mientras el valor actual sea mayor o igual a la base, podemos dividir una vez más
        while (actual >= base) {
            actual = Division.ejecutar(actual, base);
            resultado = Suma.ejecutar(resultado, 1);
        }
        
        return resultado;
    }
}
