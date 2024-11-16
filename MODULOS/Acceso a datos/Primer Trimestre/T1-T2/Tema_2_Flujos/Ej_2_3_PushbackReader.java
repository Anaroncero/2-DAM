/* Ejemplo 2.3: Manipulación de Flujos de Entrada con PushbackReader

Objetivo:
Aprender a utilizar la clase PushbackReader en Java para leer caracteres de un archivo y devolverlos al flujo para ser leídos nuevamente. 
Esta práctica permitirá entender cómo funcionan los flujos de entrada 
con la posibilidad de "desempujar" caracteres para volver a procesarlos.

Instrucciones:
Crea un programa en Java que utilice la clase PushbackReader para leer el contenido de un archivo.
Lee cada carácter del archivo, imprímelo, y utiliza la funcionalidad de "desempujar" el carácter para leerlo de nuevo.
Asegúrate de que los caracteres se leen e imprimen dos veces utilizando la función unread() de PushbackReader.
Sigue los pasos detallados en el temario. */

import java.io.*;

public class Ej_2_3_PushbackReader {
    
    public static void main(String[] args) {
        String rutaArchivo = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\T1-T2\\Tema_2_Flujos\\texto2_3.txt"; 

        try (PushbackReader reader = new PushbackReader(new FileReader(rutaArchivo))) {
            int caracter;
            while ((caracter = reader.read()) != -1) {
                // Imprimir el carácter leído
                System.out.print((char) caracter);
                
                // "Desempujar" el carácter para leerlo nuevamente
                reader.unread(caracter);
                
                // Leer nuevamente el carácter
                caracter = reader.read();
                System.out.print((char) caracter); // Imprimir de nuevo el carácter
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

