INSERT INTO peliculas(nombre, anio) VALUES('Titanic', 1997);
INSERT INTO peliculas(nombre, anio) VALUES('La maldición de la Perla Negra', 2003);
INSERT INTO peliculas(nombre, anio) VALUES('Piratas del Caribe: La venganza de Salazar', 2017);
INSERT INTO peliculas(nombre, anio) VALUES('Fast & Furious', 2001);
INSERT INTO peliculas(nombre, anio) VALUES('Fast X', 2003);
INSERT INTO peliculas(nombre, anio) VALUES('Crepúsculo', 2008);
INSERT INTO peliculas(nombre, anio) VALUES('La Saga Crepúsculo: Amanecer - Parte 2', 2012);
INSERT INTO peliculas(nombre, anio) VALUES('Iron Man 3', 2013);
INSERT INTO peliculas(nombre, anio) VALUES('Capitán América: El Soldado de Invierno', 2014);
INSERT INTO peliculas(nombre, anio) VALUES('Deadpool', 2016);
INSERT INTO peliculas(nombre, anio) VALUES('Deadpool 3', 2024);
INSERT INTO peliculas(nombre, anio) VALUES('Top Gun', 1986);
INSERT INTO peliculas(nombre, anio) VALUES('Misión: Imposible', 1996);
INSERT INTO peliculas(nombre, anio) VALUES('Misión: Imposible - Fallout', 2018);

INSERT INTO actores(nombre, apellido) VALUES('Leonardo', 'DiCaprio');
INSERT INTO actores(nombre, apellido) VALUES('Kate', 'Windslet');
INSERT INTO actores(nombre, apellido) VALUES('Johnny Depp', 'Depp');
INSERT INTO actores(nombre, apellido) VALUES('Orlando', 'Bloom');
INSERT INTO actores(nombre, apellido) VALUES('Vin', 'Diesel');
INSERT INTO actores(nombre, apellido) VALUES('Paul', 'Walker');
INSERT INTO actores(nombre, apellido) VALUES('Kristen', 'Stewart');
INSERT INTO actores(nombre, apellido) VALUES('Robert', 'Pattinson');
INSERT INTO actores(nombre, apellido) VALUES('Robert', 'Downey');
INSERT INTO actores(nombre, apellido) VALUES('Gwyneth', 'Paltrow');
INSERT INTO actores(nombre, apellido) VALUES('Chris', 'Evans');
INSERT INTO actores(nombre, apellido) VALUES('Scarlett', 'Johansson');
INSERT INTO actores(nombre, apellido) VALUES('Ryan', 'Reynolds');
INSERT INTO actores(nombre, apellido) VALUES('Morena', 'Baccarin');
INSERT INTO actores(nombre, apellido) VALUES('Tom', 'Cruise');
INSERT INTO actores(nombre, apellido) VALUES('Kelly', 'McGillis');
INSERT INTO actores(nombre, apellido) VALUES('Tom', 'Cruise');
INSERT INTO actores(nombre, apellido) VALUES('Henry', 'Cavill');

INSERT INTO directores(nombre) VALUES('James Cameron');
INSERT INTO directores(nombre) VALUES('Gore Verbinski');
INSERT INTO directores(nombre) VALUES('Joachim Rønning');
INSERT INTO directores(nombre) VALUES('Rob Cohen');
INSERT INTO directores(nombre) VALUES('Louis Leterrier');
INSERT INTO directores(nombre) VALUES('Catherine Hardwicke');
INSERT INTO directores(nombre) VALUES('Bill Condon');
INSERT INTO directores(nombre) VALUES('Shane Black');
INSERT INTO directores(nombre) VALUES('Anthony y Joe Russo');
INSERT INTO directores(nombre) VALUES('Tim Miller');
INSERT INTO directores(nombre) VALUES('Shawn Levy');
INSERT INTO directores(nombre) VALUES('Tony Scott');
INSERT INTO directores(nombre) VALUES('Brian De Palma');
INSERT INTO directores(nombre) VALUES('Christopher McQuarrie');


-- Insert peliculas actores
-- Titanic
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (1, 1); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (1, 2); 
-- La maldición de la Perla Negra
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (2, 3); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (2, 4);
-- Piratas del Caribe: La venganza de Salazar
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (3, 3);
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (3, 4); 
-- Fast & Furious: Vin Diesel
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (4, 5); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (4, 6); 
-- Fast X
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (5, 5); 
 -- Crepúsculo
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (6, 7);  
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (6, 8); 
-- La Saga Crepúsculo: Amanecer
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (7, 7); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (7, 8); 
-- Iron Man 3
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (8, 9); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (8, 10); 
-- Capitán América
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (9, 11); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (9, 12);  
-- Deadpool
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (10, 13); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (10, 14); 
-- Deadpool 3
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (11, 13); 
-- Top Gun
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (12, 15); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (12, 16); 
-- Misión: Imposible
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (13, 15); 
INSERT INTO peliculas_actores (id_pelicula, id_actor) VALUES (14, 15); 

-- Relación entre directores y 
-- Titanic
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (1, 1); 
-- La maldición de la Perla Negra
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (2, 2); 
-- Piratas del Caribe: La venganza de Salazar
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (3, 3); 
-- Fast & Furious
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (4, 4);
-- Fast X
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (5, 5);
-- Crepúsculo
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (6, 6); 
-- La Saga Crepúsculo: Amanecer - Parte 2
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (7, 7); 
-- Iron Man 3
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (8, 8); 
-- Capitán América: El Soldado de Invierno
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (9, 9); 
-- Deadpool
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (10, 10); 
-- Deadpool 3
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (11, 11);
-- Top Gun
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (12, 12); 
-- Misión: Imposible
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (13, 13); 
--  Misión: Imposible - Fallout
INSERT INTO directores_peliculas (id_director, id_pelicula) VALUES (14, 14); 
