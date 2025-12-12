-- 1. Crear la Base de Datos (Coincide con tu conexionDB.java)
CREATE DATABASE IF NOT EXISTS alicorpdb; 
USE alicorpdb;

-- 2. Tabla Usuario (Para el Login - RQN-01)
CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(50) NOT NULL, -- 'Administrador', 'Ventas', 'Produccion'
    clave VARCHAR(100) NOT NULL
);

-- Insertar usuarios de prueba (CLAVES PARA TODOS: 1234)
INSERT INTO Usuario (nombre, rol, clave) VALUES 
('Admin', 'Administrador', '1234'),
('Vendedor1', 'Ventas', '1234'),
('ProdSupervisor', 'Produccion', '1234');

-- 3. Tabla Almacen (Para multi-almacén - RQF-03)
CREATE TABLE Almacen (
    idAlmacen INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    ubicacion VARCHAR(150)
);
INSERT INTO Almacen (nombre, ubicacion) VALUES ('Central Lima', 'Av. Argentina 123');

-- 4. Tabla Inventario (Tabla auxiliar para el Modelo de Inventario, que se conecta con Producto)
CREATE TABLE Inventario (
    idInventario INT AUTO_INCREMENT PRIMARY KEY,
    stockActual INT,
    idAlmacen INT,
    FOREIGN KEY (idAlmacen) REFERENCES Almacen(idAlmacen)
);

-- 5. Tabla Producto (Base del negocio)
CREATE TABLE Producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    unidad VARCHAR(20), 
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL, 
    idInventario INT NULL,
    FOREIGN KEY (idInventario) REFERENCES Inventario(idInventario)
);

-- Insertar productos de prueba para poder hacer pedidos
INSERT INTO Producto (nombre, unidad, precio, stock) VALUES 
('Aceite Primor 1L', 'Botella', 12.50, 100),
('Fideos Don Vittorio', 'Paquete', 4.20, 500),
('Detergente Bolivar', 'Bolsa', 15.00, 200);

-- 6. Tabla Cliente (Ya cubierta en el código)
CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    ruc CHAR(11),
    direccion VARCHAR(150),
    email VARCHAR(100)
);

-- 7. Tablas Pedido y DetallePedido (Ya cubiertas en el código)
CREATE TABLE Pedido (
    idPedido INT AUTO_INCREMENT PRIMARY KEY,
    fecha DATE,
    estado VARCHAR(20) DEFAULT 'Pendiente', 
    total DECIMAL(10,2),
    idCliente INT,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE DetallePedido (
    idDetalle INT AUTO_INCREMENT PRIMARY KEY,
    idPedido INT,
    idProducto INT,
    cantidad INT,
    precioUnitario DECIMAL(10,2),
    FOREIGN KEY (idPedido) REFERENCES Pedido(idPedido),
    FOREIGN KEY (idProducto) REFERENCES Producto(idProducto)
);

-- 8. Tabla OrdenProduccion (Para la parte industrial - RQF-05)
CREATE TABLE OrdenProduccion (
    idOrden INT AUTO_INCREMENT PRIMARY KEY,
    fechaInicio DATE,
    fechaFin DATE,
    estado VARCHAR(20) DEFAULT 'Pendiente', 
    idProductoObjetivo INT NOT NULL, 
    cantidadObjetivo INT NOT NULL,
    FOREIGN KEY (idProductoObjetivo) REFERENCES Producto(idProducto)
);

-- 9. Tabla Lote (Para trazabilidad y calidad - RQF-04, RQF-06)
CREATE TABLE Lote (
    idLote INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(50) NOT NULL,
    fechaFabricacion DATE,
    fechaVencimiento DATE,
    estado VARCHAR(20) DEFAULT 'Cuarentena', -- 'Cuarentena', 'Liberado', 'Rechazado'
    idOrden INT,
    FOREIGN KEY (idOrden) REFERENCES OrdenProduccion(idOrden)
);