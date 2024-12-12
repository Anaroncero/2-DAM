package com.example.demo;

public class Pokemon {

    private Integer idPokemon;
    private String  nombre;
    private Integer estatura;
    private Integer peso;


    public Pokemon() {
    }

    public Pokemon(String nombre, int estatura, int peso) {
        this.nombre = nombre;
        this.estatura = estatura;
        this.peso = peso;
    }

    public Integer getidPokemon() {
        return idPokemon;
    }

    public void setidPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }



    
}
