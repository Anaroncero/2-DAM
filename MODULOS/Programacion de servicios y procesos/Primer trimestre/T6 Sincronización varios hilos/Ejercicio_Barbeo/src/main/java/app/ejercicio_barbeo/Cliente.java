/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.ejercicio_barbeo;

/**
 *
 * @author Usuario
 */
public class Cliente extends Thread {
    
    private Barbero barbero;
    private int idCliente; 

    public Cliente(int idCliente, Barbero barbero) {
        this.idCliente = idCliente;
        this.barbero = barbero;
    }
    
    public void run() {
        try {
            barbero.ocuparSilla(idCliente); // El cliente ocupa una silla
            barbero.iniciarCorte(idCliente); // El cliente inicia el corte
            Thread.sleep(800); // Simula el tiempo del corte
            barbero.finCorte(idCliente); // El cliente finaliza el corte
            barbero.dejarSilla(idCliente); // El cliente deja la silla
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

