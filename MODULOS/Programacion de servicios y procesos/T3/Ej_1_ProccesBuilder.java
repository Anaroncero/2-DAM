package T3;
import java.io.IOException;

public class Ej_1_ProccesBuilder{
    public static void main(String[] args) {

        //ProccesBuilder lanza el proceso, solo lo lanza. (abre) pero luego no se puede hacer nada con esa app que se abre
        
        /* Ejemplo de abrir programas en 
        Windows con ProcessBuilder */
        
        try {
            // Los programas nativos de windows no necesitan ruta

            // Ejecutar la Calculadora de Windows
            ProcessBuilder calculadora = new ProcessBuilder("calc"); // nombre del proceso
            calculadora.start();
            // Esperar un momento para asegurarnos de que la calculadora se abra (necesario cuando abrimo más cosas después)
            Thread.sleep(2000);

            // Ejecutar el Bloc de notas de Windows
            ProcessBuilder notepad = new ProcessBuilder("notepad");
            Thread.sleep(2000);
            notepad.start();

            // Ejecutar Paint Windows 
            ProcessBuilder paint = new ProcessBuilder("mspaint");
            Thread.sleep(2000);
            paint.start();
            

        } catch (Exception e) {
            e.printStackTrace();
            
        }


    }
    
}