
-- Creación y uso de la base de datos "EjercicioProductos"

DROP DATABASE IF EXISTS EjercicioProductos;

CREATE DATABASE EjercicioProductos;

USE EjercicioProductos;

 

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

('Producto1', 10, 50),

('Producto2', 20, 30),

('Producto3', 30, 100);