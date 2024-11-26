/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer_evaluable_sincronizacionhilos;

/**
 *
 * @author Ana
 */
public class Cliente extends Thread{ //Crear hilos
    
    private Mesa mesa;
    private int num = 1;
    private int numCliente;
    private String mensaje;
    
    public Cliente(int numCliente, Mesa mesa){
        this.numCliente = numCliente;
        this.mesa = mesa;
    }
    
    
    public void run(){ //Método obligatorio al heredar de la clase Thread. Es llamado al lanzar un hilo con start()
    while (true) {
        mensaje = " El cliente" + numCliente + " ha liberado la mesa " + num;
            //come
            come(); 
            
        }
    }
    
    public void come() {
        //Coge mesa
        mesa.ocuparMesa(this.numCliente);
        numCliente++;
        try { 
            sleep(3+(int) (Math.random() * 10000));//come //3 y 10s tiempo
        } catch (InterruptedException ie) {
        }
        //suelta tenedores
        mesa.liberarMesa();
    }
    
}
