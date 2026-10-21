package org.example;

public class Cuenta {
    private double saldo;

    // ... otros métodos existentes (ej. depositar, getSaldo) ...

    // AQUÍ AGREGAS LA NUEVA FUNCIONALIDAD:
    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
        }
    }
}