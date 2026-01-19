package edu.pedro.ortega.Actividad2.calculadora.process;

public class División {
    public static double ejecutar(double dividendo, double divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }

        double cociente = 0;
        boolean negativo = (dividendo < 0 && divisor > 0) || (dividendo > 0 && divisor < 0);
        double absDividendo = Math.abs(dividendo);
        double absDivisor = Math.abs(divisor);

        for (; absDividendo >= absDivisor; cociente++) {
            absDividendo -= absDivisor;
        }

        return negativo ? -cociente : cociente;
    }
}