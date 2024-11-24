/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer1_problemaconsumidor_sincronizado;

/**
 *
 * @author Ana
 */
//Esta clase es un monitor porque contiene secciones criticas.
public class Almacen {

    private String[] almacen ;
    private int contador;

    public Almacen(){
        almacen = new String[10];
        contador= 0;
    }
   

    //SECCIONES CRITICAS. 
    //Porque es el que genera fallos al acceder al array
    //Synchronized para que Java no permita a varios hilos. 
    //No puedo permitir que dos hilos lo hagan a la vez.
    //No pueden ser static. 
    public synchronized void add_producto(String productoID) { //INTRODUZCO EL PRODUCTO ID
        while (contador >= 10) { //Si esta completo el array
            try {
                wait(); //... todos los hilos se esperan
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
        }

        //Cuando haya hueco en el array, saldrá del bucle y añadiré el producto
        almacen[contador] = productoID;
        System.out.println("Se ha añadido el " + productoID + " en el hueco " +  contador);
        contador++;
        

        //Avise al resto de hilos de que pueden añadir sus productos
        notifyAll();
    }

    
    //SECCION CRITICA
    //Sincronizamos para que no entren 2 a la vez
    public synchronized void delete_producto() {
        while (contador <= 0) { //Si no hay nada en el array
            try {
                wait(); //....te esperas
            } catch (InterruptedException ie) {
                Thread.currentThread();
            }
        }
        //si hay cosas salgo del array. El trabajador quitará un producto
        contador--;
        System.out.println("Se ha eliminado el " + almacen[contador]);
        almacen[contador] = null;
        
        //Avisamos al resto de hilos
        notifyAll();

    }

}

