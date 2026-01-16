package edu.pedro.ortega.actividad1.ui;


import edu.pedro.ortega.actividad1.data.Carro;
import edu.pedro.ortega.actividad1.process.ShopManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    private Scanner scanner = new Scanner(System.in);
    private ShopManager manager = new ShopManager();

    public void start() {
        System.out.println("--- Agencia Oficial " + ShopManager.MARCA_AGENCIA + " ---");

        // Validación del nombre: Solo acepta letras y espacios
        String cliente = leerNombreValido();

        List<Carro> carrito = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            System.out.println("\nSeleccione el NÚMERO del vehículo para agregar.");
            System.out.print("O escriba 'X' para generar su ticket: ");

            String entrada = scanner.nextLine().trim();

            // Opción para terminar
            if (entrada.equalsIgnoreCase("X")) {
                continuar = false;
            } else {
                // Intentar procesar la selección numérica
                try {
                    int indice = Integer.parseInt(entrada);

                    if (indice > 0 && indice <= manager.getInventario().size()) {
                        Carro seleccionado = manager.getInventario().get(indice - 1);
                        carrito.add(seleccionado);
                        System.out.println(">> [" + seleccionado.getModelo() + "] agregado al carrito.");
                    } else {
                        System.out.println("Error: El número " + indice + " no está en el catálogo. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    // Si no es "SALIR" y no es un número válido
                    System.out.println("Error: Entrada no reconocida. Ingrese un número del menú o escriba 'SALIR'.");
                }
            }
        }

        // Generación del ticket final
        if (!carrito.isEmpty()) {
            manager.generarVenta(cliente, carrito).imprimirTicket();
        } else {
            System.out.println("Venta cancelada: No se seleccionaron vehículos.");
        }
    }

    private String leerNombreValido() {
        while (true) {
            System.out.print("Ingrese el nombre del cliente (solo letras): ");
            String nombre = scanner.nextLine().trim();

            if (!nombre.isEmpty() && nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                return nombre;
            } else {
                System.out.println("Error: El nombre debe contener únicamente letras.");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\nCatálogo " + ShopManager.MARCA_AGENCIA + " disponible:");
        List<Carro> lista = manager.getInventario();
        for (int i = 0; i < lista.size(); i++) {
            Carro c = lista.get(i);
            System.out.println((i + 1) + ". " + c.getModelo() + " [" + c.getTipo() + "] - $" + c.getPrecio());
        }
    }
}