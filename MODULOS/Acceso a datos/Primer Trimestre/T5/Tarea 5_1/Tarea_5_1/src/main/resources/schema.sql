CREATE TABLE IF NOT EXISTS peliculas (
	id int auto_increment primary key,
	nombre varchar(100) not null,
    anio int not null
);

CREATE TABLE IF NOT EXISTS actores (
	id int auto_increment primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null
);

CREATE TABLE IF NOT EXISTS directores (
	id int auto_increment primary key,
    nombre varchar(50) not null
);

CREATE TABLE IF NOT EXISTS peliculas_actores (
	id_pelicula int,
    id_actor int,
    
    PRIMARY KEY(id_pelicula, id_actor),
    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id),
    FOREIGN KEY (id_actor) REFERENCES actores(id)
);

CREATE TABLE IF NOT EXISTS directores_peliculas (
	id_director int,
    id_pelicula int,
    
    PRIMARY KEY(id_director, id_pelicula),
    FOREIGN KEY (id_director) REFERENCES directores(id),
    FOREIGN KEY (id_pelicula) REFERENCES peliculas(id)
);
