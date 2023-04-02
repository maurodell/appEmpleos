DROP TABLE IF EXISTS categoria;
CREATE TABLE IF NOT EXISTS categoria (id serial primary key, nombre varchar(100) NOT NULL, descripcion varchar(100));