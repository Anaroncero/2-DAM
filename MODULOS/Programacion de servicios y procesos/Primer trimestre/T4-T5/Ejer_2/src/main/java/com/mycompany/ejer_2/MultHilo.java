/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_2;

/**
 *
 * @author Ana
 */
public class MultHilo extends Thread{
    
    //Atributos
    private double num1;
    private double num2;
    private double resultado;
    //Constructor
    public MultHilo(double num1, double num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    
    //Metodo run de Thread
    public void run(){
        resultado = num1 * num2;
        System.out.println("\nEl resultado del hilo multiplicación: " + resultado);
    }
    
}
