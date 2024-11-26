/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package app.ejercicio_barbeo;

/**
 *
 * @author Ana
 */
public class App {
    /*El problema consiste en una barbería en la que trabaja un barbero que tiene un único sillón de barbero y varias sillas para esperar. 
    Cuando no hay clientes, el barbero se sienta en una silla y se duerme. 
    Cuando llega un nuevo cliente, éste o bien despierta al barbero o —si el barbero está afeitando 
    a otro cliente— se sienta en una silla (o se va si todas las sillas están ocupadas por clientes esperando).*/
    
    public static void main(String[] args) {
        Barbero barbero = new Barbero();
        
        Cliente cliente1 = new Cliente(0, barbero);
        Cliente cliente2 = new Cliente(1, barbero);
        Cliente cliente3 = new Cliente(2, barbero);
        Cliente cliente4 = new Cliente(3, barbero);
        Cliente cliente5 = new Cliente(4, barbero);
        
        
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();
                
        
    }
}
