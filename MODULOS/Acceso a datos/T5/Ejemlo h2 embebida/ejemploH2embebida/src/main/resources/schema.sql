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
 

ALTER TABLE usuarios add column rol_id int;

ALTER TABLE usuarios add constraint fk_rol foreign key(rol_id) references roles(id);
