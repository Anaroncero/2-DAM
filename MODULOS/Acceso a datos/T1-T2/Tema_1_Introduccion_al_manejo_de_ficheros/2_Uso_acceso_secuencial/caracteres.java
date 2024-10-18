/* 
 * Ejercicio 2: Uso de acceso secuencial (Caracteres):

 * Este ejercicio tiene como objetivo que los estudiantes practiquen el acceso secuencial a caracteres en Java 
 utilizando las clases FileReader y FileWriter.  Se leerá un archivo de texto existente en forma de caracteres 
 y se mostrará en la consola. Luego, se escribirá una nueva cadena de caracteres en el mismo archivo o en otro diferente. 

 * Hemos visto dos formas de acceso secuencial, la elección entre FileReader y FileInputStream depende de si 
estás trabajando con archivos de texto o archivos binarios. Si deseas leer y procesar texto, FileReader es 
más adecuado ya que simplifica la lectura de caracteres. Si estás trabajando con datos binarios o necesitas 
un mayor control sobre la lectura de bytes, FileInputStream es la elección adecuada.
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class caracteres {

    public static void main(String[] args) {

        //Ruta del archivo
        String ruta = ".//2_Uso_acceso_secuencial//Ejercicio2.txt";

        // 1. Verificar si el archivo existe
        File archivo = new File(ruta);
        boolean archivoExiste = archivo.exists();

        if(archivoExiste = false){//!archivoExiste
            System.out.println("El fichero no existe");
        }else{
            System.out.println("El fichero existe");
        }

        // 2.Escribir 
        try {
            
            // Crear flujos
            FileWriter fw = new FileWriter(ruta, true); //true para cada vez que ejecute se añada y escriba despues
            BufferedWriter bw = new BufferedWriter(fw);

            // Escribir lineas
            bw.write("\nHola mundo soy Ana!\n");
            bw.write("Anita. \n");
            System.out.println("Archivo escrito");
            
            // cerrar
            bw.close();


        } catch (FileNotFoundException fnfe) {
            System.out.println("No se ha encontrado");
        }catch (IOException ioe) {
            System.out.println("No se ha podido escribir");
        }catch (Exception e) {
            System.out.println("Error");
        }
        
        
        // 3. Leer archivo
        String path = ".//2_Uso_acceso_secuencial//Ejercicio2.txt";
        String pathEscritura = ".//2_Uso_acceso_secuencial//Ejercicio2w.txt";

        //FileReader abrir el archivo en modo lectura
        try {
            FileReader lector = new FileReader(path);
            int data;

            while((data = lector.read()) != -1){ //-1 final del fichero
                System.out.print((char)data + " ");
            }


        } catch (IOException e) {
            System.err.println("Error al leer el fichero" + e.getMessage());
            // TODO: handle exception
            e.printStackTrace();
        }

    }
    
}
