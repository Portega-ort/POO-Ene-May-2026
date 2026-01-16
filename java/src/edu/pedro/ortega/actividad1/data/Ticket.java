package edu.pedro.ortega.actividad1.data;

import edu.pedro.ortega.actividad1.process.ShopManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Ticket {
    private String nombreCliente;
    private List<Carro> carrosComprados;
    private double total;
    private LocalDateTime fecha;

    public Ticket(String nombreCliente, List<Carro> carrosComprados, double total) {
        this.nombreCliente = nombreCliente;
        this.carrosComprados = carrosComprados;
        this.total = total;
        this.fecha = LocalDateTime.now();
    }

    public void imprimirTicket() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("\n=======================================");
        System.out.println("       CONCESIONARIA " + ShopManager.MARCA_AGENCIA);
        System.out.println("=======================================");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Fecha:   " + fecha.format(formatter));
        System.out.println("---------------------------------------");
        for (Carro c : carrosComprados) {
            System.out.println(c.toString());
        }
        System.out.println("---------------------------------------");
        System.out.printf("TOTAL FINAL: $%.2f\n", total);
        System.out.println("=======================================\n");
    }
}