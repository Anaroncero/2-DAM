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
    String material;
    Estanco estanco;
    int numMaterial;

    //Constructor
    public Fumador(String material, Estanco estanco) {
        this.material = material;
        this.estanco = estanco;
        
    }

    public void run() {
        while (true) {
            //coger materiales
            estanco.cogerMateriales(); //indicandole cual tengo 
            //Fumar
            fumando();
        }

    }

    public void fumando() {
        System.out.print("Estoy fumando \n");
        try { //fuma x tiempo
            sleep((int) (Math.random() * 5000));
        } catch (InterruptedException ie) {
        }

    }

}
