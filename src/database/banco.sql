DROP DATABASE IF EXISTS supermercado;

CREATE DATABASE supermercado;

USE supermercado;

CREATE TABLE IF NOT EXISTS usuarios(
	
cpf VARCHAR (11) PRIMARY KEY NOT NULL,
nome VARCHAR(100) NOT NULL,
usuario VARCHAR(100) NOT NULL UNIQUE,
adm boolean not null
);

CREATE TABLE IF NOT EXISTS insumos(
	

nome VARCHAR (100) NOT NULL,
marca VARCHAR (100) NOT NULL,
fornecedora VARCHAR (100) NOT NULL,
descricao VARCHAR (500) NOT NULL,
valor DECIMAL (10,2) NOT NULL,
quantidade INT NOT NULL,
codigoBarras BIGINT PRIMARY KEY NOT NULL

);

use supermercado;
insert into insumos values 
("Biscoito", "Isabela", "Bolinhos e docinhos", "Biscoito de maizena", 6.50, 20, 123456789), 
("Macarrão", "Galo", "Amassas", "Macarrão espaguete", 12.50, 30, 987654321), 
("Arroz", "Tio João", "DaFazzenda","Arroz branco", 10.00, 60, 876543219),
("Feijão", "Kika", "DaFazzenda","Feijão preto", 6.99, 40, 765432189);


insert into usuarios values
("12345678900", "Camila Vitoria Tedesco", "camila", false),
("98765432100", "Júlia C Otero Luiz", "julia", true),
("00123456789", "Lara C de Souza", "lara", false),
("00987654321", "Emanuela Z Vieira", "emanuela", true);

select * from insumos;