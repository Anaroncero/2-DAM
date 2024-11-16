import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Connect {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/taquilla";

    public static void main(String[] args) {

        // Variables para la conexión a la BDD
        final String USUARIO = "root";
        final String PASSWORD = "Med@c";
        Connection dbConnection = null;


        try {
            // Crear menú
            System.out.println(
                    "Menú de consultas:\n Opción 1: Mostrar todas las películas\n Opción 2: Mostrar todas las películas de un actor por su nombre\n Opción 3: Mostrar todas las películas, sus actores y sus directores\n Opción 4: Mostrar la suma de películas por nombre de actor\n Opción 5: Salir");
            Scanner sc = new Scanner(System.in);
            int opcion;

            // Carga el controlador de la base de datos
            Class.forName(DRIVER);
            // Establecer conexión a la base de datos
            dbConnection = DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);

            // Bucle del menú con las opciones y la llamada a los métodos
            do {
                System.out.println("Introduzca una opción del menú (1-5): ");
                opcion = sc.nextInt();
                sc.nextLine(); // Quitar el salto de línea

                switch (opcion) {
                    case 1:
                        mostrarPeliculas(dbConnection); // pasamos la conexión como parámetro 
                        break;

                    case 2:
                        mostrarPeliculasPorActor(dbConnection, sc);
                        break;

                    case 3:
                        mostrarPeliculasActoresDirectores(dbConnection);
                        break;

                    case 4:
                        contarPeliculasPorActor(dbConnection, sc);
                        break;

                    case 5:
                        System.out.println("Ha elegido salir del menú");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }

            } while (opcion != 5);

            sc.close();
            

        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Controlador no encontrado: " + e.getMessage());
        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
    }


    // Métodos
    private static void mostrarPeliculas(Connection dbConnection) throws SQLException { // Pasamos el parametro Connection dbConnection para pasar la conexión a la bdd al método, asi no tenemos que crear conexión de nuevo dentro del método 
        String mostrarPeliculas = "SELECT * FROM peliculas";
        try (PreparedStatement statement = dbConnection.prepareStatement(mostrarPeliculas);
            ResultSet rs = statement.executeQuery()) {

            while (rs.next()) { // Recorrer todos los registros de la tabla
                System.out.println("------------------------------------");
                System.out.println("id: " + rs.getString("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Año: " + rs.getString("anio"));
            }
        }
    }

    private static void mostrarPeliculasPorActor(Connection dbConnection, Scanner sc) throws SQLException { // pasamos como parámetro el scanner para que el método lea la entrada del usuario sin tener que crear una nueva dentro del metodo
        System.out.println("Introduzca el nombre del actor: ");
        String nombreActorInput = sc.nextLine();
        String peliculasActor = "SELECT p.nombre AS pelicula FROM peliculas p " +
                                "JOIN peliculas_actores pa ON p.id = pa.id_pelicula " +
                                "JOIN actores a ON pa.id_actor = a.id WHERE a.nombre = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(peliculasActor)) { //Evitar el SQL Injection con PreparedStatement
            preparedStatement.setString(1, nombreActorInput);
            try (ResultSet rs1 = preparedStatement.executeQuery()) {
                boolean hayResultado = false;

                while (rs1.next()) { // Seguir leyendo filas hasta que no haya más
                    hayResultado = true;
                    System.out.println(rs1.getString("pelicula"));
                }

                if (!hayResultado) {
                    System.out.println("No se encontraron películas para el actor: " + nombreActorInput);
                }
            }
        }
    }

    private static void mostrarPeliculasActoresDirectores(Connection dbConnection) throws SQLException {
        String actorPeliculaDirector = "SELECT d.nombre AS director, p.nombre AS pelicula, " +
                                       "a.nombre AS actor_nombre, a.apellido AS actor_apellido " +
                                       "FROM peliculas p " +
                                       "JOIN directores_peliculas dp ON p.id = dp.id_pelicula " +
                                       "JOIN directores d ON dp.id_director = d.id " +
                                       "JOIN peliculas_actores pa ON p.id = pa.id_pelicula " +
                                       "JOIN actores a ON pa.id_actor = a.id";

        try (PreparedStatement statement = dbConnection.prepareStatement(actorPeliculaDirector);
             ResultSet rs2 = statement.executeQuery()) {

            while (rs2.next()) {
                System.out.println("Director: " + rs2.getString("director") + 
                                   ", Película: " + rs2.getString("pelicula") + 
                                   ", Actor: " + rs2.getString("actor_nombre") + " " + 
                                   rs2.getString("actor_apellido"));
            }
        }
    }

    private static void contarPeliculasPorActor(Connection dbConnection, Scanner sc) throws SQLException {
        System.out.println("Introduzca el nombre del actor: ");
        String nomActorInput = sc.nextLine();
        String peliculasActorCount = "SELECT COUNT(p.id) AS cantidad_peliculas FROM peliculas p " +
                                     "JOIN peliculas_actores pa ON p.id = pa.id_pelicula " +
                                     "JOIN actores a ON pa.id_actor = a.id WHERE a.nombre = ?";

        try (PreparedStatement preparedStatement = dbConnection.prepareStatement(peliculasActorCount)) {
            preparedStatement.setString(1, nomActorInput);
            try (ResultSet rs3 = preparedStatement.executeQuery()) {
                if (rs3.next()) {
                    int cantidadPeliculas = rs3.getInt("cantidad_peliculas");
                    System.out.println("Cantidad de películas del actor " + nomActorInput + ": " + cantidadPeliculas);
                } else {
                    System.out.println("No se encontraron resultados.");
                }
            }
        }
    }
}
