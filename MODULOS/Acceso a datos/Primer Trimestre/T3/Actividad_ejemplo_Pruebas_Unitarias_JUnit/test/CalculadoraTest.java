import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class CalculadoraTest {
    private int numero;
    private int resultado = 0;

    @Before
    public void setUp() {
        // Este método se ejecuta antes de cada prueba.
        numero = 5;
    }

    @After
    public void tearDown() {
        // Este método se ejecuta después de cada prueba.
        resultado = 20;
    }

    @Test
    public void testDuplicarNumero() {
        resultado = numero * 2;
        assertEquals(10, resultado);
    }

    @Test
    public void testDuplicarNumero1() {
        resultado = numero * 2;
        assertEquals(9, resultado);
    }
}