package edu.pedro.ortega.Actividad2.calculadora.process;

/**
 * Clase que implementa la operación de multiplicación.
 */
public class Multiplicación {
    /**
     * Realiza la multiplicación de dos números utilizando sumas iterativas.
     * Solo se utiliza la clase Suma para realizar la operación.
     * Nota: El segundo operando se trata como entero para el número de iteraciones.
     *
     * @param a Multiplicando.
     * @param b Multiplicador.
     * @return El producto de a y b.
     */
    public static double ejecutar(double a, double b) {
        double resultado = 0;
        // Determinar el signo del resultado
        boolean negativo = (a < 0 && b > 0) || (a > 0 && b < 0);
        double absA = Math.abs(a);
        double absB = Math.abs(b);

        // Sumar absA, absB veces
        for (int i = 0; i < absB; i++) {
            resultado = Suma.ejecutar(resultado, absA);
        }

        return negativo ? -resultado : resultado;
    }
}
