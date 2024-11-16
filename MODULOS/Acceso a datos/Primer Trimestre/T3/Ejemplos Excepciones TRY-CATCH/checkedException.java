import java.io.FileReader;

public class checkedException {
    public static void main(String[] args) {
        

        // Excepciones con chequeo: Se tienen que manejar si o si, con try catch por ejemplo. 
        
        //  Saldria un error de compialador si no se manejan errores

            /* Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
            FileReader cannot be resolved to a type
            FileReader cannot be resolved to a type
            at checkedException.main(checkedException.java:5)  
            */

        // le falta el try catch (manejar excepciones)

            /* FileReader fichero = new FileReader("archivo.txt"); */

        // te saldria la lamparita del error donde te haría poner el try catch solo 

            try (FileReader fichero = new FileReader("archivo.txt")) {
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        


    }
}
