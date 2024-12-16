package com.tarea_9_1;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Empleado extends Persona{

    //Muchos empleados tienen un departamento
    @ManyToOne

    private Departamento departamento;
    private String puesto;

    //constructor vacio
    public Empleado(){}

    //Constructor
    public Empleado(String nombre, String puesto){
        super(nombre);
        this.puesto = puesto;
    }

    //Getters y Setters
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    
    
    
}
