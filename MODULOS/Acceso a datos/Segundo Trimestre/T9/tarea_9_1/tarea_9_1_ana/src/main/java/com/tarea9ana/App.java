package com.tarea9ana;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    public static void main( String[] args )
    {

//Inicializa el EntityManagerFactory con la ruta donde queremos crear nuestra bd (dentro de ObjectDB)
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("E:\\GitHub\\2-DAM\\MODULOS\\Acceso a datos\\Segundo Trimestre\\T9\\ObjectDB\\objectdb-2.9.1\\db\\tarea9.odb");
       EntityManager em = emf.createEntityManager();    
    
    }
}

public void mostrarMenu() {
    Scanner scanner = new Scanner(System.in);
    int opcion;

    do {
        System.out.println("1. Añadir Departamento");
        System.out.println("2. Añadir Empleado");
        System.out.println("3. Mostrar Empleados");
        System.out.println("4. Mostrar Empleados por Departamento");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); 

        switch (opcion) {
            case 1:
                addDepartamento(scanner);
                break;
            case 2:
                addEmpleado(scanner);
                break;
            case 3:
                mostrarEmpleado();
                break;
            case 4:
                mostrarEmpleadoPorDepartamento(scanner);
                break;
            case 0:
                salir();
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    } while (opcion != 0);

    scanner.close();
}

private void addDepartamento(Scanner scanner){

}

private void addEmpleado(Scanner scanner){
    
}

private void mostrarEmpleado(){
    
}

private void mostrarEmpleadoPorDepartamento(Scanner scanner){
    
}
