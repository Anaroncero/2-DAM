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
