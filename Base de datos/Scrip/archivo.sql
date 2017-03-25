create database if not exists panichicha;
use panichicha

CREATE TABLE  CLIENTES (
	COD_CLIENTE tinyint(3) auto_increment not null, 
	NOMBREYAPELLIDO VARCHAR(50) not null,
	CLIENTE_HABITUAL set('s','n') not null, 
	DESCUENTO tinyint(2) not null, 
	PRIMARY KEY (COD_CLIENTE));

CREATE TABLE PRODUCTOS(	
	COD_PRODUCTO tinyint(3) auto_increment not null, 
	DESCRIPCION VARCHAR(40) not null, 
	PRECIO DECIMAL(4,2) NOT NULL, 
	PRIMARY KEY (COD_PRODUCTO));


CREATE TABLE VENTAS(	
	ID tinyint(3) auto_increment NOT NULL, 
	FECHA DATE NOT NULL, 
	COD_CLIENTE tinyint(3) not null, 
	CAMARERO tinyint(3) NOT NULL, 
	TOTAL DECIMAL(4,2) NOT NULL, 
	descuento tinyint(2),
	PRIMARY KEY (ID),
	FOREIGN KEY (COD_CLIENTE) REFERENCES CLIENTES (COD_CLIENTE));

CREATE TABLE TICKET (
	ID tinyint(3) not null, 
	COD_PRODUCTO tinyint(3) not null, 
	CANTIDAD tinyint(3) not null, 
	primary key(ID,COD_PRODUCTO),
	FOREIGN KEY (ID) REFERENCES VENTAS (ID), 
	FOREIGN KEY (COD_PRODUCTO) REFERENCES PRODUCTOS (COD_PRODUCTO));
