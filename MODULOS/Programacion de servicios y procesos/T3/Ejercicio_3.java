package T3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Ejercicio_3 {
    public static void main(String[] args) throws IOException { // Para no tener que hacer try-catch podemos hacer una excepción a todo el main
        
        /* 3. Ejecuta un programa que obtenga el tiempo que tarda 
        tu PC en conectarse a la de Medac. 
        (haciendo un ping en cmd a Medac) */

        /* Anotaciones: cmd ejecuta el comando en segundo plano, no se abre el cmd de forma visual. 
        Para obtener respuesta tenemos que usar FileReader */

        /* Pregunta: ¿¿Cuál es la diferencia entre la clase ProcessBuilder y la clase Process??
        ProcessBuilder lanza el proceso, solo lo lanza. (abre) pero luego no se puede hacer nada con esa app que se abre.
        Process Clase de Java que se utiliza para controlar un proceso después de haber sido lanzado */
        


        try {
            // Ejemplo solo valido para CMD de Windows
            String comando = "ping medac.es"; // o poniendo un comando más concreto(nos ahorramos substring):  ipconfig | findstr /i \"IPv4\"";

            // Lanzar CMD y crear proceso
            ProcessBuilder cmd = new ProcessBuilder("CMD", "/C", comando); // el cmd no se va a abrir por los parámetros
            Process proceso = cmd.start();

            // Capturar la salida del proceso. Con Buffered hacemos que muestre el resultado del cmd en java
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            
           // Leer y mostrar los resultados del comando linea a linea 
            while ((linea = reader.readLine()) != null ) {
                System.out.println(linea);
            } 
            
            
            // Esperar a que el proceso se lance por completo y mostrar código de proceso conocido como exitCode
            int exitCode = proceso.waitFor(); //espera el tiempo que necesite este proceso para enlazarse. Espero a que el proceso termine y me devuelve un código
            System.out.println("Comando terminado con código de salida:" + exitCode);


            // Si solo quiero que me muestre una línea del resultado en concreto:
            /* 
            while ((linea = reader.readLine()) != null ) {
                if (linea.contains("Haciendo ping a")) {
                    System.out.println(linea);
                }
            } 
            */
             

            // Mostrar algo concreto de una linea
            /* while ((linea = reader.readLine()) != null ) {
                if (linea.contains("Haciendo ping a")) {
                    System.out.println(linea.substring(linea.indexOf('[')+1, linea.indexOf(']'))); 
                }
                
            } 
            */

            
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
