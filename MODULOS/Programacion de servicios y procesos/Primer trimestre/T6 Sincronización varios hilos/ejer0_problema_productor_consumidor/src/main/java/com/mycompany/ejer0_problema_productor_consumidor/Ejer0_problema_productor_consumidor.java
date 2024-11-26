/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejer0_problema_productor_consumidor;

/**
 *
 * @author Ana
 */
/*El problema productor consumidor
Problema del productor/consumidor.

El problema del productor/consumidor refleja un problema clásico de concurrencia, que se da habitualmente en sistemas en los que varios hilos modifican datos simultáneamente (sistemas de mensajería, aplicaciones de streaming, múltiples consultas a bbdd, etc.).

 

El problema del productor/consumidor no sincronizado.

Simula la programación del servidor de una tienda online. El programa cuenta con:

Almacén: clase que tiene un array de Strings de 10 posiciones, un método añadir producto que añade a la primera posición libre el String que se le pasa por parámetro, y un método retirar producto que elimina el último String del producto.
Cliente: esta clase intenta añadir productos permanentemente en bucle al array del almacén. Los String que intenta añadir son una frase formada por el nombre del cliente y el número de producto que intenta añadir, algo como “Producto 1 de Juan”.
Trabajador: esta clase representa un trabajador que intenta sacar elementos del array. Se encarga de llamar al método que elimina el último elemento del array cada 1-5 segundos (aleatorio).
En el main, crea y lanza 3 clientes y 2 trabajadores. Observa detenidamente lo que sucede en la consola, intentando deducir por qué está fallando.
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
