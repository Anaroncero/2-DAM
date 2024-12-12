package com.ejemploclase;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String nombre;

    //Un departamento tiene muchos empleados
    @OneToMany(mappedBy = "dp") //tiene que coincidir con el nombre de la variable de la clase empleado
    private List<Empleado> empleados; //lista de empleados

    public Departamento(String nombre){
        this.nombre = nombre;

    }

    //Constructor vacío
    public Departamento(){}


    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    

    
}
