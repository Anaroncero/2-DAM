/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_6;

/**
 *
 * @author Ana
 */
public class Hilo extends Thread {

    int[] array;
    int minIndex, maxIndex;
    public int suma = 0;
    
    // Constructor
    public Hilo(int[] array, int minIndex, int maxIndex) {
        this.array = array;
        this.minIndex = minIndex;
        this.maxIndex = maxIndex;
    }

    // Método Thread
    public void run() {
        for(int i = minIndex; i< maxIndex; i++){
            suma += array[i]; //se suma las posiciones del array desde la posicion inicial a la final indicada
        }
        
        
        
    }

}
