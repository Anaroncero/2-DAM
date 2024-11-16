public class CuentaBancaria {
    
    
    private double saldo;

    // Constructor: Inicializa la cuenta con un saldo inicial
    public CuentaBancaria(double saldoInicial) {
        saldo = saldoInicial;
    }

    // Getter: Devuelve el saldo actual de la cuenta
    public double getSaldo() {
        return saldo;
    }

    // Setter: Establece un nuevo saldo en la cuenta
    public void setSaldo(double nuevoSaldo) {
        saldo = nuevoSaldo;
    }

    // Método para depositar dinero en la cuenta
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
        }
    }

     // Método para retirar dinero de la cuenta
    public void retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
        }
    }
}