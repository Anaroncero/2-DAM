/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejer_5;

/**
 *
 * @author Ana
 */

/*
Carrera

Crea una clase llamada Jugador, que tome un nombre por 
parámetro y que realice un bucle del 1 al 10 imprimiendo en 
cada interación la frase "el jugador -nombre- va por el número
`i`".

Entre una interacción y otra, se debe esperar un tiempo
aleatorio entre 1 y 3 segundos.

En el main, crea 5 jugadores y lánzalos al mismo tiempo.

Comprueba quién 'gana la carrera', es decir, quién imprime primero su numero.

 */
public class Ejer_5 {

    public static void main(String[] args) {

        // Creamos hilos 
        Jugador h1 = new Jugador("Rafa");
        Jugador h2 = new Jugador("Antonio");
        Jugador h3 = new Jugador("Bosi");
        Jugador h4 = new Jugador("Marta");
        Jugador h5 = new Jugador("Javi");
        
        // Lanzamos hilos
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        

    }
}
