public class ExcepcionRaizCuadrada {
    public static void main(String[] args) {

        /* Posible caso practico en el examen */
    
        try {
            calcularRaizCuadrada(-5);
        } catch (InvalidRaizCuadrada e) {
            System.out.println("Error " + e.getMessage());
        }
    }


    //Método
    public static void calcularRaizCuadrada(double numero) throws InvalidRaizCuadrada {
        if(numero<=0){
            throw new InvalidRaizCuadrada("No se puede calcular la raíz de un número negativo");

        }else{
            System.out.println("La raíz cuadrada del " + numero + " es: " + Math.sqrt(numero));
        }
    }


    public static class InvalidRaizCuadrada extends Exception { 
        public InvalidRaizCuadrada(String mensaje) {
            // Constructor que recibe un mensaje para la excepción
            super(mensaje);
        }
    }
}
