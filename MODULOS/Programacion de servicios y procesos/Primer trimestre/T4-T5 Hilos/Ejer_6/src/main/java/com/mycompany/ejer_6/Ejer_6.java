/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejer_6;

/**
 *
 * @author Ana
 */

/*
Programación concurrente para mejorar la eficiencia.

Cuando tenemos que hacer en programación operaciones matemáticas muy pasadas,
uan buena estrategia utilizada a veces es repartir la operación a varios hilos. 
Vamos a hacer una simulación de esto para entenderlo mejor (aunque nuestra cantidad 
de datos no sea tan grande como para que realmente mejore la eficiencia, pero sí es 
un ejemplo de cómo se haría a una mayor escala).

Genera un array de 1000 posiciones y rellénalo con números aleatorios
entre el 0 y el 100. Ahora, calcula la media de todos los números del array.

Para agilizar la operación, crea 4 hilos y manda 250 números a cada hilo. 
Cada hilo calculará la media de sus números. Cuando los 4 hilos hayan terminado, 
haz la media de los 4 resultados.
 */
public class Ejer_6 {

    public static void main(String[] args) {

        // Creo variables 
        int[] numeros = new int[1000]; //array de 1000 posiciones
        int numAleatorio;
        int suma = 0;
        int resultado;

        // For introduce numero aleatorios en el array
        for (int i = 0; i < numeros.length; i++) { //recorre el array
            numeros[i] = (int) (Math.random() * 100); // Meter los números en el array
        }
       
        
        // Creamos hilos, le pasamos el array 
        Hilo h1 = new Hilo(numeros, 0, 249); //le paso el array donde estan los números y que guarde 249 primeros numeros de array
        Hilo h2 = new Hilo(numeros, 250, 499);
        Hilo h3 = new Hilo(numeros, 500,  799);
        Hilo h4 = new Hilo(numeros, 800, 999 );
        
        
        // Lanzamos hilos
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        
        
        //Tiempo para que realice la suma 
        try{
            Thread.sleep(1000); 
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        resultado = (h1.suma + h2.suma + h3.suma + h4.suma) /1000; 
        /* esto funciona porque la variable suma de la clase Ejer_6 esta publica 
        tambien se podria hacer con un metodo get que me lo devuelva*/
        
        System.out.println("La media de los 4 hilos y sus numeros es de:  "  + resultado);
    }
}
