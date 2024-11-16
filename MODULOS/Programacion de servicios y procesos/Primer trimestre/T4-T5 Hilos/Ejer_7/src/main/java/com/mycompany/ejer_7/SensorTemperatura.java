/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_7;

/**
 *
 * @author Ana
 */
public class SensorTemperatura extends Thread{
    
    int gradosInicio = 20;
    int random;
    int randomSR;
    String[] operacion = {"suma", "resta"}; 
    String operacionActual;
    
            
    public SensorTemperatura(){
    }
    
    
    
    public void run(){
        
        while(true){
            randomSR = (int) (Math.random()*2); //random suma o resta
            random = (int) (Math.random()*3); // random para la variacion de temperatura 0 y 3 grados
            
            operacionActual = operacion[randomSR]; 
            
            if (operacionActual.equals("suma")) {
                gradosInicio += random; //se sume a los grados de inicio el grado random
            } else if (operacionActual.equals("resta")) {
                gradosInicio -= random; //se reste 
            }
            
            // Si los grados se salen de ese rango imprime error
            if(gradosInicio >= 40 || gradosInicio <=0){
            System.out.println("error ha fallado el sensor. Temperatura fuera de rango");
            }
            
            System.out.println("Lectura de temperatura: " + gradosInicio + " grados");
            
            try {
                Thread.sleep(15000); // Espera 15 segundos en cada "lectura de temperatura"
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        
        }
        
       
        
    }
}
