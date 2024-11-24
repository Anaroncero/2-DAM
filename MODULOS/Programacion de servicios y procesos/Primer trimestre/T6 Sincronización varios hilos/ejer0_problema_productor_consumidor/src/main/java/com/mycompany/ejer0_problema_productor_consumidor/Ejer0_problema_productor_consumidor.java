/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer0_problema_productor_consumidor;

/**
 *
 * @author Ana
 */



public class Ejer0_problema_productor_consumidor {

    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Pepe");
        Cliente cliente2 = new Cliente("Ivan");
        Cliente cliente3 = new Cliente("Marta");
        
        Trabajador t1 = new Trabajador("Trabajador 1");
        Trabajador t2 = new Trabajador("Trabajador 2");
        
        cliente1.start();
        cliente2.start();
        cliente3.start();
        
        t1.start();
        t2.start();



    }
}
