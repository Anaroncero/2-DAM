public class NullPointer {
 @SuppressWarnings("null")
public static void main(String[] args) {
    

    // Ejemplo controlar errores nulos

        /* Exception in thread "main" java.lang.NullPointerException: 
        Cannot invoke "String.length()" because "texto" is null
        at NullPointer.main(NullPointer.java:8) */

    
    // si no manejamos error
        /* String texto = null;
        System.out.println(texto.length()); */

    // Manejando el error
        try {
            String texto = null;
            System.out.println(texto.length());
            
        } catch (NullPointerException e) {
            System.out.println("Error, variable nula.");
        }

    


 }   
}
