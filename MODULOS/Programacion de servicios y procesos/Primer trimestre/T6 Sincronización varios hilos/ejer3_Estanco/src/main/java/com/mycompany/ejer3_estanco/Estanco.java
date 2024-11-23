/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer3_estanco;

/**
 *
 * @author Ana
 *
 */
public class Estanco { //Monitor

    private boolean hayIngredientes = false; //bandera
    private String[] ingredientes = {"papel", "tabaco", "cerilla"};
    private int ingredienteAcoger1, ingredienteAcoger2;
    private int ingredienteGenerado1, ingredienteGenerado2;

    //Métodos críticos añadir y quitar productos
    public synchronized void colocarIngredientes() {
        
        while (hayIngredientes) {
            try {
                wait(); // Espera a que los fumadores tomen los ingredientes y avisen
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Coloca los ingredientes aleatoriamente
        ingredienteGenerado1 = (int)(Math.random()*3); // 0: papel, 1: tabaco, 2: cerillas
        do{
            ingredienteGenerado2 = (int)(Math.random()*3); // 0: papel, 1: tabaco, 2: cerillas
        }while(ingredienteGenerado1==ingredienteGenerado2);
        
        System.out.println("Estanquero coloca el ingrediente: " + ingredientes[ingredienteGenerado1]);
        System.out.println("Estanquero coloca el ingrediente: " + ingredientes[ingredienteGenerado2]);

        hayIngredientes = true;
        notifyAll(); // Despierta a los fumadores
    }



    public synchronized void cogerIngredientes(int ingredienteFumador) {
        
        //Compruebo qué ingredientes me tocarían coger
        if (ingredienteFumador==0){
            ingredienteAcoger1=1;
            ingredienteAcoger2=2;
        } else if(ingredienteFumador==1){
            ingredienteAcoger1=0;
            ingredienteAcoger2=2;
        } else{
            ingredienteAcoger1=0;
            ingredienteAcoger2=1;
        }


        //Espero si no hay ingredientes en el mostrador
        while (!hayIngredientes || ((ingredienteGenerado1 == ingredienteFumador)
        || (ingredienteGenerado2 == ingredienteFumador))) {

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        hayIngredientes=false;
        
        notifyAll(); // Despierta al estanquero
    }
}