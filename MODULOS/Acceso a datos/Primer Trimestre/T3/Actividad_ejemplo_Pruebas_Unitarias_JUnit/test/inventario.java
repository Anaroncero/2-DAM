public class inventario {
    
    private int valor;

    // Constructor inicializa el contador a 0
    public inventario() {
        valor = 0;
    }

    // Método para incrementar el valor del contador en 1
    public void incrementar() {
        valor++;
    }

    // Método para decrementar el valor del contador en 1
    public void decrementar() {
        valor--;
    }

    // Método para obtener el valor actual del contador
    public int getValor() {
        return valor;
    }
}
