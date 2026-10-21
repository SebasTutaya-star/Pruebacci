package pe.edu.unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    @Test
    void retirarConSaldoSuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(200);
        assertEquals(800, cuenta.getSaldo());
    }

    @Test
    void retirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(500);
        assertEquals(100, cuenta.getSaldo());
    }

    @Test
    void retirarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(-200);
        assertEquals(1000, cuenta.getSaldo());
    }

    @Test
    void depositarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.getSaldo());
    }

    @Test
    void transferirDineroExitoso() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, 200);
        assertEquals(800, origen.getSaldo());
        assertEquals(700, destino.getSaldo());
    }

    @Test
    void transferirSaldoInsuficiente() {
        CuentaBancaria origen = new CuentaBancaria(100);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, 300);
        assertEquals(100, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void transferirMontoNegativo() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);
        origen.transferir(destino, -50);
        assertEquals(1000, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void transferenciaExitosa() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);

        origen.transferir(destino, 200);

        assertEquals(800, origen.getSaldo());
        assertEquals(700, destino.getSaldo());
    }
    @Test
    void transferenciaSaldoInsuficiente() {
        CuentaBancaria origen = new CuentaBancaria(100);
        CuentaBancaria destino = new CuentaBancaria(500);

        origen.transferir(destino, 200);

        assertEquals(100, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void transferenciaMontoNegativo() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);

        origen.transferir(destino, -200);

        assertEquals(1000, origen.getSaldo());
        assertEquals(500, destino.getSaldo());
    }

    @Test
    void transferenciaDestinoNulo() {
        CuentaBancaria origen = new CuentaBancaria(1000);

        origen.transferir(null, 200);

        assertEquals(1000, origen.getSaldo());
    }
}