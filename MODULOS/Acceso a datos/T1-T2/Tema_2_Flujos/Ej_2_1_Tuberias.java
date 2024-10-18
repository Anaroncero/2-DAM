
/* Ejemplo 2.1: Comunicación entre hilos en Java utilizando tuberías

Descripción:
El objetivo de este ejercicio es comprender cómo se pueden utilizar tuberías (PipedInputStream y PipedOutputStream) en Java para permitir la comunicación entre dos hilos. En este ejercicio, se debe crear un programa Java que implemente esta comunicación y que consista en dos hilos: uno que escribe datos en una tubería y otro que los lee y los imprime en la consola.

Instrucciones:
Crea un programa Java que contenga dos hilos: Thread1 y Thread2.

Thread1 debe escribir una cadena de texto en una tubería utilizando PipedOutputStream. La cadena de texto que debes escribir es: "¡Hola, desde el hilo Thread1!".

Thread2 debe leer los datos de la tubería utilizando PipedInputStream y los imprimirá en la consola hasta que alcance el final de la tubería (-1 indica el final). Asegúrate de que Thread2 imprima los datos como caracteres en la consola.

Inicia la ejecución de ambos hilos (Thread1 y Thread2) para que puedan comunicarse a través de la tubería.

El programa debe mostrar en la consola el mensaje que Thread1 escribe en la tubería, de manera que la salida en la consola sea: "¡Hola, desde el hilo Thread1!".

Asegúrate de que el programa maneje excepciones y errores apropiadamente.

Nota: Debes utilizar las clases PipedInputStream, PipedOutputStream o PipedReader, PipedWriter para implementar la comunicación entre los hilos.
 */

import java.io.*;

 
 public class Ej_2_1_Tuberias {
     public static void main(String[] args) {
         
         //Crea un programa Java que contenga dos hilos: Thread1 y Thread2.
         /*La clase PipedInputStream en Java  leer los datos de una tubería (pipe). 
        establecer comunicación entre dos threads a través de una tubería. */
         final PipedInputStream entrada = new PipedInputStream();//leer
         final PipedOutputStream salida = new PipedOutputStream();//escribir
 
         /*conectar la entrada y la salida */
         try {
             entrada.connect(salida); 
 
         } catch (Exception e) {
             e.printStackTrace();
         }
 
        
         /*Thread1 debe escribir una cadena de texto en una tubería utilizando PipedOutputStream. 
         La cadena de texto que debes escribir es: "¡Hola, desde el hilo Thread1!". */
        
         Thread thread1 = new Thread(new Runnable() { //creamos un hilo
             
             public void run(){
 
                 try {
                     salida.write("¡Hola, desde el hilo Thread1!".getBytes());
                     
                 } catch (Exception e) {
                     
                 }
             }
         });
 
        
         /*Thread2 debe leer los datos de la tubería utilizando PipedInputStream 
         y los imprimirá en la consola hasta que alcance el final de la tubería (-1 indica el final). Asegúrate de que Thread2 imprima los datos como caracteres en la consola. */
         Thread thread2 = new Thread(new Runnable() { //creamos otro hilo
             
             public void run(){
 
                 try {
                     
                     int unByte = entrada.read();
                     while (unByte != -1) {
                         System.out.print((char) unByte);
                         unByte = entrada.read();
                     } 
 
 
                 } catch (Exception e) {
                    
                 }
             }
         });
 
         //Inicia la ejecución de ambos hilos para poder comunicarse a través de la tubería.
         thread1.start();
         thread2.start();
 
 
     }
 }