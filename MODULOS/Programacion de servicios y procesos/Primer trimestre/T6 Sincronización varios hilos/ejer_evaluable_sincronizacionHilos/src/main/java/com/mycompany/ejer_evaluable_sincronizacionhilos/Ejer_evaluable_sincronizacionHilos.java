/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejer_evaluable_sincronizacionhilos;

/**
 *
 * @author Ana
 */

/*En un restaurante, hay 5 mesas y 10 clientes que desean ocuparlas. Cada mesa puede ser ocupada por un solo cliente a la vez. Cuando un cliente llega al restaurante, ocupará una mesa (si hay alguna disponible). Si todas las mesas están ocupadas, los clientes deben esperar. Cuando una mesa se libera, un nuevo cliente la ocupa. 

(No se tiene en cuenta la cantidad de personas que llegan ni la cantidad de asientos de cada mesa… para simplificar, un solo cliente ocupa una mesa, sin preocuparnos de para cuántas personas es).

Cada cliente sigue estos pasos:

Llega al restaurante e intenta ocupar una mesa (quizá se le asigne una rápidamente, si hay disponibles, o quizá tenga que esperar a que otro cliente se vaya, si estaban todas ocupadas).
Ocupa la mesa y se pone a comer. La comida durará un tiempo aleatorio entre 3 y 10 segundos).
Libera la mesa y se va del restaurante.
El cliente, una vez libera la mesa y se va, no vuelve a solicitar una nueva mesa. Este cliente finaliza su programación y ya no hace nada más.

El programa finaliza cuando los 10 clientes han terminado de comer, mostrando por consola una frase que lo indique.

Requisitos:

Un cliente no puede ocupar una mesa si todas las mesas están ocupadas.
Un cliente no puede solicitar una mesa si ya tiene una mesa.
Un cliente no puede liberar una mesa que no ha ocupado.
El restaurante debe asegurarse de que no haya conflictos entre clientes para el uso de las mesas.
La consola debería mostrar algo así (ten en cuenta que el orden de las mesas varía en cada ejecución):*/
public class Ejer_evaluable_sincronizacionHilos {

    public static void main(String[] args) {

        //Mesas
        Mesa mesa = new Mesa();


        //Clientes
        Cliente c1 = new Cliente(1, mesa);
        Cliente c2 = new Cliente(2, mesa);
        Cliente c3 = new Cliente(3, mesa);
        Cliente c4 = new Cliente(4, mesa);
        Cliente c5 = new Cliente(5, mesa);
        
        Cliente c6 = new Cliente(6, mesa);
        Cliente c7 = new Cliente(7, mesa);
        Cliente c8 = new Cliente(8, mesa);
        Cliente c9 = new Cliente(9, mesa);
        Cliente c10 = new Cliente(10, mesa);
        

        //Lanza hilos
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();
        c9.start();
        c10.start();
       
        
        
    }
}
