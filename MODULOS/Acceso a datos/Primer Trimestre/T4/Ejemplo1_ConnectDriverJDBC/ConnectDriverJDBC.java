import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
/* Ana */
public class ConnectDriverJDBC {

    // Conexion al driver
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url_conexion = "jdbc:mysql://localhost:3306/prueba";

    public static void main(String[] args) {

        // Variables de las credenciales de la BDD
        final String usuario = "root";
        final String password = "Med@c";
        Connection dbConnection = null;
        Statement statement = null;


        try {
            // Carga el controlador de la base de datos
            Class.forName(driver);
            // Establecer conexión a la base de datos
            dbConnection = DriverManager.getConnection(url_conexion, usuario, password);
            // Definir la consulta SQL que se ejecutara
            String consulta = "SELECT u.*, r.rol FROM usuarios u, roles r where u.rol_id=r.id"; //"SELECT u.id, u.username, u.clave, u.nombre, r.rol FROM usuarios u JOIN roles r ON u.rol_id=r.id";
            // Crear uan declaración para ejecutar la consulta
            statement = dbConnection.createStatement();
            // Ejecutar la consulta almacenada
            ResultSet rs = statement.executeQuery(consulta);

            // Iterar a través de los resultados y mostrar la información
            while (rs.next()) {
                String id = rs.getString("id");
                String username = rs.getString("username");
                String clave = rs.getString("clave");
                String nombre = rs.getString("nombre");
                String rol = rs.getString("rol");
                System.out.println("------------------------------------");
                System.out.println("id: " + id);
                System.out.println("userName: " + username);
                System.out.println("nombre: " + nombre);
                System.out.println("clave: " + clave);
                System.out.println("rol: " + rol);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            //Cerrar conexiones
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando el statement: " + e.getMessage());
            }
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error cerrando la conexión: " + e.getMessage());
            }
        }
    }
}
