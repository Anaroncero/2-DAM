/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejer_2;

import java.util.Scanner;

/**
 *
 * @author Ana
 */

/* 1.Clase principal pide por consola 2 números al usuario
2. Lanza 4 hilos, uno para hacer cada operación (+,-,*,/) y cada hilo muestra su resultado*/
public class Ejer_2 {

    public static void main(String[] args) {
        
        // Crear un objeto Scanner
        Scanner sc = new Scanner(System.in);
        
        // Crear variables números
        System.out.print("Introduce un número: ");
        double num1 = Double.parseDouble(sc.nextLine());
 
        System.out.print("Introduce segundo número: ");
        double num2 = Double.parseDouble(sc.nextLine());
        
        
        SumaHilo s= new SumaHilo(num1, num2);
        RestaHilo r = new RestaHilo(num1, num2);
        MultHilo m = new MultHilo(num1, num2);
        DivHilo d = new DivHilo(num1, num2);
        
        s.start();
        

        r.start();
        m.start();
        d.start();

    }
}
