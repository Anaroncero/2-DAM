package com.example.demo;

public class Alumno {
//MAPEO

//CLASE PERSISTENTE: CONSTRUCTOR VACIO, ATRIBUTOS, GET Y SET 
   
    private Integer idAlumno;
    private String nombre;
    private Integer edad;

    // Constructor
    public Alumno() {}

    public Alumno(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y Setters
    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
