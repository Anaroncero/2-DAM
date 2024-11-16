/* 
 * Ejercicio 3: Uso de acceso secuencial (Bytes):

 * Este ejercicio tiene como objetivo que los estudiantes practiquen el acceso secuencial 
 * a bytes en Java y comprendan la diferencia entre el manejo de bytes y caracteres en la 
 * lectura y escritura de archivos. Se leerá un archivo de texto en forma de bytes (FileInputStream) 
 * y se mostrará en la consola como caracteres. Luego, se escribirá una nueva cadena en el mismo archivo 
 * o en otro diferente en formato de array de bytes (FileOutputStream).
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class bytes {

    public static void main(String[] args) {
        String path = ".//2_Uso_acceso_secuencial//Ejercicio3.txt";
        String pathEscritura = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_1_Introduccion_al_manejo_de_ficheros\\2_Uso_acceso_secuencial\\Ejercicio3w.txt";

        Charset charsetPredeterminado = Charset.defaultCharset();
        System.out.println("La codificación del sistema es: " + charsetPredeterminado.name());

        // 1. Lectura de archivo en forma de bytes
        try (InputStreamReader entrada = new InputStreamReader(new FileInputStream(path), "UTF-8")) {
            int byteLeido;

            while ((byteLeido = entrada.read()) != -1) {
                System.out.print((char) byteLeido); // mostrar y convertir el byte leído a carácter
            }
            System.out.println();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());

        }


        // 2. Escritura de una nueva cadena en otro archivo
        String cadenaAEscribir = "Hola, esto es una cadena de prueba !!";
        try (FileOutputStream escritura = new FileOutputStream(pathEscritura)) {
            byte[] bytesAEscribir = cadenaAEscribir.getBytes();
            escritura.write(bytesAEscribir);
            System.out.println("Cadena escrita en el archivo de salida");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }



        // Cadena en el mismo archivo o en otro diferente en formato de array de bytes (FileOutputStream).
        // 3. Conversion contenido del txt a bytes
        String cadena = "Héllo world!";
        try {
            // Conversion array a bytes
            byte[] arrayBytes = cadena.getBytes("UTF-8");
            FileOutputStream output = new FileOutputStream(pathEscritura); 
            
            // mostrar cada byte
            System.out.println("Bytes de la cadena en UTF-8");

            // mostrar el byte en formato hexadecimal para mejor visibilidad
            for (byte b: arrayBytes){
                
                System.out.printf("0x%02X", b);
            }
            System.out.println("Longitud de la cadena: " + cadena.length());
            System.out.println("Cantidad de  bytes en UTF-8: " + arrayBytes.length);

            output.write(arrayBytes);
            output.close();
            System.out.println("Fichero escrito");

        } catch (Exception e) {
            
        }

    }

}