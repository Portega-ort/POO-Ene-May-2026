package edu.pedro.ortega.Actividad2.calculadora.ui;

import java.util.Scanner;
import edu.pedro.ortega.Actividad2.calculadora.process.*;

/**
 * Interfaz de Línea de Comandos (CLI) para la calculadora.
 * Gestiona la interacción con el usuario, incluyendo menús y validación de entradas.
 */
public class CLI {
    /** Scanner para leer la entrada del usuario desde la consola. */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * Inicia el bucle principal de la aplicación.
     * Muestra el menú de opciones y delega la ejecución a los métodos correspondientes.
     */
    public static void iniciar() {
        System.out.println("Calculadora");
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\nSelecciona opción:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Módulo");
            System.out.println("6. Potencia");
            System.out.println("7. Raíz");
            System.out.println("8. Logaritmo");
            System.out.println("9. Salir");
            System.out.print("Opción: ");

            int opcion = leerEnteroValido();

            if (opcion == 9) {
                ejecutando = false;
                System.out.println("Terminado");
            } else if (opcion >= 1 && opcion <= 8) {
                procesarOperacion(opcion);
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    /**
     * Procesa una operación matemática seleccionada por el usuario.
     * Permite ingresar múltiples números para realizar operaciones encadenadas.
     *
     * @param tipoOperacion El identificador numérico de la operación a realizar.
     */
    private static void procesarOperacion(int tipoOperacion) {
        System.out.println("Ingrese el primer número:");
        double acumulado = leerDoubleValido();
        int contador = 1;

        System.out.println("Ingrese los siguientes números o escriba '=' para terminar y ver el resultado.");
        
        while (true) {
            System.out.print("Número " + (++contador) + ": ");
            String entrada = scanner.next();

            if (entrada.equals("=")) {
                break;
            }

            try {
                double numero = Double.parseDouble(entrada);
                switch (tipoOperacion) {
                    case 1:
                        acumulado = Suma.ejecutar(acumulado, numero);
                        break;
                    case 2:
                        acumulado = Resta.ejecutar(acumulado, numero);
                        break;
                    case 3:
                        acumulado = Multiplicacion.ejecutar(acumulado, numero);
                        break;
                    case 4:
                        acumulado = Division.ejecutar(acumulado, numero);
                        break;
                    case 5:
                        acumulado = Modulo.ejecutar(acumulado, numero);
                        break;
                    case 6:
                        acumulado = Potencia.ejecutar(acumulado, numero);
                        break;
                    case 7:
                        // Para raíz, el segundo número es el índice (ej. 2 para cuadrada)
                        acumulado = Raiz.ejecutar(acumulado, numero);
                        break;
                    case 8:
                        // Para logaritmo, el segundo número es la base
                        acumulado = Logaritmo.ejecutar(acumulado, numero);
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("Error matemático: " + e.getMessage());
                contador--;
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + entrada + "' no es un número válido. Intente de nuevo o escriba '='.");
                contador--; 
            }
        }
        System.out.println("Resultado final: " + acumulado);
    }

    /**
     * Lee un número entero válido desde la consola.
     * Si la entrada no es un entero, solicita al usuario que intente de nuevo.
     *
     * @return El número entero ingresado por el usuario.
     */
    private static int leerEnteroValido() {
        while (!scanner.hasNextInt()) {
            String entrada = scanner.next();
            System.out.println("Error: '" + entrada + "' no es una opción válida. Ingrese un número entero.");
            System.out.print("Opción: ");
        }
        return scanner.nextInt();
    }

    /**
     * Lee un número decimal (double) válido desde la consola.
     * Si la entrada no es un número válido, solicita al usuario que intente de nuevo.
     *
     * @return El número decimal ingresado por el usuario.
     */
    private static double leerDoubleValido() {
        while (!scanner.hasNextDouble()) {
            String entrada = scanner.next();
            System.out.println("Error: '" + entrada + "' no es un número válido.");
            System.out.print("Intente de nuevo: ");
        }
        return scanner.nextDouble();
    }
}