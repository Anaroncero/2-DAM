import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    private static final String driver = "com.mysql.cj.jbc.Driver";
    private static final String url_conexion = "jdbc:mysql://localhost:3306/prueba";

    public static void main(String[] args) {
        
        //Conectamos a la bbdd
        final String usuario = "root";
        final String password = "Med@c";
        Connection dbConnection = null;
        Statement statement = null;

        try {

            ClassforName(driver);
            dbConnection = DriverManager.getConnection(url_conexion, usuario, password);
            String consulta = "SELECT p.titulo AS Titulo_Pelicula, a.nombre AS Nombre_Actor, a.apellidos AS Apellidos_Actor\n" + //
                                "FROM peliculas p\n" + //
                                "JOIN peliculas_actores pa ON p.id = pa.id_pelicula\n" + //
                                "JOIN actores a ON pa.id_actor = a.id;";
            statement = dbConnection.createStatement();
            ResulSet rs = statement.excuteQuery(consulta);

        } catch (Exception e) {
            
        }

    }
}