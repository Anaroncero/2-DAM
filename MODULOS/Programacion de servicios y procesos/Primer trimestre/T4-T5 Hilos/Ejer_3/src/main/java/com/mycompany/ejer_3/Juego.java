/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_3;

/**
 * @author Ana
 */
public class Juego extends Thread {

    //Creo Atributos
    int numAleatorio;
    int numUsuario;

    //Constructor
    public Juego() {
        this.numAleatorio = (int) (Math.random() * 51);
    }

    //Metodo run Thread
    public void run() {
        
        // Este hilo se acaba cuando no acierto el número
        while (true) {
            int numUsuario = Integer.parseInt(System.console().readLine("Introduce un numero: "));
            if (numUsuario > numAleatorio) {
                System.out.println("Busca u  numero más pequeño");
            } else if (numUsuario < numAleatorio) {
                System.out.println("Busca un numero más grande");
            } else {
                System.out.println("Acertaste!");
                break;
            }
        }
    }

}
