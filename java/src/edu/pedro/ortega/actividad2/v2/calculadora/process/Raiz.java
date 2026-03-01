package edu.pedro.ortega.actividad2.v2.calculadora.process;

/**
 * Implementación de la operación Raíz Entera.
 * Extiende de Operacion directamente y utiliza Potencia por composición.
 */
public class Raiz extends Operacion {
    /**
     * Calcula la raíz entera n-ésima de un número.
     * Busca el número entero r tal que r^indice <= radicando.
     *
     * @param radicando El número del cual se quiere obtener la raíz.
     * @param indice El índice de la raíz (ej. 2 para cuadrada, 3 para cúbica).
     * @return La parte entera de la raíz.
     * @throws ArithmeticException Si el índice es 0 o si se intenta raíz par de negativo.
     */
    @Override
    public int apply(int radicando, int indice) {
        if (indice == 0) {
            throw new ArithmeticException("El índice de la raíz no puede ser 0");
        }
        if (radicando < 0 && indice % 2 == 0) {
            throw new ArithmeticException("Raíz par de número negativo no existe en reales");
        }

        // Búsqueda lineal simple para raíz entera
        Potencia potencia = new Potencia();
        int r = 0;
        
        // Incrementa r mientras r^indice sea menor o igual al radicando
        while (potencia.apply(r + 1, indice) <= radicando) {
            r++;
        }
        
        return r;
    }
}
