public class ExcepcionesAsociadas {
    public static void main(String[] args) {
        
        // Excepciones asociadas a clases 
        
        try {
            // Intentar dividir por cero, lo que generará una excepción
            int resultado = 10 / 0;

        } catch (ArithmeticException e) {
            // Manejo de la excepción ArithmeticException
            System.out.println("Se ha producido un error de aritmética.");

            // getMessage(): devuelve un mensaje detallado sobre la excepción
            System.out.println("Mensaje: " + e.getMessage());

            // getCause(): devuelve la causa de la excepción
            Throwable causa = e.getCause();
            System.out.println("Causa: " + (causa != null ? causa : "No hay causa disponible."));

            // toString(): devuelve el nombre de la clase y el mensaje
            System.out.println("toString(): " + e.toString());

            // printStackTrace(): imprime la pila de seguimiento
            System.out.println("Pila de seguimiento:");
            e.printStackTrace();

            // getStackTrace(): devuelve el array de la pila
            StackTraceElement[] stackTrace = e.getStackTrace();
            System.out.println("Elementos de la pila:");
            for (StackTraceElement element : stackTrace) {
                System.out.println(element);
            }
        }
    }
}
