/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer_1;

/**
 *
 * @author Ana
 */
public class Ejer_1 {

    public static void main(String[] args) {
        
        /*Creamos dos hilos de la clase Hilos que hemos creado*/
        /*Estamos lanzando los dos hilos a la vez, los dos estan teniendo el mismo tiempo, 
        por lo tanto estamos pidiendo que se ejecuten a la vez. El sistema operativo se encarga del orden*/
        
        Hilo hilo1 = new Hilo("hilo1", 1000); //cada segundo 1000ms
        Hilo hilo2 = new Hilo("hilo2", 1000);
        
        /*Si queremos crear otro hilo que hace lo mismo creamos otro objeto de esa misma clase.
        Pero si queremos crear un hilo que haga otra cosa tendremos que crear otra clase con otro tipo de hilos*/
        hilo1.start();
        hilo2.start();
    }
}
