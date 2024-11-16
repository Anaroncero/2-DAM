public class ArrayIndexOut {
    
    public static void main(String[] args) {
        
        // 1.

            /* Si no manejo los errores me sale este error de compilación:
            *
            * Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 
            * Index 4 out of bounds for length 3
            at Ejemplo_Error_Array.main(Ejemplo_Error_Array.java:6)
            */
        
        
        /* String[] array0 = new String[]{"rafa", "antonio", "marta"};
        System.out.println(array0[4]);
         */

        
        // A si manejariamos el error, y si ocurre el programa continuaría no se rompería
        try {
            String[] array = new String[] { "Mercedes", "Audi", "Jeep" };
            System.out.println(array[4]);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error has intentado imprimir una posición del array errónea. Continue el programa");
        }


        




    }
}
