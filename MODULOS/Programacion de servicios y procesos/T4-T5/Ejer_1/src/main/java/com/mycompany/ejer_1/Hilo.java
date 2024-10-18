/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_1;

/**
 *
 * @author Ana
 */
//Clase que hemos creado Hilos hereda de la clase Thread, convirtiendo cada objeto creado de esta clase en hilos
public class Hilo extends Thread {

    private String nombre;
    private int tiempo;

    //Constructor espera dos parámetros
    public Hilo(String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }

    
    /*Método run(): Se ejecuta cuando en el main llamo a start().
    Una clase que herede de Thread es obligatorio implementar este método. (Equivalente al main del hilo). 
    Esta vinculado al start(). Cuando hago start() lo que hace es llamar al método run() */
    
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Soy el hilo " + nombre + " y voy por la vuelta " + i);

                sleep(tiempo);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
