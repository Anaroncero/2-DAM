package com.tarea_9_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        //Inicializa el EntityManagerFactory
        emf = Persistence.createEntityManagerFactory(
                "E:\\GitHub\\2-DAM\\MODULOS\\Acceso a datos\\Segundo Trimestre\\T9\\ObjectDB\\objectdb-2.9.1\\db\\tarea91.odb");
        em = emf.createEntityManager();

        //para poder lanzar el método mostrar menú o podría hacerlo directamente aqui en el main
        App app = new App();
        app.mostrarMenu();

        //Cierra el EntityManager y el EntityManagerFactory al salir
        em.close();
        emf.close();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("AÑADIR------------------------------");
            System.out.println("1. Añadir Departamento");
            System.out.println("2. Añadir Empleado");
            System.out.println("3. Añadir Cliente");
            System.out.println("4. Añadir Ciudad");

            System.out.println("MOSTRAR-----------------------------");
            System.out.println("5. Mostrar Empleados, Departamentos, Clientes y Ciudades");

            System.out.println("DESAFÍO PERSONAL--------------------");
            System.out.println("6. Mostrar Empleados por Departamento");
            System.out.println("7. Contar Empleados de cada Departamento");
            System.out.println("8. Mostrar Clientes por Ciudad");
            System.out.println("9. Salir");
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
                    addCliente(scanner);
                    break;
                case 4:
                    addCiudad(scanner);
                    break;
                case 5:
                    mostrarEmpleadosDepartamentosClientesCiudades();
                    break;
                case 6:
                    mostrarEmpleadoPorDepartamento(scanner);
                    break;
                case 7:
                    contarEmpleadosDepartamento(scanner);
                    break;
                case 8:
                    mostrarClientesCiudad(scanner);
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    private void addDepartamento(Scanner scanner) {
        System.out.print("Ingresa el nombre del departamento: ");
        String nombre = scanner.nextLine();

        Departamento dp = new Departamento(nombre);

        em.getTransaction().begin();
        em.persist(dp);
        em.getTransaction().commit();

        System.out.println("Departamento añadido.");
    }

    private void addEmpleado(Scanner scanner) {
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el puesto del empleado: ");
        String puesto = scanner.nextLine();
        System.out.print("Ingrese el nombre del departamento: ");
        String nombreDepartamento = scanner.nextLine();

        //Buscar el departamento por nombre
        List<Departamento> departamentos = em
                .createQuery("SELECT d FROM Departamento d WHERE d.nombre = :nombre", Departamento.class)
                .setParameter("nombre", nombreDepartamento)
                .getResultList();

        Departamento departamento;

        if (departamentos.isEmpty()) {
            //Si no existe, creamos uno nuevo
            System.out.println("Departamento no encontrado. Se creará un nuevo departamento.");
            departamento = new Departamento(nombreDepartamento);

            em.getTransaction().begin();
            em.persist(departamento); // Guardar el nuevo departamento
            em.getTransaction().commit();
        } else {
            //Si ya existe, cojemos el primer departamento de la lista
            departamento = departamentos.get(0);
        }

        //Crear el empleado
        Empleado empleado = new Empleado(nombre, puesto);
        empleado.setDepartamento(departamento); // Asignar el departamento al empleado

        //Añadir el empleado a la lista del departamento
        departamento.getEmpleados().add(empleado);

        
        em.getTransaction().begin();
        em.persist(empleado);
        em.getTransaction().commit();

        System.out.println("Empleado añadido correctamente al departamento '" + departamento.getNombre() + "'.");
    }

    private void addCliente(Scanner scanner) {
        System.out.println("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.println("Ingrese su ciudad: ");
        String ciudadNombre = scanner.nextLine();

        // Buscar la ciudad por nombre
        List<Ciudad> ciudades = em.createQuery("SELECT c FROM Ciudad c WHERE c.nombre = :nombre", Ciudad.class)
                .setParameter("nombre", ciudadNombre)
                .getResultList();

        Ciudad ciudad = ciudades.isEmpty() ? null : ciudades.get(0);

        if (ciudad == null) {
            System.out.println("Error: La ciudad " + ciudadNombre + " no existe.");
            System.out.println("¿Desea añadir la ciudad? (si/no)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                // Lógica para añadir la ciudad
                ciudad = new Ciudad(ciudadNombre);
                em.getTransaction().begin();
                em.persist(ciudad);
                em.getTransaction().commit();
                System.out.println("Ciudad " + ciudadNombre + " añadida correctamente.");
            } else {
                return; // Salir del método si no se desea añadir la ciudad
            }
        }

        // Crear el cliente
        Cliente cliente = new Cliente(nombre, email, ciudad);

        // Añadir el cliente a la lista de clientes de la ciudad
        if (ciudad.getClientes() == null) {
            ciudad.setClientes(new ArrayList<>()); // Crear la lista de clientes si no existe
        }
        ciudad.getClientes().add(cliente);

        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();

        System.out.println("Cliente añadido correctamente.");
    }

    private void addCiudad(Scanner scanner) {
        System.out.print("Ingrese el nombre de la ciudad: ");
        String nombreCiudad = scanner.nextLine();

        Ciudad ciudad = new Ciudad(nombreCiudad);

        em.getTransaction().begin();
        em.persist(ciudad);
        em.getTransaction().commit();

        System.out.println("Ciudad añadida correctamente.");
    }

    private void mostrarEmpleadosDepartamentosClientesCiudades() {
        System.out.println("Empleados: ");
        List<Empleado> empleados = em.createQuery("SELECT e from Empleado e", Empleado.class).getResultList();
        for (Empleado empleado : empleados) {
            System.out.println(empleado.getNombre() + " " + empleado.getPuesto());
        }

        System.out.println("Departamentos: ");
        List<Departamento> departamentos = em.createQuery("SELECT d from Departamento d", Departamento.class)
                .getResultList();
        for (Departamento departamento : departamentos) {
            System.out.println(departamento.getNombre());
        }

        System.out.println("Clientes: ");
        List<Cliente> clientes = em.createQuery("SELECT c from Cliente c", Cliente.class).getResultList();
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getNombre());
        }

        System.out.println("Ciudades: ");
        List<Ciudad> ciudades = em.createQuery("SELECT ciu from Ciudad ciu", Ciudad.class).getResultList();
        for (Ciudad ciudad : ciudades) {
            System.out.println(ciudad.getNombre());
        }
    }

    private void mostrarEmpleadoPorDepartamento(Scanner scanner) {
        System.out.print("Ingresa el nombre del departamento: ");
        String nombre = scanner.nextLine();

        // Buscamos departamento
        List<Departamento> departamentos = em
                .createQuery("SELECT d FROM Departamento d WHERE d.nombre = :nombre", Departamento.class)
                .setParameter("nombre", nombre)
                .getResultList();

        if (departamentos.isEmpty()) {
            System.out.println("Departamento no encontrado.");
            return;
        }

        Departamento departamento = departamentos.get(0);

        // Mostrar empleados del departamento
        if (departamento.getEmpleados() != null) {
            System.out.println("Empleados en el departamento " + departamento.getNombre() + ":");
            for (Empleado empleado : departamento.getEmpleados()) {
                System.out.println(empleado.getNombre() + " - " + empleado.getPuesto());
            }
        } else {
            System.out.println("No se encontraron empleados en este departamento.");
        }
    }

    private void contarEmpleadosDepartamento(Scanner scanner) {
        System.out.print("Ingresa el nombre del departamento: ");
        String nombre = scanner.nextLine();

        // Buscar el departamento
        List<Departamento> departamentos = em.createQuery(
                "SELECT d FROM Departamento d WHERE d.nombre = :nombre", Departamento.class)
                .setParameter("nombre", nombre)
                .getResultList();

        if (departamentos.isEmpty()) {
            System.out.println("Departamento no encontrado.");
            return;
        }

        Departamento departamento = departamentos.get(0);

        // Contar los empleados
        int cantidadEmpleados = departamento.getEmpleados() != null ? departamento.getEmpleados().size() : 0;
        System.out.println("El departamento '" + nombre + "' tiene " + cantidadEmpleados + " empleados.");
    }

    private void mostrarClientesCiudad(Scanner scanner) {
        System.out.print("Ingresa el nombre de la ciudad: ");
        String nombre = scanner.nextLine();

        // Buscamos ciudad
        List<Ciudad> ciudades = em.createQuery("SELECT c FROM Ciudad c WHERE c.nombre = :nombre", Ciudad.class)
                .setParameter("nombre", nombre)
                .getResultList();

        if (ciudades.isEmpty()) {
            System.out.println("No se encontró ninguna ciudad con ese nombre.");
        } else {
            Ciudad ciudad = ciudades.get(0); // Tomamos la primera ciudad de la lista
            System.out.println("Ciudad encontrada: " + ciudad.getNombre());

            // Obtener y mostrar los clientes de la ciudad
            List<Cliente> clientes = ciudad.getClientes(); // Asumiendo que tienes un método getClientes en Ciudad

            if (clientes == null || clientes.isEmpty()) {
                System.out.println("No hay clientes en esta ciudad.");
            } else {
                System.out.println("Clientes:");
                for (Cliente cliente : clientes) {
                    System.out.println("- " + cliente.getNombre());
                }
            }
        }
    }
}