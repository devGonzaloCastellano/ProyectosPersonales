package Logica;

import javax.swing.JOptionPane;

public class ControlSaldo {

    public static double saldoActual;

    public ControlSaldo() {
        saldoActual = 0;
    }

    public void depositar(double deposito) {
        saldoActual += deposito;
        JOptionPane.showMessageDialog(null, " [Exito] - Acredito nuevo Saldo - ");
    }

    public void retirar(double retiro) {
        if (saldoActual >= retiro) {
            saldoActual -= retiro;
            JOptionPane.showMessageDialog(null, " [Exito] - Retiro su saldo - ");

        } else {
            JOptionPane.showMessageDialog(null, " [ERROR] - Saldo insuficiente - ");
        }
    }

    public double obtenerSaldo() {
        return saldoActual;
    }

}
