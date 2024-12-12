DROP DATABASE IF EXISTS TipoA;
CREATE DATABASE TipoA;
USE TipoA;

CREATE TABLE Pokemon (
    IdPokemon 	INT Auto_Increment PRIMARY KEY,
    Nombre 		VARCHAR(255) NOT NULL,
    Estatura 	INT NOT NULL,
    Peso		INT NOT NULL
);

 
INSERT INTO Pokemon (Nombre, Estatura, Peso)
VALUES
("Pikachu" , 20, 60),
("Snorlax" ,100,200),
("Gyarados",500,250);


