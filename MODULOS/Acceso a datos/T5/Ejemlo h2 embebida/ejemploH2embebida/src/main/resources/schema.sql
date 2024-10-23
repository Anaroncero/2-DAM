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
