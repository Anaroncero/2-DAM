/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer3_estanco;

/**
 *
 * @author Ana
 */
public class Estanquero extends Thread {

    //Atributos
    private Estanco estanco;

    //Constructor
    public Estanquero(Estanco estanco) {
        this.estanco = estanco;
    }

    public void run() {
        while (true) {
            //Pone materiales
            estanco.ponerMateriales();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           
        }
    }
}
