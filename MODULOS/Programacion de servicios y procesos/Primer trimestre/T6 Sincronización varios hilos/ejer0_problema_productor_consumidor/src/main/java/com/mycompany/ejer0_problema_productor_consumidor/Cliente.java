/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer0_problema_productor_consumidor;

/**
 *
 * @author Ana
 */
public class Cliente extends Thread{
    
    //Atributos
    String nombreCliente;
    String productoID = "";
    int num = 1;
    
    //Constructor (poder crear clientes)
    public Cliente(String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    
    public void run(){
        while(true){
            productoID = "Producto" + num + " de " + nombreCliente;
            Almacen.add_producto(productoID);
            num++;
        }
    }
    
}
