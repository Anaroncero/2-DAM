/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfc.javadoc;

/**
 *
 * @author Antonio Navarro
 */
/**
 * Clase que representa a una persona con nombre y edad.
 */
public class Persona {
    private String nombre;
    private int edad;

    /**
     * Constructor de la clase Persona.
     *
     * @param nombre Nombre de la persona.
     * @param edad   Edad de la persona.
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return Edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Verifica si la persona es mayor de edad.
     *
     * @return true si la persona tiene 18 años o más, false en caso contrario.
     */
    public boolean esMayorDeEdad() {
        return edad >= 18; // Cambiado a >= para incluir 18 años
    }}