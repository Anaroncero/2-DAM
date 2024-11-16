package com.example.ejercicio_8;

public class Datos {

    private static String apellido; //con esto puedo acceder desde otra clase desde MainActivity y MainActivity2



    public static void setApellido(String n){
        apellido = n;
    }

    public static String getApellido(){
        return apellido;
    }

}
