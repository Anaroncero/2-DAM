import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CuentaBancariaTest {
        
    private CuentaBancaria cuenta;

    @Before
    public void setUp() {
        // Este método se ejecuta antes de cada prueba.
        cuenta = new CuentaBancaria(100); // Saldo inicial de 100
    }

    @After
    public void tearDown() {
        // Este método se ejecuta después de cada prueba.
        cuenta.setSaldo(200); // Restablecer el saldo a 100 después de cada prueba
    }

    @Test
    public void testDepositar() {
        cuenta.depositar(50);
        assertEquals(150, cuenta.getSaldo(),0.001);
    }

    @Test
    public void testRetirar() {
        cuenta.retirar(30);
        assertEquals(60, cuenta.getSaldo(),0.001);
    }
}
