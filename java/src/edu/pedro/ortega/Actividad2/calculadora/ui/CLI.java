package edu.pedro.ortega.Actividad2.calculadora.ui;

import java.util.Scanner;
import edu.pedro.ortega.Actividad2.calculadora.process.Suma;
import edu.pedro.ortega.Actividad2.calculadora.process.Resta;
import edu.pedro.ortega.Actividad2.calculadora.process.Multiplicación;
import edu.pedro.ortega.Actividad2.calculadora.process.División;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void iniciar() {
        System.out.println("Calculadora");
        boolean ejecutando = true;

        while (ejecutando) {
            System.out.println("\nSelecciona opción:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            int opcion = leerEnteroValido();

            if (opcion == 5) {
                ejecutando = false;
                System.out.println("Terminado");
            } else if (opcion >= 1 && opcion <= 4) {
                procesarOperacion(opcion);
            } else {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

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
                        acumulado = Multiplicación.ejecutar(acumulado, numero);
                        break;
                    case 4:
                        try {
                            acumulado = División.ejecutar(acumulado, numero);
                        } catch (ArithmeticException e) {
                            System.out.println("Error: " + e.getMessage());
                            contador--; // No contar esta operación fallida
                        }
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: '" + entrada + "' no es un número válido. Intente de nuevo o escriba '='.");
                contador--; 
            }
        }
        System.out.println("Resultado final: " + acumulado);
    }

    private static int leerEnteroValido() {
        while (!scanner.hasNextInt()) {
            String entrada = scanner.next();
            System.out.println("Error: '" + entrada + "' no es una opción válida. Ingrese un número entero.");
            System.out.print("Opción: ");
        }
        return scanner.nextInt();
    }

    private static double leerDoubleValido() {
        while (!scanner.hasNextDouble()) {
            String entrada = scanner.next();
            System.out.println("Error: '" + entrada + "' no es un número válido.");
            System.out.print("Intente de nuevo: ");
        }
        return scanner.nextDouble();
    }
}