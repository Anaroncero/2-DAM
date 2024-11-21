/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejer3_estanco;

/**
 *
 * @author Ana
 */
public class Fumador extends Thread{
    
    //Atributos
    String componente;
    Estanco estanco;
    
    //Constructor
    public Fumador(String componente, Estanco estanco){
        this.componente = componente;
        this.estanco = estanco;
    }
    
    
}
