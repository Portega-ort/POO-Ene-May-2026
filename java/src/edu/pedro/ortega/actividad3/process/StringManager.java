package edu.pedro.ortega.actividad3.process;

/**
 * Clase utilitaria para realizar operaciones sobre cadenas de texto (Strings).
 * Implementa algoritmos manuales para evitar el uso de métodos avanzados de la clase String.
 */
public class StringManager {

    /**
     * Determina si una cadena de texto es un palíndromo (se lee igual de izquierda a derecha que de derecha a izquierda).
     * Ignora espacios y diferencias entre mayúsculas y minúsculas.
     * 
     * @param texto La cadena a evaluar.
     * @return true si es palíndromo, false en caso contrario o si el texto es null.
     */
    public boolean esPalindromo(String texto) {
        if (texto == null) return false;
        
        // Limpieza manual de espacios y conversión a minúsculas
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != ' ') {
                // Conversión simple a minúscula si es mayúscula (ASCII)
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + 32);
                }
                sb.append(c);
            }
        }
        
        String limpio = sb.toString();
        int izquierda = 0;
        int derecha = limpio.length() - 1;
        
        while (izquierda < derecha) {
            if (limpio.charAt(izquierda) != limpio.charAt(derecha)) {
                return false;
            }
            izquierda++;
            derecha--;
        }
        return true;
    }

    /**
     * Cuenta el número de vocales (a, e, i, o, u, con y sin tilde) en una cadena.
     * 
     * @param texto La cadena a evaluar.
     * @return El número total de vocales encontradas. Retorna 0 si el texto es null.
     */
    public int contarVocales(String texto) {
        if (texto == null) return 0;
        int contador = 0;
        // Definimos vocales manualmente para evitar librerías
        char[] vocales = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U', 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú'};
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            for (char v : vocales) {
                if (c == v) {
                    contador++;
                    break; // Ya encontramos que es vocal, pasamos al siguiente caracter del texto
                }
            }
        }
        return contador;
    }

    /**
     * Invierte una cadena de texto sin utilizar el método reverse().
     * 
     * @param texto La cadena a invertir.
     * @return Una nueva cadena con los caracteres en orden inverso. Retorna null si el input es null.
     */
    public String invertirCadena(String texto) {
        if (texto == null) return null;
        char[] caracteres = new char[texto.length()];
        int j = 0;
        for (int i = texto.length() - 1; i >= 0; i--) {
            caracteres[j++] = texto.charAt(i);
        }
        return new String(caracteres);
    }

    /**
     * Encuentra la primera posición (índice) de un carácter específico dentro de una cadena.
     * No utiliza String.indexOf().
     * 
     * @param texto La cadena donde buscar.
     * @param caracter El carácter a buscar.
     * @return El índice de la primera aparición (0-based), o -1 si no se encuentra o el texto es null.
     */
    public int encontrarCaracter(String texto, char caracter) {
        if (texto == null) return -1;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                return i;
            }
        }
        return -1;
    }
}
