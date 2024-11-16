/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer0_problema_productor_consumidor;

/**
 *
 * @author Ana
 */

public class Almacen {
    
    static String[] almacen = new String[10];
    static int contador = 0;
    //no hacemos un constructor porque no queremos crear muchos almcenes (no quiero hacer objetos almacen)
    //solo quiero un almacen y que todo acceda aqui por eso pongo static y no creo constructor
    
    
    //Métodos
    public static void add_producto(String productoID){ //SI NO PONGO STATIC NO PUEDO ACCEDER DESDE LA OTRA CLASE
        
        if(contador <= 9){ //compuebo si hay hueco en el array
            almacen[contador] = productoID; //introduzco el id del producto
            contador++; //al añadir el producto se incrementa el contador
            System.out.println("Se ha añadido el producto: " + productoID);
        }
    }
    
    public static void delete_producto(){ 
        if(contador > 0){ //si hay algo en el array...
            
            contador--; //al quitar el producto decremento el contador
            System.out.println("Se ha eliminado el " + almacen[contador]); 
            almacen[contador] = null;  //dejo la posicion del array nula (eliminamos)
        }
    }
    
}
