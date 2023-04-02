DROP TABLE IF EXISTS categorias;
CREATE TABLE IF NOT EXISTS categorias (id serial primary key, nombre varchar(100) NOT NULL, descripcion varchar(100));