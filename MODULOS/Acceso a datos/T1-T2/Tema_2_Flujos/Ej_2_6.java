
import java.io.*;

/* Ejemplo 2.6: Extracción de datos usando clases de análisis para flujos de datos

Objetivo: El objetivo de esta actividad es que los estudiantes practiquen el análisis de flujo de datos en Java 
utilizando las clases vistas hasta ahora ( LineNumberReader, StreamTokenizer y PushbackReader, etc). En este ejercicio, 
analizarán un archivo de texto y contarán cuántas palabras y cuántos números hay en cada línea del archivo.

Instrucciones:

   1. Desde un archivo de texto llamado "datosE6.txt" que contiene líneas con una combinación de palabras y números. Por ejemplo:

   Hola 123 Mundo
   Prueba 45.67 de texto
   12345

   2. Cuenta cuántas palabras y cuántos números hay en cada línea. Muestra el resultado en la terminal con el siguiente formato de ejemplo:
   Línea 1: Hola 123 Mundo 
   Palabras: 2, Números: 1
   Línea 2: Prueba 45.67 de texto 
   Palabras: 3, Números: 1
   Línea 3: 12345 
   Palabras: 0, Números: 1
 */

import java.io.LineNumberReader;

public class Ejercicio_2_6 {
    
  public static void main(String[] args) {

    //Variables
      String archivo = "G:\\Mi unidad\\2º-DAM\\MODULOS\\Acceso a datos\\Tema_2_Flujos\\datosE6.txt";
      String linea;

      //Bucle leer linea por linea
      try (LineNumberReader lineReader = new LineNumberReader(new FileReader(archivo))) {
          
          while ((linea = lineReader.readLine()) != null) {
              contarPalabrasYNumeros(linea, lineReader.getLineNumber()); //metodo dnde introducimos la linea
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
  }

  //Método contar palabras
  private static void contarPalabrasYNumeros(String linea, int numeroLinea) {
      StringReader stringReader = new StringReader(linea);
      StreamTokenizer tokenizer = new StreamTokenizer(stringReader);

      int palabras = 0;
      int numeros = 0;

      try {
          while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
              if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                  palabras++;
              } else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                  numeros++;
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }

      // Imprimir el resultado
      System.out.println("Línea " + numeroLinea + ": " + linea);
      System.out.println("Palabras: " + palabras + ", Números: " + numeros);
  }
}

