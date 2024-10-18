public class ExcepcionPersonalizada {
    public static void main(String[] args) {
        
        try {
            // Llama al método que puede lanzar una excepción personalizada
            metodoQueLanzaExcepcion();
        } catch (MiExcepcion e) {
            // Captura y maneja la excepción personalizada
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    
    }  

    // Método que lanza la excepción
    public static void metodoQueLanzaExcepcion() throws MiExcepcion {
        throw new MiExcepcion("Esto es una excepción personalizada lanzada en la definición del método");
    }

    // Clase estática que define una excepción personalizada llamada MiExcepcion
    public static class MiExcepcion extends Exception { 
        public MiExcepcion(String mensaje) { 
            // Constructor que recibe un mensaje para la excepción
            super(mensaje);
        }
    }
}
