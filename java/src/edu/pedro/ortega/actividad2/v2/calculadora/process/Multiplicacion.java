package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Multiplicación.
 * Extiende de Suma para reutilizar la lógica aditiva (multiplicación como sumas iteradas).
 */
public class Multiplicacion extends Suma {
    /**
     * Realiza la multiplicación de dos números enteros utilizando sumas sucesivas.
     *
     * @param a Multiplicando.
     * @param b Multiplicador.
     * @return El producto de a por b.
     */
    @Override
    public int apply(int a, int b) {
        int resultado = 0;
        int absA = Math.abs(a);
        int absB = Math.abs(b);

        // Suma absA, absB veces
        for (int i = 0; i < absB; i++) {
            resultado = super.apply(resultado, absA);
        }

        // Ajuste de signo
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) {
            return -resultado;
        }
        return resultado;
    }
}
