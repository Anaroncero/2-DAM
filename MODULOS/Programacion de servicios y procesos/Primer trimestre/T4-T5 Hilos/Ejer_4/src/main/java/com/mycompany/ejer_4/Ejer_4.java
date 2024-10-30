/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejer_4;

import java.util.Scanner;

/**
 *
 * @author Ana
 */

/* Crea una clase encargada de recibir una palabra por parámetro e 
imprimirla 100 veces.

Crea 3 hilos con 3 objetos de dicha clase ejecutándose al 
mismo tiempo, pero cada uno con una palabra distinta.
Comprueba el orden en el que se imprimen los elementos.

 */
public class Ejer_4 {

    public static void main(String[] args) {

        // Creo variables
        String p1 = "macedonia";
        String p2 = "yogurt";
        String p3 = "manzana";

        // Creo los objetos (Hilos)
        Palabra h1 = new Palabra(p1);
        Palabra h2 = new Palabra(p2);
        Palabra h3 = new Palabra(p3);

        
        try {

            h1.start();
            h1.join();//Hasta que no acabe el hilo h1 no se ejecutan el resto de hilos
            //waitFor, no espera a que acabe el hilo espera hasta que le llega el aviso
            h1.setPriority(Thread.NORM_PRIORITY); //prioridad de 5 valores (1-10)
            
            h2.start();
            h2.setPriority(Thread.MAX_PRIORITY); // Máxima imporancia pero luego el procesador hace lo que quiereq2
                    
            h3.start();
            h3.setPriority(Thread.MIN_PRIORITY); 

        } catch (Exception e) { // InterruptedExceptio detecta el fallo de interrupción de un hilo que nos e ha podido ejecutar
            e.printStackTrace();
        }
        
        
        
        /*
        // El método join obliga a utilizar excepciones
        try {

            // Inicializo los hilos
            h1.start();
            h1.join();//Hasta que no acabe el hilo h1 no se ejecutan el resto de hilos
            //waitFor, no espera a que acabe el hilo espera hasta que le llega el aviso
            h2.start();
            h3.start();

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        */
    }
}
