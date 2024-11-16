package CasoPractico_Acceder_a_distintas_BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/* Ana */
public class DBConnection {

    public static void main(String[] args) {
        // Ejemplo de uso
        DBConnection dbConnection = new DBConnection();
        Connection conn = dbConnection.getDBConnection("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/tu_base_de_datos", "usuario", "contraseña");

        if (conn != null) {
            System.out.println("Conexión exitosa!");
        } else {
            System.out.println("Error al conectar.");
        }
    }
    


    // Método
    private Connection getDBConnection(String driver, String url, String usuario, String password){

        Connection connection = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, usuario, password);

        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
    
}