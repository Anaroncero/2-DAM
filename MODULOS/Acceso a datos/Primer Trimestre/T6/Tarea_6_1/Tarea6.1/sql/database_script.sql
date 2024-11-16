-- Ana Pastor Roncero
-- He añadido esto para que funcione
DROP DATABASE IF EXISTS database_script;
CREATE DATABASE database_script;
USE database_script;

-- Create CUSTOMER table
CREATE TABLE CUSTOMER (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT
);

-- Create ADDRESS table
CREATE TABLE ADDRESS (
    address_id INT PRIMARY KEY,
    customer_id INT,
    street VARCHAR(100),
    city VARCHAR(50),
    zipcode VARCHAR(10),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id)
);

-- Create PRODUCT table
CREATE TABLE PRODUCT (
    product_id INT PRIMARY KEY,
    product_name VARCHAR(100),
    price DECIMAL(10, 2),
    category VARCHAR(50)
);

-- Create ORDER table
CREATE TABLE ORDERS (
    order_id INT PRIMARY KEY,
    customer_id INT,
    product_id INT,
    order_date DATE,
    quantity INT,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);

-- Insert sample data into CUSTOMER
INSERT INTO CUSTOMER (customer_id, first_name, last_name, age) VALUES
(1, 'Juan', 'Gomez', 28),
(2, 'Maria', 'Lopez', 35),
(3, 'Pedro', 'Martinez', 42),
(4, 'Ana', 'Sanchez', 30),
(5, 'Luis', 'Perez', 27);

-- Insert sample data into ADDRESS
INSERT INTO ADDRESS (address_id, customer_id, street, city, zipcode) VALUES
(1, 1, 'Calle Falsa 123', 'Málaga', '29001'),
(2, 2, 'Avenida Real 45', 'Sevilla', '41001'),
(3, 3, 'Plaza Mayor 22', 'Granada', '18001'),
(4, 4, 'Calle Alta 8', 'Córdoba', '14001'),
(5, 5, 'Calle Baja 9', 'Jaén', '23001');

-- Insert sample data into PRODUCT
INSERT INTO PRODUCT (product_id, product_name, price, category) VALUES
(1, 'Producto A', 15.99, 'Electrónica'),
(2, 'Producto B', 35.50, 'Hogar'),
(3, 'Producto C', 50.00, 'Electrónica'),
(4, 'Producto D', 20.00, 'Jardinería'),
(5, 'Producto E', 70.99, 'Electrónica');

-- Insert sample data into ORDERS
INSERT INTO ORDERS (order_id, customer_id, product_id, order_date, quantity) VALUES
(1, 1, 1, '2023-09-10', 2),
(2, 2, 3, '2023-09-12', 1),
(3, 3, 2, '2023-09-13', 4),
(4, 4, 5, '2023-09-14', 1),
(5, 5, 4, '2023-09-15', 3);

DELIMITER //

CREATE PROCEDURE AddCustomerAndOrder()
BEGIN
    -- Iniciar la transacción
    START TRANSACTION;

    SET @customer_id = 6;

    -- Verificar si el cliente ya existe
    SELECT COUNT(*) INTO @exists FROM CUSTOMER WHERE customer_id = @customer_id;

    -- Intentar insertar el cliente solo si no existe
    INSERT INTO CUSTOMER (customer_id, first_name, last_name, age)
    VALUES (@customer_id, 'Sofia', 'Martinez', 29)
    ON DUPLICATE KEY UPDATE customer_id = customer_id; -- No hace nada si existe

    -- Comprobar si la inserción fue exitosa
    IF @exists = 0 THEN
        -- Insertar el pedido solo si el cliente fue insertado
        INSERT INTO ORDERS (order_id, customer_id, product_id, order_date, quantity)
        VALUES (6, @customer_id, 2, '2023-10-30', 2);

        -- Hacer commit
        COMMIT;
        SELECT 'Transacción completada exitosamente' AS Message;
    ELSE
        -- Hacer rollback si el cliente ya existe
        ROLLBACK;
        SELECT 'El cliente ya existe. Se han revertido los cambios.' AS Message;
    END IF;
END //

ALTER TABLE PRODUCT MODIFY product_id INT AUTO_INCREMENT;

DELIMITER ;
