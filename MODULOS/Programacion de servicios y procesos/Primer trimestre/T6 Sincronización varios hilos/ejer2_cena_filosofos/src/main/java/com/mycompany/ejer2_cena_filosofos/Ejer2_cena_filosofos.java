/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer2_cena_filosofos;

/**
 *
 * @author Ana
 */
public class Ejer2_cena_filosofos {

    public static void main(String[] args) {
        
        Mesa m1 = new Mesa(5);

        Filosofo f1 = new Filosofo(0, m1, "Sócrates");
        Filosofo f2 = new Filosofo(1, m1, "Descartes");
        Filosofo f3 = new Filosofo(2, m1, "Platon");
        Filosofo f4 = new Filosofo(3,m1, "Nietzche");
        Filosofo f5 = new Filosofo(4,m1, "Kant");
        
        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
      

        
    }
}
