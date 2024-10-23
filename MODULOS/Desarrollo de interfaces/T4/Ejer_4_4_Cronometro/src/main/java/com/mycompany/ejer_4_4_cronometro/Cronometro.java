/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_4_4_cronometro;

import static com.mycompany.ejer_4_4_cronometro.ventana.lCronometro;

/**
 *
 * @author Ana
 */
public class Cronometro extends Thread{
    int segundos;
    public void cronometro(){
        this.segundos = 0;
    }
    
    public void run(){
        
        while(true)
            try{
                lCronometro.setText(segundos + "");
                Thread.sleep(1000);
                segundos++;
                
            }catch(InterruptedException ex){
            }
        }
        
    }

