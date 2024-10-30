/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_3;

/**
 * @author Ana
 */
public class Cronometro extends Thread{
    
    //Atributos
    int tiempo;
    //Constructor
    public Cronometro(){
        this.tiempo = 30; //30 vueltas el bucle
    }
    
    //Metodo run thread
    
    // Este hilo no se acaba hasta que no termine el tiempo
    public void run(){
        for (int i = tiempo; i > 0; i--) { //empieza i en 30 e I se reducirá 1 en cada vuelta
            System.out.println("Te quedan " + i + " segundos");
            try {
                sleep(1000); //entre cada vuelta hay una pausa de 30segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("¡El tiempo ha terminado!");
    }
    
}
