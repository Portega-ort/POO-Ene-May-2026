package edu.pedro.ortega.actividad1.data;

public class Carro {
    private String tipo;
    private String modelo;
    private double precio;

    public Carro(String tipo, String modelo, double precio) {
        this.tipo = tipo;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getTipo() { return tipo; }
    public String getModelo() { return modelo; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format("[%s] %s - $%.2f", tipo, modelo, precio);
    }
}
