import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class inventarioTest {
    private inventario inventario;

    @Before
    public void setUp() {
        // Inicializa el contador antes de cada prueba
        inventario = new inventario();
    }

    @Test
    public void testIncrementar() {
        inventario.incrementar();
        assertEquals(1, inventario.getValor()); // Verifica que el contador valga 1
    }

    @Test
    public void testDecrementar() {
        inventario.decrementar();
        assertEquals(-1, inventario.getValor()); // Verifica que el contador valga -1
    }

    @Test
    public void testIncrementarYDecrementar() {
        inventario.incrementar();
        inventario.decrementar();
        assertEquals(2, inventario.getValor()); // Verifica que el contador vuelva a 0
    }
}
