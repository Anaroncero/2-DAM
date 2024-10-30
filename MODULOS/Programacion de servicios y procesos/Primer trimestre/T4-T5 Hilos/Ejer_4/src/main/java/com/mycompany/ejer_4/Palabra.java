/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_4;

/**
 *
 * @author Ana
 */
public class Palabra extends Thread{
    
    String palabra;
    
    // Constructor
    public Palabra(String palabra){
        this.palabra = palabra;
    }
    
    // Método run para los hilos
    public void run(){
        // For hasta 100 para que imprima 100 palabras de cada una
        for(int i = 0; i<100; i++){
            System.out.println(palabra);
        }
        
    }
    
}
