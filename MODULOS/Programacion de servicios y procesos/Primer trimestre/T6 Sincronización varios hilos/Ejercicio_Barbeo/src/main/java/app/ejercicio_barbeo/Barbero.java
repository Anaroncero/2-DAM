/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.ejercicio_barbeo;


/**
 *
 * @author Usuario
 */
public class Barbero{
    
    public boolean[] sillas = new boolean[5];
    private boolean ocupado; //bandera

    
    public synchronized void ocuparSilla(int idCliente){
        System.out.println("La silla esta ocupada por el cliente " + idCliente);
    } 
    
    public synchronized void dejarSilla(int idCliente){
        if (sillas[idCliente]) {
            sillas[idCliente] = false; // Marca la silla como libre
            System.out.println("El cliente " + idCliente + " deja libre la silla");
            notify(); // Notifica a otros hilos que una silla ha sido liberada
        } else {                                     
            System.out.println("El cliente " + idCliente + " no estaba en la silla");
        }
          }
    
    public synchronized void iniciarCorte(int idCliente){
        while (isOcupado()) {
            
            System.out.println("El barbero esta ocupado, el cliente " + idCliente + " esta esperando");  
            
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        this.setOcupado(true);
        System.out.println("El barbero empieza a cortar el pelo al cliente " + idCliente);
    }
    
    public synchronized void finCorte(int idCliente){
        this.setOcupado(false);
        System.out.println("El barbero termina de cortar el pelo al cliente " + idCliente);
        notify();
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
