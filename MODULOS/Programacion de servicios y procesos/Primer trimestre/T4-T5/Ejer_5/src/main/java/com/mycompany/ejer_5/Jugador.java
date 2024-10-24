/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_5;

/**
 *
 * @author Ana
 */
public class Jugador extends Thread{
    
    String nombre;
    int tiempo = 0;
    
    public Jugador(String nombre){
        this.nombre = nombre;
    }
    

    public void run(){
        for(int i = 0; i<10; i++){
            tiempo = (int) (1000 + (Math.random()* 2001)); // empezar desde 1000, dentor del for para que en cada vuelta genere un número distinto
            System.out.println("El jugador: " + nombre + " va por el número: " + i);
            try{
                sleep(tiempo); //me espero el tiempo que he generado y vuelta a emprezar
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(nombre + " ha terminado! ");
        
    }
    
}
