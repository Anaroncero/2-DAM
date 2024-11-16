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
        
        Hilo h1 = new Hilo("ronaldo", 2000);
        Hilo h2 = new Hilo("messi", 3000);
        
        h1.start();
        h2.start();
    }
}
