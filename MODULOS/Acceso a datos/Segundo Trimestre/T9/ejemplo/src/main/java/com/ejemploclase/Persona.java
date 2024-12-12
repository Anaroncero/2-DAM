package com.ejemploclase;


import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Entidad Persona
public class Persona {
    
    //Atributos

    @Id //indicar que es id
    @GeneratedValue(strategy = GenerationType.AUTO) //indicamos que es autonumerico

    private int id;
    private String name;

    //Constructor vacio
    public Persona(){

    }

    //constructor 
    public Persona(String name){
        this.name = name;
    }


    //getter y setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    
}
