/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer3_estanco;

/**
 *
 * @author Ana
 */
public class Fumador extends Thread {

    //Atributos
    private String miIngrediente;
    private int numIngrediente;
    private Estanco estanco;


    //Constructor
    public Fumador(String miIngrediente, Estanco estanco) {
        this.miIngrediente=miIngrediente;
        if(miIngrediente.equals("papel")){
            this.numIngrediente=0;
        } else if(miIngrediente.equals("tabaco")){
            this.numIngrediente=1;
        } else {
            this.numIngrediente=2;
        }
        this.estanco = estanco;
    }


    public void run() {
        while (true) {

            estanco.cogerIngredientes(this.numIngrediente);
            System.out.println("Fumador con " + miIngrediente + " está fumando.");
            try {
                Thread.sleep(3000+(int)(Math.random()*3001)); // Simula el tiempo que tarda en fumar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Fumador con " + miIngrediente + " deja de fumar, esperando ingredientes.");

        }
    }
}



