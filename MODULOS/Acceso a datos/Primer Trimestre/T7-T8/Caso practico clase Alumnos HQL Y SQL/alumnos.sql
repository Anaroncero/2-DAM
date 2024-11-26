-- Crear y usa la base de datos "EjercicioAlumnos"
DROP DATABASE IF EXISTS EjercicioAlumnos;
CREATE DATABASE EjercicioAlumnos;
USE EjercicioAlumnos;
-- Crear la tabla "Alumno"
CREATE TABLE Alumno (
    IdAlumno INT auto_increment PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
Edad INT NOT NULL
);
-- Insertar clientes ficticios
INSERT INTO Alumno (Nombre,Edad)
VALUES
('Federico', '25'),
('Marina', '24');