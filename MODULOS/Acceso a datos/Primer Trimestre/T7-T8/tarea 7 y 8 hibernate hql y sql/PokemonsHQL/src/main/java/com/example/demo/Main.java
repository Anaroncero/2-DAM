package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner scanner = new Scanner(System.in);
    
        try {
            while (true) {
                System.out.println("\n--- Menú CRUD Pokemon ---");
                System.out.println("1.  Crear Pokemon HQL");
                System.out.println("2.  Mostrar Pokemon HQL");
                System.out.println("3.  Actualizar Pokemon Nombre SQL");
                System.out.println("4. Eliminar Pokemon SQL");
                System.out.println("5. Salir");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        crearPokemonHQL(session, scanner);
                        break;
                    case 2:
                        mostrarPokemonHQL(session);
                        break;
                    case 3:
                        actualizarPokemonNombreSQL(session, scanner);
                        break;
                    case 4:
                        eliminarPokemonSQL(session, scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        session.close();
                        sessionFactory.close();
                        scanner.close();
                        System.exit(0);
                        break;        
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
    

	private static void crearPokemonHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Crear nuevo Pokemon:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Estatura: ");
            Integer estatura = scanner.nextInt();
            System.out.print("Peso: ");
            Integer precio = scanner.nextInt();
            Pokemon nuevoPokemon = new Pokemon(nombre, estatura, precio);
            session.save(nuevoPokemon);
            session.getTransaction().commit(); // Confirmar la transacción
            session.clear(); // Limpia la caché
            System.out.println("Pokemon creado con éxito.");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // Revertir en caso de error
            }
            e.printStackTrace();
        }
    }
    
    
	private static void mostrarPokemonHQL(Session session) {
        List<Pokemon> pokemons = session.createQuery("from Pokemon", Pokemon.class).list();
        for (Pokemon pokemon : pokemons) {
            System.out.println("ID_POKEMON: " + pokemon.getidPokemon() + ", Nombre: " + pokemon.getNombre() + ", Estatura: " + pokemon.getEstatura() + ", Peso: " + pokemon.getPeso());
        }
    }

   
    private static void actualizarPokemonNombreSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de pokemon:");
            Integer idPokemon = scanner.nextInt();
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.next();

            Query<Integer> query = session.createNativeQuery("update Pokemon set Nombre = :nuevoNombre where idPokemon = :idPokemon");
            query.setParameter("nuevoNombre", nuevoNombre);
            query.setParameter("idPokemon", idPokemon);

            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Pokemon actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el pokemon.");
            }
            session.getTransaction().commit(); // Confirmar los cambios
            session.clear(); // Limpia la caché
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // Revertir en caso de error
            }
            e.printStackTrace();
        }
    }


    private static void eliminarPokemonSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de pokemon:");
            Integer idPokemon = scanner.nextInt();

            Query<Integer> query = session.createNativeQuery("DELETE FROM Pokemon WHERE idPokemon = :idPokemon");
            query.setParameter("idPokemon", idPokemon );
            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Pokemon actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el Pokemon.");
            }
            session.getTransaction().commit(); // Confirmar los cambios
            session.clear(); // Limpia la caché
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // Revertir en caso de error
            }
            e.printStackTrace();
        }
    }

   
}

