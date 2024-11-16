public class noChequedException {
    public static void main(String[] args) {

        // Excepción sin chequeo
        // no te sale la "lamparita o icono de error, tienes que hacer el try catch
        // manual"

            /*
            * int dividiendo = 10;
            * int divisor = 0;
            * int resultado = dividiendo / divisor;
            * System.out.println(resultado);
            */

        // la forma de controlar el error y que el programa se ejecutase es manejar los
        // errores con try-catch

            try {
                int dividiendo = 10;
                int divisor = 0;
                int resultado = dividiendo / divisor;
                System.out.println(resultado);

            } catch (ArithmeticException e) {
                System.out.println("error," + e.getMessage()); 
            }

    }
}
