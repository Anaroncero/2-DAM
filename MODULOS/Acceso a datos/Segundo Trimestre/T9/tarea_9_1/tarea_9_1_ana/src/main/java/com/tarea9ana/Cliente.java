package com.tarea9ana;

import javax.persistence.Entity;

@Entity
public class Cliente extends Persona{

    private Ciudad ciudad;

    private String email;

    //Constructor vacio
    public Cliente(){}

    public Cliente(String nombre, String email, Ciudad ciudad){
        super(nombre);
        this.ciudad = ciudad;
        this.email = email;
    }

    //Getters y Setters
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
