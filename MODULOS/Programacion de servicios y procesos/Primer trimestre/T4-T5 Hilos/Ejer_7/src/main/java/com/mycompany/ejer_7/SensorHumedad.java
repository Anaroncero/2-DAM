/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_7;

/**
 *
 * @author Dani Profesor
 */
public class SensorHumedad extends Thread {

    int valor;
    int variacion;

    public SensorHumedad() {
        this.valor = 50;
        this.variacion = 0;
    }

    public void run() {

        while (true) {
            variacion = -5 + (int) (Math.random() * 11); //variacion para evitar hacer random de suma o resta
            valor += variacion;

            if (valor > 0 && valor < 100) {
                System.out.println("Sensor Humedad: " + valor + "%");
            } else {
                System.out.println("Sensor fuera de rango");
            }

            try {
                sleep(22000); //22segundos 22000ms
            } catch (InterruptedException e) {

            }
        }
    }

}
