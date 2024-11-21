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

    private String[] materialesDisponibles = new String[2];

    private String[] almacenMateriales = {"cerillas", "tabaco", "papel"};

    //Métodos críticos añadir y quitar productos
    public synchronized void ponerMateriales() {

        //Array ingredientes disponibles y otro array con el almacen de materiales 
        int num1 = (int) ((Math.random()) * almacenMateriales.length);
        int num2;

        //que no se repita los mismos materiales (num Aleatorios)
        do {
            num2 = (int) ((Math.random()) * almacenMateriales.length);
        } while (num1 == num2);

        materialesDisponibles[0] = almacenMateriales[num1];
        materialesDisponibles[1] = almacenMateriales[num2];

        System.out.println("Estanquero coloca el ingrediente: " + materialesDisponibles[0]);
        System.out.println("Estanquero coloca segundo ingrediente: " + materialesDisponibles[1]);

        notifyAll(); //notifico que ha puesto dos ingredientes a los fumadores
    }

   
}

