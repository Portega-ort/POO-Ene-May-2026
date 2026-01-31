package edu.pedro.ortega.actividad3.process;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase utilitaria para realizar operaciones sobre listas de números enteros.
 */
public class IntegerManager {

    /**
     * Mueve todos los ceros (0) presentes en la lista hacia el final (derecha),
     * manteniendo el orden relativo de los elementos no cero.
     * 
     * @param numeros La lista de enteros a procesar.
     * @return Una nueva lista con los ceros movidos a la derecha. Retorna lista vacía si el input es null.
     */
    public List<Integer> moverCerosDerecha(List<Integer> numeros) {
        if (numeros == null) return new ArrayList<>();
        List<Integer> resultado = new ArrayList<>();
        int ceros = 0;
        
        // Agregar los no ceros primero
        for (Integer num : numeros) {
            if (num != 0) {
                resultado.add(num);
            } else {
                ceros++;
            }
        }
        
        // Rellenar con ceros al final
        for (int i = 0; i < ceros; i++) {
            resultado.add(0);
        }
        return resultado;
    }

    /**
     * Cuenta la cantidad de números pares en una lista de enteros.
     * 
     * @param numeros La lista de enteros a evaluar.
     * @return La cantidad de números pares encontrados. Retorna 0 si la lista es null.
     */
    public int contarPares(List<Integer> numeros) {
        if (numeros == null) return 0;
        int contador = 0;
        for (Integer num : numeros) {
            if (num % 2 == 0) {
                contador++;
            }
        }
        return contador;
    }
}
