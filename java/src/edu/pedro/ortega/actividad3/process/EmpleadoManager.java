package edu.pedro.ortega.actividad3.process;

import edu.pedro.ortega.actividad3.data.Empleado;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase gestora para realizar operaciones de negocio sobre listas de empleados.
 */
public class EmpleadoManager {

    /**
     * Encuentra y devuelve el empleado con el salario más alto de la lista.
     * 
     * @param empleados Lista de empleados.
     * @return El objeto Empleado con mayor salario, o null si la lista es vacía o null.
     */
    public Empleado obtenerMejorPagado(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return null;
        Empleado mejorPagado = empleados.get(0);
        for (int i = 1; i < empleados.size(); i++) {
            Empleado actual = empleados.get(i);
            if (actual.getSalario() > mejorPagado.getSalario()) {
                mejorPagado = actual;
            }
        }
        return mejorPagado;
    }

    /**
     * Determina cuál es la edad que más se repite entre los empleados.
     * 
     * @param empleados Lista de empleados.
     * @return La edad más común (moda). Si hay empate, devuelve cualquiera de las ganadoras. Retorna -1 si la lista es vacía.
     */
    public int obtenerEdadMasComun(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return -1;
        
        // Usamos un mapa para contar frecuencias manualmente
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (Empleado e : empleados) {
            int edad = e.getEdad();
            if (frecuencias.containsKey(edad)) {
                frecuencias.put(edad, frecuencias.get(edad) + 1);
            } else {
                frecuencias.put(edad, 1);
            }
        }
        
        int edadMasComun = -1;
        int maxFrecuencia = -1;
        
        for (Map.Entry<Integer, Integer> entry : frecuencias.entrySet()) {
            if (entry.getValue() > maxFrecuencia) {
                maxFrecuencia = entry.getValue();
                edadMasComun = entry.getKey();
            }
        }
        return edadMasComun;
    }

    /**
     * Calcula el promedio aritmético de las edades de todos los empleados.
     * 
     * @param empleados Lista de empleados.
     * @return El promedio de edad. Retorna 0 si la lista es vacía.
     */
    public double calcularPromedioEdad(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return 0;
        int sumaEdades = 0;
        for (Empleado e : empleados) {
            sumaEdades += e.getEdad();
        }
        return (double) sumaEdades / empleados.size();
    }

    /**
     * Calcula el promedio aritmético de los salarios de todos los empleados.
     * 
     * @param empleados Lista de empleados.
     * @return El promedio de salario. Retorna 0 si la lista es vacía.
     */
    public double calcularPromedioSalario(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return 0;
        double sumaSalarios = 0;
        for (Empleado e : empleados) {
            sumaSalarios += e.getSalario();
        }
        return sumaSalarios / empleados.size();
    }

    /**
     * Calcula el promedio de edad únicamente de los empleados cuyo salario es mayor a 25,000.
     * 
     * @param empleados Lista de empleados.
     * @return El promedio de edad del subgrupo filtrado. Retorna 0 si no hay empleados que cumplan la condición.
     */
    public double calcularPromedioEdadSalarioMayor25k(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return 0;
        int sumaEdades = 0;
        int contador = 0;
        
        for (Empleado e : empleados) {
            if (e.getSalario() > 25000) {
                sumaEdades += e.getEdad();
                contador++;
            }
        }
        
        if (contador == 0) return 0;
        return (double) sumaEdades / contador;
    }

    /**
     * Genera una nueva lista que contiene solo a los empleados menores de 25 años.
     * 
     * @param empleados Lista original de empleados.
     * @return Lista filtrada con empleados < 25 años.
     */
    public List<Empleado> filtrarMenoresDe25(List<Empleado> empleados) {
        List<Empleado> resultado = new ArrayList<>();
        if (empleados == null) return resultado;
        for (Empleado e : empleados) {
            if (e.getEdad() < 25) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    /**
     * Cuenta cuántos empleados pertenecen al departamento de "Sistemas" (insensible a mayúsculas/minúsculas).
     * 
     * @param empleados Lista de empleados.
     * @return El número de empleados en Sistemas.
     */
    public int contarEmpleadosSistemas(List<Empleado> empleados) {
        if (empleados == null) return 0;
        int contador = 0;
        for (Empleado e : empleados) {
            // Comparación manual ignorando mayúsculas/minúsculas
            String depto = e.getDepartamento();
            if (depto != null && depto.equalsIgnoreCase("sistemas")) {
                contador++;
            }
        }
        return contador;
    }

    /**
     * Encuentra al empleado con el mayor salario dentro del grupo de empleados mayores de 30 años.
     * 
     * @param empleados Lista de empleados.
     * @return El empleado mejor pagado mayor de 30 años, o null si no hay candidatos.
     */
    public Empleado obtenerMejorPagadoMayor30(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return null;
        Empleado candidato = null;
        for (Empleado e : empleados) {
            if (e.getEdad() > 30) {
                if (candidato == null || e.getSalario() > candidato.getSalario()) {
                    candidato = e;
                }
            }
        }
        return candidato;
    }

    /**
     * Encuentra al empleado con el menor salario dentro del grupo de empleados cuya edad es la menos común (frecuencia mínima).
     * 
     * @param empleados Lista de empleados.
     * @return El empleado con menor salario entre los de edad menos común.
     */
    public Empleado obtenerMenorPagadoEdadMenosComun(List<Empleado> empleados) {
        if (empleados == null || empleados.isEmpty()) return null;
        
        // 1. Calcular frecuencias de edades
        Map<Integer, Integer> frecuencias = new HashMap<>();
        for (Empleado e : empleados) {
            int edad = e.getEdad();
            if (frecuencias.containsKey(edad)) {
                frecuencias.put(edad, frecuencias.get(edad) + 1);
            } else {
                frecuencias.put(edad, 1);
            }
        }
        
        // 2. Encontrar la frecuencia mínima
        int minFrecuencia = Integer.MAX_VALUE;
        for (int f : frecuencias.values()) {
            if (f < minFrecuencia) {
                minFrecuencia = f;
            }
        }
        
        // 3. Buscar el de menor salario entre los que tienen edad con frecuencia mínima
        Empleado resultado = null;
        for (Empleado e : empleados) {
            if (frecuencias.get(e.getEdad()) == minFrecuencia) {
                if (resultado == null || e.getSalario() < resultado.getSalario()) {
                    resultado = e;
                }
            }
        }
        return resultado;
    }
}
