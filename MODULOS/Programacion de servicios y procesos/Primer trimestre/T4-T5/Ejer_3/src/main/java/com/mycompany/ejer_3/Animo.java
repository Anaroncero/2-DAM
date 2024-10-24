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
    
    public Animo(){
    }
    
    @Override
    public void run(){
        
        // Este hilo tampoco se acaba 
        while(tiempoTotal <=30000){
            numAleatorio = (int) (Math.random() * saludos.length);
            System.out.println(saludos[numAleatorio]);
            tiempo = (int) (2000 + Math.random()*3000);
            tiempoTotal += tiempo;
            try{
                sleep(tiempo);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            
        }
    }
   
}