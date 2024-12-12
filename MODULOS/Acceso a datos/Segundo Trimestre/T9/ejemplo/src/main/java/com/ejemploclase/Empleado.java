package com.ejemploclase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Empleado extends Persona{ //hereda de persona
    
    private float sueldo;

    @ManyToOne
    private Departamento departamento; 

    public Empleado(){}

    public Empleado(String name, float sueldo, Departamento dp){
        super(name); //nombre heredado de Persona
        this.sueldo = sueldo;
        this.departamento = dp;
    }

    public float getSueldo() {
        return sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    
    


}
