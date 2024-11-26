package com.example.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {

        //Hacmos conexión bbdd
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Scanner scanner = new Scanner(System.in);
    
        
        try {
            while (true) {
                //Menu para hace elegir que hacer en la BDD
                System.out.println("\n--- Menú CRUD Producto ---");
                System.out.println("1.  Crear Alumno HQL");
                System.out.println("2.  Mostrar Alumno HQL");
                System.out.println("3.  Actualizar Alumno Nombre HQL");
                System.out.println("4.  Actualizar Alumno Edad HQL");
                System.out.println("5.  Eliminar Alumno HQL");
                System.out.println("6.  Crear Alumno SQL");
                System.out.println("7.  Mostrar Alumno SQL");
                System.out.println("8.  Actualizar Alumno Nombre SQL");
                System.out.println("9.  Actualizar Alumno Edad SQL");
                System.out.println("10. Eliminar Alumno SQL");
                System.out.println("11. Salir");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        crearAlumnoHQL(session, scanner);
                        break;
                    case 2:
                        mostrarAlumnoHQL(session);
                        break;
                    case 3:
                        actualizarAlumnoNombreHQL(session, scanner);
                        break;
                    case 4:
                        actualizarAlumnoEdadHQL(session, scanner);
                        break;
                    case 5:
                        eliminarAlumnoHQL(session, scanner);
                        break;
                    case 6:
                        crearAlumnoSQL(session, scanner);
                        break;
                    case 7:
                        mostrarAlumnoSQL(session);
                        break;
                    case 8:
                        actualizarAlumnoNombreSQL(session, scanner);
                        break;
                    case 9:
                        actualizarAlumnoEdadSQL(session, scanner);
                        break;
                    case 10:
                        eliminarAlumnoSQL(session, scanner);
                        break;
                    case 11:
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
    
    //métodos CRUD: CREATE READ UPDATE AND DELETE

	private static void crearAlumnoHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Crear nuevo Alumno:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Edad: ");
            Integer edad = scanner.nextInt();

            Alumno nuevoAlumno = new Alumno(nombre, edad);
            session.save(nuevoAlumno);
            session.getTransaction().commit(); // Confirmar la transacción
            session.clear(); // Limpia la caché
            System.out.println("Alumno creado con éxito.");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // Revertir en caso de error
            }
            e.printStackTrace();
        }
    }
    

    private static void crearAlumnoSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Inicia una nueva transacción
    
            System.out.println("Crear nuevo Alumno:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Edad: ");
            Integer edad = scanner.nextInt();
    
            // Asegúrate de que la consulta SQL esté bien formada
            Query<Void> query = session.createNativeQuery("INSERT INTO Alumno (Nombre, Edad) VALUES (:Nombre, :Edad)");
            query.setParameter("Nombre", nombre); // Insertamos nombre del alumno introducido por el usuario
            query.setParameter("Edad", edad); // Asegúrate de que el nombre del parámetro sea 'Edad'
    
            query.executeUpdate(); // Ejecutar la consulta
    
            session.getTransaction().commit(); // Confirmar la transacción
            session.clear(); // Limpia la caché
            System.out.println("Alumno creado con éxito.");
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback(); // Revertir solo si la transacción está activa
            }
            e.printStackTrace();
        }
    }
    //HQL
	private static void mostrarAlumnoHQL(Session session) {
        List<Alumno> alumnos = session.createQuery("from Alumno", Alumno.class).list();
        for (Alumno alumno : alumnos) {
            System.out.println("ID_Alumno: " + alumno.getIdAlumno() + ", Nombre: " + alumno.getNombre() + ", Edad: " + alumno.getEdad());
        }
    }

    private static void mostrarAlumnoSQL(Session session) {
        List<Object[]> rows =session.createNativeQuery("select IdAlumno, Nombre, Edad from Alumno").getResultList();
        for(Object[] row : rows){
            Integer alumnoId      = (Integer) row[0]; // Cast to the appropriate type
            String  alumnoNombre  = (String) row[1];
            Integer alumnoEdad  = (Integer) row[2];
           
            // Printing the result for each row
            System.out.println("ID_Alumno: " + alumnoId + ", Nombre: " + alumnoNombre + ", Edad: " + alumnoEdad);
        }
    }
//HQL
private static void actualizarAlumnoNombreHQL(Session session, Scanner scanner) {
    try {
        session.beginTransaction(); // Iniciar una nueva transacción
        System.out.println("Inserte el código de Alumno:");
        Integer idAlumno = scanner.nextInt();
        System.out.print("Nuevo Nombre: ");
        String nuevoNombre = scanner.next();

        // Utiliza 'Nombre' en lugar de 'nombre' en la consulta HQL
        Query query = session.createQuery("UPDATE Alumno SET nombre = :nuevoNombre WHERE idAlumno = :idAlumno");
        query.setParameter("nuevoNombre", nuevoNombre);
        query.setParameter("idAlumno", idAlumno);

        int status = query.executeUpdate();
        if (status > 0) {
            System.out.println("Alumno actualizado con éxito.");
        } else {
            System.out.println("No se pudo actualizar el Alumno.");
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

    private static void actualizarAlumnoNombreSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de Alumno:");
            Integer idAlumno = scanner.nextInt();
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.next();

            Query<Integer> query = session.createNativeQuery("update Alumno set Nombre = :nuevoNombre where idAlumno = :idAlumno");
            query.setParameter("nuevoNombre", nuevoNombre);
            query.setParameter("idAlumno", idAlumno);

            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Alumno actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el alumno.");
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
//HQL
    private static void actualizarAlumnoEdadHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de Alumno:");
            Integer idAlumno = scanner.nextInt();
            System.out.print("Nueva edad: ");
            Integer nuevaEdad = scanner.nextInt();
            Query query = session.createQuery("update Alumno set edad = :nuevaEdad  where idAlumno = :idAlumno");
            query.setParameter("nuevaEdad", nuevaEdad );
            query.setParameter("idAlumno", idAlumno);
            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Alumno actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el alumno.");
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

    private static void actualizarAlumnoEdadSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de Alumno:");
            Integer idAlumno = scanner.nextInt();
            System.out.print("Nuevo edad: ");
            Integer nuevaEdad = scanner.nextInt();

            Query<Integer> query = session.createNativeQuery("update Alumno set edad = :nuevaEdad  where idAlumno = :idAlumno");
            query.setParameter("nuevaEdad", nuevaEdad );
            query.setParameter("idAlumno" , idAlumno);

            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Alumno actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el alumno.");
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
//HQL
    private static void eliminarAlumnoHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de alumno:");
            Integer idAlumno = scanner.nextInt();

            Alumno alumno = session.get(Alumno.class, idAlumno);
            if (alumno != null) {
                session.delete(alumno);
                System.out.println("Alumno eliminado con éxito.");
            } else {
                System.out.println("Alumno no encontrado con ID: " + idAlumno);
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

    private static void eliminarAlumnoSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de alumno:");
            Integer idAlumno = scanner.nextInt();

            Query<Integer> query = session.createNativeQuery("DELETE FROM Alumno WHERE IdAlumno = :idAlumno");
            query.setParameter("idAlumno", idAlumno);
            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Alumno actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el alumno.");
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

