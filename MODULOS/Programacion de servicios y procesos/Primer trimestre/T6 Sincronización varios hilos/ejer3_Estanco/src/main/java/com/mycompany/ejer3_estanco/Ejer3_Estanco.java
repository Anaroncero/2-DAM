/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer3_estanco;

/**
 *
 * @author Ana
 */
public class Ejer3_Estanco {

    public static void main(String[] args) {
        
        Estanco estanco = new Estanco();
        
        //Creamos a tres fumadores con diferentes ingredientes
        Fumador fumadorPapel = new Fumador("papel", estanco); //Hilo funcionan simulaneamente
        Fumador fumadorTabaco = new Fumador ("tabaco", estanco);
        Fumador fumadorFosforos = new Fumador("cerilla", estanco);
        
        //Creamos el estanquero
         Estanquero estanquero = new Estanquero(estanco); //Hilo funcionan simultáneamente
         
         //Inicializamos los hilos
         fumadorPapel.start();
         fumadorTabaco.start();
         fumadorFosforos.start();
         estanquero.start();
        
        
    }
}
