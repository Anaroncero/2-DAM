DROP DATABASE prueba;
CREATE DATABASE prueba;
use prueba;

CREATE TABLE usuarios (
	id int auto_increment primary key,
    username varchar(20) not null,
    nombre varchar(25) not null,
    clave varchar(20) not null
    
);

CREATE TABLE roles(
	id int auto_increment primary key,
    rol varchar(50) not null
);
 
-- Un usuario tiene un rol, un rol tiene varios usuarios: N:1
-- añadimos una nueva clumna a la tabla usuarios para relacionarla con la tabla roles
ALTER TABLE usuarios add column rol_id int;

-- la tabla usuarios hace referencia a la tabla roles. Clave foranea en rol_id de la tabla usuarios que referencia a la tabla roles al campo id
ALTER TABLE usuarios add constraint fk_rol foreign key(rol_id) references roles(id);

-- Introducir un rol
INSERT INTO roles(rol) values ('profesor');

-- Introducir varios roles
INSERT INTO roles(rol) values ('Alumno'), ('Secretario'), ('Técnico');

-- Introducir un usuario
INSERT INTO usuarios(username, nombre, clave, rol_id) VALUES ("MartaP", "Marta", "12345Medac", 2);
INSERT INTO usuarios(username, nombre, clave, rol_id) VALUES ("AntoñitoN", "Antonio", "12345Medac", 2);
INSERT INTO usuarios(username, nombre, clave, rol_id) VALUES ("RafaRuleta", "Rafa", "12345Medac", 2);
INSERT INTO usuarios(username, nombre, clave, rol_id) values ('CarlosF', 'Carlos', '12345Medac', 1);
INSERT INTO usuarios(username, nombre, clave, rol_id) values ('RoqueSEFUE', 'Roque', '12345Medac', 2);
INSERT INTO usuarios(username, nombre, clave, rol_id) values ('Secretaria1', 'Maria', '12345Medac', 3);
INSERT INTO usuarios(username, nombre, clave, rol_id) values ('YoussJosue', 'Josue', '12345Medac', 4);


select * from usuarios;

