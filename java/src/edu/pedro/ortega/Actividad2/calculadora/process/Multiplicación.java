package edu.pedro.ortega.Actividad2.calculadora.process;

public class Multiplicación {
    public static double ejecutar(double a, double b) {
        double resultado = 0;
        boolean negativo = (a < 0 && b > 0) || (a > 0 && b < 0);
        double absA = Math.abs(a);
        double absB = Math.abs(b);

        for (int i = 0; i < absB; i++) {
            resultado += absA;
        }

        return negativo ? -resultado : resultado;
    }
}