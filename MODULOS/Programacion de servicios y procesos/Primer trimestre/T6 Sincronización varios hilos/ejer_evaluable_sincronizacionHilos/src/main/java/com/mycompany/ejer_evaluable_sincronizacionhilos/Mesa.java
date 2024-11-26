/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_evaluable_sincronizacionhilos;

/**
 *
 * @author Ana
 */
public class Mesa { //Monitor. La clase que se encarga de sincronizar los hilos. Contiene las secciones críticas

    private boolean[] mesas;

    private int contador;

    public Mesa() {
        contador = 1;
        mesas = new boolean[6];
        //AL empezar todos las mesas estan disponibles al abrir restaurante
        for (int i = 0; i < mesas.length; i++) {
            this.mesas[i] = true;
        }

    }

    //SECCIONES CRITICAS. (Métodos a los que accederan los hilos.)
    //Porque es el que genera fallos al acceder
    //Synchronized para que Java no permita a varios hilos acceder a la vez. 
    //No pueden ser static. 
    //Sincronizamos para que no entren dos clientes a la vez
    public synchronized void ocuparMesa(int numCliente) {
        //Si uno de las mesas estan ocupados esperamos. Si no lo están se pone en true
        
       numCliente = contador;
       
        while (contador >= 6) { //Si esta completo el array
            try {
                wait(); //... todos los hilos se esperan
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }
        

        //Cuando haya mesas libres añdire el cliente
        mesas[numCliente] = false; //indicando mesa ocupada
        System.out.println("El cliente " + numCliente + " ha coupadola mesa " + contador);
        contador++;

        //aqui nadie espera que le avise si cojo mesa si no que avisare cuando se libere
    }

    public synchronized void liberarMesa() {
        while (contador <= 0) { //Si no hay nadie en una mesay
            try {
                wait(); //....te esperas
            } catch (InterruptedException ie) {
                Thread.currentThread();
            }
        }
        //deja disponibles los tenedores
        contador--;
        System.out.println("Se ha liberado la mesa" + mesas[contador]);
        //mesas[contador] = null;
        
        
        //Avisa al resto de hilos, (clientes) de que hay una mesa disponible
        notifyAll();
        

    }
    
    

}
