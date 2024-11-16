/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer2_cena_filosofos;

/**
 *
 * @author Ana
 */
//CADA SILOSOFO ES UN HILO (trabajan sumiltaneamente)
public class Filosofo extends Thread {

    Mesa mesa; //meas en la que se sientan
    int numFilosofo; //numero filosofo
    String nombre; //Nombre

    public Filosofo(int numFilosofo, Mesa mesa, String nombre) {
        this.numFilosofo = numFilosofo;
        this.mesa = mesa;
        this.nombre = nombre;
    }

    public void run() {

        while (true) {
            //Todos empiecen pensando para evitar que cojan el mismo tenedor y se rompa el patron de dos comen (lo que debe sceder con esos cubiertos)
            //y tres piensan
            
            //piensa
            piensa();
            //come
            come();
            
        }

    }

    
    public void piensa() {
        //Empieza a pensar
        System.out.print(nombre + " " + numFilosofo + " Estoy pensando \n");
        try { //piensa tiempo aleatorio
            sleep(1000 + ((int) (Math.random() * 5000)));
        } catch (InterruptedException ie) {
        }
    }

    public void come() {
        //Coge tenedores
        mesa.cogerTenedores(this.numFilosofo);
        //Empieza a comer
        System.out.print(nombre + " " + numFilosofo + " Estoy comiendo \n");
        try { //come x tiempo
            sleep((int) (Math.random() * 5000));
        } catch (InterruptedException ie) {
        }
        //suelta tenedores
        mesa.soltarTenedores(this.numFilosofo);
    }

}
