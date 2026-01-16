package edu.pedro.ortega.actividad1.process;

import edu.pedro.ortega.actividad1.data.Carro;
import edu.pedro.ortega.actividad1.data.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ShopManager {
    public static final String MARCA_AGENCIA = "TOYOTA";
    private List<Carro> inventario;

    public ShopManager() {
        inventario = new ArrayList<>();
        inventario.add(new Carro("Sedán", "Corolla", 26000));
        inventario.add(new Carro("SUV", "RAV4", 35000));
        inventario.add(new Carro("Pick-up", "Hilux", 42000));
        inventario.add(new Carro("Híbrido", "Prius", 32000));
        inventario.add(new Carro("Deportivo", "GR Supra", 60000));
    }

    public List<Carro> getInventario() {
        return inventario;
    }

    public Ticket generarVenta(String nombre, List<Carro> seleccionados) {
        double total = 0;
        for (Carro c : seleccionados) {
            total += c.getPrecio();
        }
        return new Ticket(nombre, seleccionados, total);
    }
}
