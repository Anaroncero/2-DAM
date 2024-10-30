/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_3;

/**
 *
 * @author Ana
 */
public class Animo extends Thread{
    
    String[] saludos ={"Ya casi!", "Tu puedes!!", "Vas a conseguirlo!!"};
    int numAleatorio;
    int tiempo;
    int tiempoTotal = 0;
    
    public Animo(){ //no recibe nada el constructor
    }
    
    @Override
    public void run(){
        
        // Este hilo tampoco se acaba 
        while(tiempoTotal <=30000){
            numAleatorio = (int) (Math.random() * saludos.length); //selecciona un saluda aleatorio
            System.out.println(saludos[numAleatorio]); //lo imprime
            tiempo = (int) (2000 + Math.random()*3000); //genera un tiempo aleatorio entre 2 y 5 segundos
            tiempoTotal += tiempo; //se suma el teimpo aleatorio al tiempo total si el tiempo total es mayor a 30000 se para el bucle
            try{
                sleep(tiempo);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
   
}