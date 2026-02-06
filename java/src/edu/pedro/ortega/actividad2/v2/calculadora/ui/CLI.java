package edu.pedro.ortega.actividad2.v2.calculadora.ui;

import edu.pedro.ortega.actividad2.v2.calculadora.process.*;
import java.util.Scanner;

public class CLI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void iniciar() {
        System.out.println("Calculadora Completa (Actividad 2 - v2 - SOLID)");
        boolean ejecutando = true;

        while (ejecutando) {
            mostrarMenu();
            int opcion = leerEnteroValido();

            if (opcion == 9) {
                ejecutando = false;
                System.out.println("Terminado");
            } else if (opcion >= 1 && opcion <= 8) {
                procesarOperacion(opcion);
            } else {
                System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
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
    }

    private static void procesarOperacion(int opcion) {
        Operacion operacion = obtenerOperacion(opcion);
        
        if (operacion == null) return;

        System.out.print("Ingrese el primer número: ");
        int a = leerEnteroValido();
        System.out.print("Ingrese el segundo número: ");
        int b = leerEnteroValido();

        try {
            int resultado = operacion.apply(a, b);
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Operacion obtenerOperacion(int opcion) {
        switch (opcion) {
            case 1: return new Suma();
            case 2: return new Resta();
            case 3: return new Multiplicacion();
            case 4: return new Division();
            case 5: return new Modulo();
            case 6: return new Potencia();
            case 7: return new Raiz();
            case 8: return new Logaritmo();
            default: return null;
        }
    }

    private static int leerEnteroValido() {
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.print("Por favor ingrese un número entero: ");
        }
        return scanner.nextInt();
    }
}
