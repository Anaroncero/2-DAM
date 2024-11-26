-- Creación y uso de la base de datos "ProductosEjercicio"
DROP DATABASE IF EXISTS ProductosEjercicio;
CREATE DATABASE ProductosEjercicio;
USE ProductosEjercicio;

-- Crear la tabla "Productos"
CREATE TABLE Productos (
    ID_Producto INT Auto_Increment PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Precio INT NOT NULL,
    Stock INT NOT NULL
);

-- Insertar productos 
INSERT INTO Productos (Nombre, Precio, Stock)
VALUES
('Producto 1', 10, 50),
('Producto 2', 20, 30),
('Producto 3', 30, 100);