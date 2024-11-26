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
                System.out.println("1.  Crear Producto HQL");
                System.out.println("2.  Mostrar Producto HQL");
                System.out.println("3.  Actualizar Producto Nombre HQL");
                System.out.println("4.  Actualizar Producto Precio HQL");
                System.out.println("5.  Eliminar Producto HQL");
                System.out.println("6.  Crear Producto SQL");
                System.out.println("7.  Mostrar Producto SQL");
                System.out.println("8.  Actualizar Producto Nombre SQL");
                System.out.println("9.  Actualizar Producto Precio SQL");
                System.out.println("10. Eliminar Producto SQL");
                System.out.println("11. Salir");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
    
                switch (opcion) {
                    case 1:
                        crearProductoHQL(session, scanner);
                        break;
                    case 2:
                        mostrarProductosHQL(session);
                        break;
                    case 3:
                        actualizarProductoNombreHQL(session, scanner);
                        break;
                    case 4:
                        actualizarProductoPrecioHQL(session, scanner);
                        break;
                    case 5:
                        eliminarProductoHQL(session, scanner);
                        break;
                    case 6:
                        crearProductoSQL(session, scanner);
                        break;
                    case 7:
                        mostrarProductosSQL(session);
                        break;
                    case 8:
                        actualizarProductoNombreSQL(session, scanner);
                        break;
                    case 9:
                        actualizarProductoPrecioSQL(session, scanner);
                        break;
                    case 10:
                        eliminarProductoSQL(session, scanner);
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

	private static void crearProductoHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Crear nuevo Producto:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Precio: ");
            Integer precio = scanner.nextInt();
            System.out.print("Stock: ");
            Integer stock = scanner.nextInt();
            Producto nuevoProducto = new Producto(nombre, precio, stock);
            session.save(nuevoProducto);
            session.getTransaction().commit(); // Confirmar la transacción
            session.clear(); // Limpia la caché
            System.out.println("Producto creado con éxito.");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // Revertir en caso de error
            }
            e.printStackTrace();
        }
    }
    

    private static void crearProductoSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Inicia una nueva transacción
        
            System.out.println("Crear nuevo producto:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Precio: ");
            Integer precio = scanner.nextInt();
            System.out.print("Stock: ");
            Integer stock = scanner.nextInt();

        
            Query<Void> query = session.createNativeQuery("INSERT INTO Productos (nombre, precio, stock) VALUES (:Nombre, :Precio, :Stock)");
            query.setParameter("Nombre", nombre); //Insetamos nombre producto introducido por el usuario
            query.setParameter("Precio", precio); 
            query.setParameter("Stock", stock);
            query.executeUpdate(); // Ejecutar la consulta
            

            session.getTransaction().commit(); // Confirmar la transacción
            session.clear(); // Limpia la caché de la sesión Suele dar problemas

    
            System.out.println("Producto creado con éxito.");
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback(); // Revertir solo si la transacción está activa
            }
            e.printStackTrace();
        }
    }
    //HQL
	private static void mostrarProductosHQL(Session session) {
        List<Producto> productos = session.createQuery("from Producto", Producto.class).list();
        for (Producto producto : productos) {
            System.out.println("ID_Producto: " + producto.getidProducto() + ", Nombre: " + producto.getnombre() + ", Precio: " + producto.getprecio() + ", Stock: " + producto.getstock());
        }
    }

    private static void mostrarProductosSQL(Session session) {
        List<Object[]> rows =session.createNativeQuery("select ID_Producto, Nombre, Precio , Stock from productos").getResultList();
        for(Object[] row : rows){
            Integer productoId      = (Integer) row[0]; // Cast to the appropriate type
            String  productoNombre  = (String) row[1];
            Integer productoPrecio  = (Integer) row[2];
            Integer productoStock   = (Integer) row[3];

            // Printing the result for each row
            System.out.println("ID_Producto: " + productoId + ", Nombre: " + productoNombre + ", Precio: " + productoPrecio  + ", Stock: " + productoStock );
        }
    }
//HQL
    private static void actualizarProductoNombreHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de producto:");
            Integer idProducto = scanner.nextInt();
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.next();

            Query query = session.createQuery("update Producto set nombre = :nuevoNombre where idProducto = :idProducto");
            query.setParameter("nuevoNombre", nuevoNombre);
            query.setParameter("idProducto", idProducto);

            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el producto.");
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

    private static void actualizarProductoNombreSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de producto:");
            Integer idProducto = scanner.nextInt();
            System.out.print("Nuevo Nombre: ");
            String nuevoNombre = scanner.next();

            Query<Integer> query = session.createNativeQuery("update Productos set Nombre = :nuevoNombre where ID_Producto = :idProducto");
            query.setParameter("nuevoNombre", nuevoNombre);
            query.setParameter("idProducto", idProducto);

            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el producto.");
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
    private static void actualizarProductoPrecioHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de producto:");
            Integer idProducto = scanner.nextInt();
            System.out.print("Nuevo precio: ");
            Integer nuevoprecio = scanner.nextInt();
            Query query = session.createQuery("update Producto set precio = :nuevoprecio  where idProducto = :idProducto");
            query.setParameter("nuevoprecio", nuevoprecio );
            query.setParameter("idProducto", idProducto);
            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el producto.");
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

    private static void actualizarProductoPrecioSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de Producto:");
            Integer idProducto = scanner.nextInt();
            System.out.print("Nuevo precio: ");
            Integer nuevoprecio = scanner.nextInt();

            Query<Integer> query = session.createNativeQuery("update Productos set Precio = :nuevoprecio  where ID_Producto = :idProducto");
            query.setParameter("nuevoprecio", nuevoprecio );
            query.setParameter("idProducto" , idProducto);

            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el Producto.");
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
    private static void eliminarProductoHQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de producto:");
            Integer idProducto = scanner.nextInt();

            Producto producto = session.get(Producto.class, idProducto);
            if (producto != null) {
                session.delete(producto);
                System.out.println("Producto eliminado con éxito.");
            } else {
                System.out.println("Producto no encontrado con ID: " + idProducto);
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

    private static void eliminarProductoSQL(Session session, Scanner scanner) {
        try {
            session.beginTransaction(); // Iniciar una nueva transacción
            System.out.println("Inserte el código de producto:");
            Integer idProducto = scanner.nextInt();

            Query<Integer> query = session.createNativeQuery("DELETE FROM Productos WHERE Id_Producto = :idProducto");
            query.setParameter("idProducto", idProducto );
            int status = query.executeUpdate();
            if (status > 0) {
                System.out.println("Producto actualizado con éxito.");
            } else {
                System.out.println("No se pudo actualizar el Producto.");
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

