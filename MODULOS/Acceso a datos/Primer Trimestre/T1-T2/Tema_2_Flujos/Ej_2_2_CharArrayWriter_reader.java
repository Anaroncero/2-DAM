/* Ejemplo 2.2: Manipulación de Texto con CharArrayWriter y CharArrayReader

Objetivo:
Aprender a usar las clases CharArrayWriter y CharArrayReader en Java para escribir, modificar, y leer datos de texto en memoria. 
El objetivo es trabajar con flujos de caracteres sin utilizar archivos, simulando operaciones de entrada y salida.

Instrucciones:
Crea un programa en Java que utilice las clases CharArrayWriter y CharArrayReader.
Escribe una cadena de texto en el CharArrayWriter, conviértela a un array de caracteres y modifícala. Por ejemplo, escribe la cadena "Hola amigo",
 modifica el array cambiando "amigo" por "amiga". Deberás cambiar el carácter en la posición 9 del array ('o') por 'a'.
Usa el CharArrayReader para leer los caracteres modificados y mostrar el resultado en pantalla. */

import java.io.CharArrayReader;
import java.io.CharArrayWriter;

public class Ej_2_2_CharArrayWriter_reader {
    public static void main(String[] args) {

        // Crear un CharArrayWriter y escribir la cadena "Hola amigo"
        CharArrayWriter writer = new CharArrayWriter();

        //Escribir
        try {
            writer.write("Hola amigo");
        } catch (Exception e) {
            
        }

        // Convertir el contenido de CharArrayWriter a un array de caracteres
        char[] caracteres = writer.toCharArray();

        // Modificar el array cambiando 'o' por 'a' en la posición 9
        caracteres[9] = 'a'; // Cambiamos 'o' por 'a'

        // Crear un CharArrayReader para leer los caracteres modificados
        CharArrayReader reader = new CharArrayReader(caracteres);

        // Leer y mostrar el resultado en pantalla
        int data = 0;
        try {
            data = reader.read();
            while (data != -1) {
                System.out.print((char) data); // Mostrar cada carácter
                data = reader.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Cerrar los streams
            try {
                reader.close();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

