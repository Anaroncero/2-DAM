/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer_3;

/**
 * @author Ana
 */

/*Juego en el que la máquina genera un número aleatorio (1-100) y el usuario lo tiene que adivinar

El programa va mandando mensajes de "busca un num superior" o "busca un num inferior".

Se hacen dos hilos. Uno para el juego y otro para el cronómetro.

El cronómetro es de 30s.

Cuando el usuario acierta, le da la enhorabuena y finaliza el programa.
*/

public class Ejer_3 {

    public static void main(String[] args) {
       
        //Un hilo es el juego
        //Otro hilo es el conómetro
        
        //Crear objetos y lanzar hilos.
       Juego h1 = new Juego();
       Cronometro h2 = new Cronometro();
       
       h1.start();
       h2.start();
    }
}
