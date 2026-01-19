package edu.pedro.ortega.Actividad2.calculadora.process;

/**
 * Clase que implementa la operación de división.
 */
public class División {
    /**
     * Realiza la división de dos números utilizando restas iterativas.
     * Solo se utiliza la clase Resta para realizar la operación.
     *
     * @param dividendo El número a dividir.
     * @param divisor El número por el cual se divide.
     * @return El cociente de la división.
     * @throws ArithmeticException Si el divisor es 0.
     */
    public static double ejecutar(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        double cociente = 0;
        // Determinar el signo del resultado
        boolean negativo = (dividendo < 0 && divisor > 0) || (dividendo > 0 && divisor < 0);
        double absDividendo = Math.abs(dividendo);
        double absDivisor = Math.abs(divisor);

        // Restar el divisor del dividendo hasta que no se pueda más
        while (absDividendo >= absDivisor) {
            absDividendo = Resta.ejecutar(absDividendo, absDivisor);
            cociente = Suma.ejecutar(cociente, 1);
        }

        return negativo ? -cociente : cociente;
    }
}
