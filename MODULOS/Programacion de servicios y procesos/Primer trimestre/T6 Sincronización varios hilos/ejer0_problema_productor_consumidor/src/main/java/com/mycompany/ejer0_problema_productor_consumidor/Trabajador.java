/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer0_problema_productor_consumidor;

/**
 *
 * @author Ana
 */
public class Trabajador extends Thread {

    private String nombreTrabajador = "";
    
    
    public Trabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep((1 + (int) (Math.random() * 5)) * 1000); //entre 1 y 5 segundos. Genero random 0 y 4.99 con int quito decimales 0-4. al sumarle 1. tengo entre 1 y 5. necesito ms multiplico por 1000 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Almacen.delete_producto();
        }

    }

}
