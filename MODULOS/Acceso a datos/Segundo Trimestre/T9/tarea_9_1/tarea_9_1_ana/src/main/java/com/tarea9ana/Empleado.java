package com.tarea9ana;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Empleado extends Persona{
    
    @ManyToOne //muchos empleados tienen un departamento
    private Departamento departamento;
    String puesto;

    //Constructor vacio
    public Empleado(){}

    public Empleado(String nombre, String puesto){
        super(nombre);
        this.puesto = puesto;
    }
    
    //Getters y Setters
    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento dp) {
        this.departamento = dp;
    }
    public String getPuesto() {
        return puesto;
    }
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    

}
