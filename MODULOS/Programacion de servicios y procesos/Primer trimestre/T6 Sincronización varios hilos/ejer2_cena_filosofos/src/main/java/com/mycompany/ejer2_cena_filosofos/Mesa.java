/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer2_cena_filosofos;

/**
 *
 * @author Ana
 */
//Clase monitor
public class Mesa {

    private boolean[] tenedoresDisponibles;

    public Mesa(int numTenedores) {
        this.tenedoresDisponibles = new boolean[numTenedores];

        //Array de 5 booleanos todos a true. 
        //AL empezar todos los tenedores estan disponibles los pongo todos a true
        for (int i = 0; i < numTenedores; i++) {
            this.tenedoresDisponibles[i] = true;
        }
    }

    //SECCIONES CRITICAS. 
    //coger tenedoresDisponibles
    
    
    public synchronized void cogerTenedores(int numFilosofo) { //el filosofo 3.. coge

        int tenedorDer, tenedorIzq;

        //En funcion del filosofo, compruebo los tenedores que le tocaria coger
        tenedorIzq = numFilosofo;
        
        if (numFilosofo == 0) { //el filosofo cero su tenedor de la derecha es la ultima posicion del array
            tenedorDer = 4;
        } else {
            tenedorDer = numFilosofo - 1;
        }

        //Si uno de los tenedoresDisponibles estan ocupados esperamos. Si no lo están se pone en true
        while (tenedoresDisponibles[tenedorIzq] == false || tenedoresDisponibles[tenedorDer] == false) {
            try {
                wait(); //siguen ocupados me vuelvo a esperar
            } catch (InterruptedException ie) {
            }
        }

        //cuando los cojo porque estan libres los cojo yo.
        tenedoresDisponibles[tenedorIzq] = false;
        tenedoresDisponibles[tenedorDer] = false;

        //aqui no se hace un notifyAll nadie espera que los coja, si no que los suelte
    }

    //soltar tenedoresDisponibles
    //al dejar los tenedoresDisponibles se ponen en falso los dos tenedoresDisponibles y notificamos a todos lso rpocesos que estaban parados para que vuelvan a comprobar el estado de los tenedoresDisponibles
    public synchronized void soltarTenedores(int numFilosofo) {

        int tenedorDer, tenedorIzq;
        
        //Comprobarq que tenedores va a soltar 
        tenedorIzq = numFilosofo;
        
        if (numFilosofo == 0) {
            tenedorDer = 4;
        } else {
            tenedorDer = numFilosofo - 1;
        }

        //deja disponibles los tenedores
        tenedoresDisponibles[tenedorIzq] = true;
        tenedoresDisponibles[tenedorDer] = true;

        //Avisa al resto de hilos, (filosofos) de que hay tenedores sueltos
        notifyAll();

    }

}
