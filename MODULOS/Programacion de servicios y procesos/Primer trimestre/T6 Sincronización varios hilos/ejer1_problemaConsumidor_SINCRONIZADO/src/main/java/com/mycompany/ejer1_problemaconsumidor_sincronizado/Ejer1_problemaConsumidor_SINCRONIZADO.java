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

/*Problema del productor/consumidor.

El problema del productor/consumidor refleja un problema clásico de concurrencia, que se da habitualmente en sistemas en los que varios hilos modifican datos simultáneamente (sistemas de mensajería, aplicaciones de streaming, múltiples consultas a bbdd, etc.).

 

El problema del productor/consumidor no sincronizado.

Simula la programación del servidor de una tienda online. El programa cuenta con:

Almacén: clase que tiene un array de Strings de 10 posiciones, un método añadir producto que añade a la primera posición libre el String que se le pasa por parámetro, y un método retirar producto que elimina el último String del producto.
Cliente: esta clase intenta añadir productos permanentemente en bucle al array del almacén. Los String que intenta añadir son una frase formada por el nombre del cliente y el número de producto que intenta añadir, algo como “Producto 1 de Juan”.
Trabajador: esta clase representa un trabajador que intenta sacar elementos del array. Se encarga de llamar al método que elimina el último elemento del array cada 1-5 segundos (aleatorio).
En el main, crea y lanza 3 clientes y 2 trabajadores. Observa detenidamente lo que sucede en la consola, intentando deducir por qué está fallando.

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

