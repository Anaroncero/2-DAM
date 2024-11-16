import java.sql.*;
import java.util.Scanner;

public class ProductoManager {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL_CONEXION = "jdbc:mysql://localhost:3306/database_script";
    private static final String USUARIO = "root"; 
    private static final String PASSWORD = "Med@c";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Insertar nuevo cliente");
            System.out.println("2. Mostrar todos los clientes");
            System.out.println("3. Insertar nuevo producto");
            System.out.println("4. Insertar nuevo pedido");
            System.out.println("5. Consultar cliente por ID");
            System.out.println("6. Consultar detalles de pedidos por cliente");
            System.out.println("7. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    insertarClienteDesdeConsola();
                    break;
                case 2:
                    mostrarClientes();
                    break;
                case 3:
                    insertarProductoDesdeConsola();
                    break;
                case 4:
                    insertarPedidoDesdeConsola();
                    break;
                case 5:
                    consultarClientePorId();
                    break;
                case 6:
                    consultarDetallesPedidosPorCliente();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        }
    }

    private static void insertarClienteDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar información del cliente:");
        int customerId = 0;

        try {
            customerId = obtenerNuevoId("CUSTOMER", "customer_id"); // Obtener nuevo ID
            System.out.print("Nombre: ");
            String firstName = scanner.nextLine();
            System.out.print("Apellido: ");
            String lastName = scanner.nextLine();
            System.out.print("Edad: ");
            int age = scanner.nextInt();

            insertarCliente(customerId, firstName, lastName, age);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al insertar el cliente: " + e.getMessage());
        }
    }

    private static void insertarCliente(int customerId, String firstName, String lastName, int age)
            throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;

        try {
            dbConnection = obtenerConexion();
            dbConnection.setAutoCommit(false); // Deshabilitar el modo autocommit

            // Insertar el cliente
            String insertClienteSQL = "INSERT INTO CUSTOMER (customer_id, first_name, last_name, age) VALUES (?, ?, ?, ?)";
            PreparedStatement clienteStatement = dbConnection.prepareStatement(insertClienteSQL);
            clienteStatement.setInt(1, customerId);
            clienteStatement.setString(2, firstName);
            clienteStatement.setString(3, lastName);
            clienteStatement.setInt(4, age);

            int filasAfectadasCliente = clienteStatement.executeUpdate();

            // Confirmar la transacción si la inserción es exitosa
            if (filasAfectadasCliente > 0) {
                dbConnection.commit(); // Confirma la transacción
                System.out.println("Cliente insertado con éxito.");
            } else {
                System.out.println("No se pudo insertar el cliente.");
                dbConnection.rollback(); // Deshacer la transacción en caso de fallo
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (dbConnection != null) {
                dbConnection.rollback(); // Deshacer la transacción en caso de error
            }
        } finally {
            cerrarConexion(dbConnection);
        }
    }

    private static void mostrarClientes() {
        Connection dbConnection = null;

        try {
            dbConnection = obtenerConexion();
            Statement statement = dbConnection.createStatement();
            String selectTableSQL = "SELECT * FROM CUSTOMER";
            ResultSet rs = statement.executeQuery(selectTableSQL);

            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String nombre = rs.getString("first_name");
                String apellido = rs.getString("last_name");
                int edad = rs.getInt("age");
                System.out.println("ID Cliente: " + id);
                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Edad: " + edad);
                System.out.println("------------------------");
            }

        } catch (SQLException e) {
            System.out.println("Error al mostrar los datos de los clientes: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador de la base de datos: " + e.getMessage());
        } finally {
            cerrarConexion(dbConnection); // Cerrar la conexión al finalizar
        }
    }

    private static void insertarProductoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar información del producto:");
        int productId = 0;

        try {
            productId = obtenerNuevoId("PRODUCT", "product_id"); // Obtener nuevo ID

            System.out.print("Nombre del producto: ");
            String productName = scanner.nextLine();
            System.out.print("Precio: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer
            System.out.print("Categoría: ");
            String category = scanner.nextLine();

            insertarProducto(productId, productName, price, category);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al insertar el producto: " + e.getMessage());
        }
    }

    private static void insertarProducto(int productId, String productName, double price, String category)
            throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;

        try {
            dbConnection = obtenerConexion();
            dbConnection.setAutoCommit(false); // Deshabilitar el modo autocommit

            // Insertar el producto
            String insertProductoSQL = "INSERT INTO PRODUCT (product_id, product_name, price, category) VALUES (?, ?, ?, ?)";
            PreparedStatement productoStatement = dbConnection.prepareStatement(insertProductoSQL);
            productoStatement.setInt(1, productId);
            productoStatement.setString(2, productName);
            productoStatement.setDouble(3, price);
            productoStatement.setString(4, category);

            int filasAfectadasProducto = productoStatement.executeUpdate();

            // Confirmar la transacción si la inserción es exitosa
            if (filasAfectadasProducto > 0) {
                dbConnection.commit(); // Confirma la transacción
                System.out.println("Producto insertado con éxito.");
            } else {
                System.out.println("No se pudo insertar el producto.");
                dbConnection.rollback(); // Deshacer la transacción en caso de fallo
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (dbConnection != null) {
                dbConnection.rollback(); // Deshacer la transacción en caso de error
            }
        } finally {
            cerrarConexion(dbConnection);
        }
    }

    private static void insertarPedidoDesdeConsola() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar información del pedido:");
        
        try {
            int orderId = obtenerNuevoId("ORDERS", "order_id"); // Obtener nuevo ID automáticamente
            System.out.print("ID del cliente: ");
            int customerId = scanner.nextInt();
            System.out.print("ID del producto: ");
            int productId = scanner.nextInt();
            System.out.print("Cantidad: ");
            int quantity = scanner.nextInt();

            // Llamar al método para insertar el pedido
            insertarPedido(orderId, customerId, productId, quantity);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Error al insertar el pedido: " + e.getMessage());
        }
    }

    private static void insertarPedido(int orderId, int customerId, int productId, int quantity)
            throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;

        try {
            dbConnection = obtenerConexion();
            dbConnection.setAutoCommit(false); // Deshabilitar el modo autocommit

            // Insertar el pedido
            String insertPedidoSQL = "INSERT INTO ORDERS (order_id, customer_id, product_id, quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement pedidoStatement = dbConnection.prepareStatement(insertPedidoSQL);
            pedidoStatement.setInt(1, orderId);
            pedidoStatement.setInt(2, customerId);
            pedidoStatement.setInt(3, productId);
            pedidoStatement.setInt(4, quantity);

            int filasAfectadasPedido = pedidoStatement.executeUpdate();

            // Confirmar la transacción si la inserción es exitosa
            if (filasAfectadasPedido > 0) {
                dbConnection.commit(); // Confirma la transacción
                System.out.println("Pedido insertado con éxito.");
            } else {
                System.out.println("No se pudo insertar el pedido.");
                dbConnection.rollback(); // Deshacer la transacción en caso de fallo
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            if (dbConnection != null) {
                dbConnection.rollback(); // Deshacer la transacción en caso de error
            }
        } finally {
            cerrarConexion(dbConnection);
        }
    }

    private static void consultarClientePorId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        int customerId = scanner.nextInt();

        Connection dbConnection = null;

        try {
            dbConnection = obtenerConexion();
            String selectSQL = "SELECT * FROM CUSTOMER WHERE customer_id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                System.out.println("ID Cliente: " + rs.getInt("customer_id"));
                System.out.println("Nombre: " + rs.getString("first_name"));
                System.out.println("Apellido: " + rs.getString("last_name"));
                System.out.println("Edad: " + rs.getInt("age"));
            } else {
                System.out.println("Cliente no encontrado.");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar el cliente: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador de la base de datos: " + e.getMessage());
        } finally {
            cerrarConexion(dbConnection);
        }
    }

    private static void consultarDetallesPedidosPorCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del cliente: ");
        int customerId = scanner.nextInt();

        Connection dbConnection = null;

        try {
            dbConnection = obtenerConexion();
            String selectSQL = "SELECT o.order_id, o.quantity, p.product_name, p.price " +
                    "FROM ORDERS o JOIN PRODUCT p ON o.product_id = p.product_id " +
                    "WHERE o.customer_id = ?";
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();

            double total = 0.0;
            boolean tienePedidos = false;

            while (rs.next()) {
                tienePedidos = true;
                int orderId = rs.getInt("order_id");
                int quantity = rs.getInt("quantity");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");

                double totalPorPedido = quantity * price;
                total += totalPorPedido;

                System.out.println("ID Pedido: " + orderId);
                System.out.println("Producto: " + productName);
                System.out.println("Cantidad: " + quantity);
                System.out.println("Precio Total: " + totalPorPedido);
                System.out.println("------------------------");
            }

            if (tienePedidos) {
                System.out.println("Precio total de todos los pedidos: " + total);
            } else {
                System.out.println("No se encontraron pedidos para este cliente.");
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar los pedidos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador de la base de datos: " + e.getMessage());
        } finally {
            cerrarConexion(dbConnection);
        }
    }

    private static int obtenerNuevoId(String tabla, String columna) throws SQLException, ClassNotFoundException {
        Connection dbConnection = null;
        int nuevoId = 1; // Valor por defecto

        try {
            dbConnection = obtenerConexion();
            String selectSQL = "SELECT MAX(" + columna + ") AS max_id FROM " + tabla;
            PreparedStatement preparedStatement = dbConnection.prepareStatement(selectSQL);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                nuevoId = rs.getInt("max_id") + 1; // Incrementar el ID máximo
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el nuevo ID: " + e.getMessage());
        } finally {
            cerrarConexion(dbConnection);
        }

        return nuevoId; // Retornar el nuevo ID
    }

    private static Connection obtenerConexion() throws SQLException, ClassNotFoundException {
        Class.forName(DRIVER); 
        return DriverManager.getConnection(URL_CONEXION, USUARIO, PASSWORD);
    }

    private static void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
