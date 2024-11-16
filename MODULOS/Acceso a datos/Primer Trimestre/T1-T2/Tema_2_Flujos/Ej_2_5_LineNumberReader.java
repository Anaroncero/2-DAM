/* Ejemplo 2.5: Lectura de Archivos con LineNumberReader en Java
Objetivo:
Aprender a utilizar la clase LineNumberReader en Java para leer el contenido de un archivo 
línea por línea, mostrando el número de cada línea junto con su contenido. 
Esta práctica permitirá a los estudiantes trabajar con la manipulación de archivos y 
el control de líneas utilizando la clase LineNumberReader.

Instrucciones:
Crea un programa en Java que utilice la clase LineNumberReader para leer un archivo llamado entrada.txt.
Para cada línea del archivo, muestra el número de línea y el contenido correspondiente.
Asegúrate de cerrar los recursos después de la lectura del archivo. */

import java.io.LineNumberReader;
import java.io.*;

public class Ej_2_5_LineNumberReader {

    public static void main(String[] args) {
        
        //Leer por lineas
        try {
            LineNumberReader lnr = new LineNumberReader(new FileReader("Tema_2_Flujos/datosE5.txt"));
            String line = lnr.readLine();

            while(line != null){
                System.out.println("Contenido de la linea nº: " + lnr.getLineNumber());
                System.out.println(line);
                line = lnr.readLine();
            }
            lnr.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
