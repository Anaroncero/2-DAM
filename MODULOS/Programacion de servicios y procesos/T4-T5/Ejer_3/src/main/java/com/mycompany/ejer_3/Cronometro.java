/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_3;

/**
 *
 * @author Ana
 */
public class Cronometro extends Thread{
    
    //Atributos
    int tiempo;
    //Constructor
    public Cronometro(){
        this.tiempo = 30;
    }
    
    //Metodo run thread
    public void run(){
        for (int i = tiempo; i > 0; i--) {
            System.out.println("Te quedan " + i + " segundos");
            try {
                sleep(1000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("¡El tiempo ha terminado!");
    }
    
}
