/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer1_problemaconsumidor_sincronizado;

/**
 *
 * @author Ana
 */
public class Cliente extends Thread {

    private Almacen almacen; //Creo un almacen
    private String nombreCliente;
    private String productoID = "";
    private int num = 1;

    public Cliente(String nombreCliente, Almacen almacen) {
        this.nombreCliente = nombreCliente; //Guardo el almacne creado en el main
        this.almacen = almacen;
    }

    public void run() {
        while (true) {
            productoID = "Producto" + num + " de " + nombreCliente;
            almacen.add_producto(productoID); //inserto el producto en el almacén del main
            num++;
        }
    }

}
