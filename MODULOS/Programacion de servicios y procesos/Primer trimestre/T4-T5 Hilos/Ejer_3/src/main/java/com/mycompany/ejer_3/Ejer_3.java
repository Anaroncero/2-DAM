/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer_3;

/**
 * @author Ana
 */

/*Crea el juego de adivinar el número, en el que el programa genera un número
aleatorio entre el 0 y el 100 (sin mostrarlo al usuario) y va pidiendo
números al usuario indicándole "mayor" o "menor" hasta que éste consiga
adivinarlo.

Mientras, otro hilo tendrá una marcha atrás, dándole al jugador tan solo 30
segundos para adivinar el número.

Implementa un hilo más encargado de mostrar, en momentos aleatorios, mensajes de 
ánimo al jugador.

(Los hilos son independientes y no se detendrán cuando acabe el juego. Esto
lo dejamos así por ahora, y veremos como hacerlo en el tema siguiente).
*/

public class Ejer_3 {

    public static void main(String[] args) {
       
        //Un hilo es el juego
        //Otro hilo es el conómetro
        //Otro hilo es el mensaje de ánimo
        
        //Crear objetos y lanzar hilos.
       Juego h1 = new Juego();
       Cronometro h2 = new Cronometro();
       Animo s1 = new Animo();
       System.out.println("Juego adivinanza introduce numero 1-50");
       
       s1.start();
       h1.start();
       h2.start();
    }
}
