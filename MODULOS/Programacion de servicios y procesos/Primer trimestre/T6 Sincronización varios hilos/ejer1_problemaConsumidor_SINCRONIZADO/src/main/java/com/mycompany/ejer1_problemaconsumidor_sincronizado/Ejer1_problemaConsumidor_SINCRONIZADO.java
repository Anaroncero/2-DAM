/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer1_problemaconsumidor_sincronizado;

/**
 *
 * @author Ana
 * 
 */

/*Secciones críticas (trozo de coódigo con fallos). 
Monitor (clase que contiene la secciones criticas)*/

/*
El problema del productor/consumidor sincronizado.

Mejora el ejercicio anterior sincronizando los hilos para evitar los problemas que has observado.*/


public class Ejer1_problemaConsumidor_SINCRONIZADO {

    public static void main(String[] args) {
        
        //Creo un objeto almacén y se lo paso a todos para asegurarme
        //de que todos ponen y quitan productos al mismo almacén
        //Lo hago así porque al sincronizar hilos no puedo usar static
        Almacen a = new Almacen();
        
        //Productores (clientes, quienes ponen cosas en el almacén)
        Cliente cliente1 = new Cliente("Pepe", a);
        Cliente cliente2 = new Cliente("Ivan", a);
        Cliente cliente3 = new Cliente("Marta", a);
        
        //Consumidores (trabajadores, quienes quitan cosas del almacén)
        Trabajador t1 = new Trabajador(a);
        Trabajador t2 = new Trabajador(a);
        
        cliente1.start();
        cliente2.start();
        cliente3.start();
        
        t1.start();
        t2.start();

}
}

