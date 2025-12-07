DROP DATABASE IF EXISTS panaderia_base;

-- CREACIÓN DE BASE DE DATOS
CREATE DATABASE panaderia_base;
USE panaderia_base;

-------------------------------------------------------------------------------
-- 1) CLIENTES
-------------------------------------------------------------------------------
CREATE TABLE clientes (
    Id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    tipo_cliente TINYINT NOT NULL,
    porcentaje_descuento DECIMAL(5,2) NULL
);

-------------------------------------------------------------------------------
-- 4) CARGOS
-------------------------------------------------------------------------------
CREATE TABLE cargos (
    Id_cargo INT PRIMARY KEY AUTO_INCREMENT,
    nombre_cargo VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    permisos INT NOT NULL
);
INSERT INTO cargos (nombre_cargo, descripcion, permisos) VALUES
('Panadero', 'Encargado de la elaboración de productos de panadería', 2),
('Cajero', 'Atención al cliente y manejo de ventas', 1),
('Gerente', 'Supervisión general de operaciones', 3);

-- 4. Verificar que se insertaron correctamente
SELECT * FROM cargos;

-------------------------------------------------------------------------------
-- 5) EMPLEADOS
-------------------------------------------------------------------------------
CREATE TABLE empleados (
    Id_empleado INT PRIMARY KEY,
    apellidos VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    fecha_contratacion DATE NOT NULL,
    sueldo DECIMAL(10,2) NOT NULL,
    horas INT NOT NULL,
    password VARCHAR(100) NOT NULL,
    Id_cargo INT NOT NULL,
    Id_jefe_directo INT NULL,
    activo TINYINT NOT NULL,
    fecha_baja DATE NULL,
    motivo_baja TEXT NULL
);

INSERT INTO empleados (Id_empleado, apellidos, nombre, telefono, fecha_contratacion, sueldo, horas, password, Id_cargo, Id_jefe_directo, activo, fecha_baja, motivo_baja) VALUES
(0100015, 'González Pérez', 'Juan Carlos', '5551234567', '2023-01-15', 5000.00, 8, 'Admin123', 1, NULL, 1, NULL, NULL),
(2100120, 'Martínez López', 'Ana María', '5559876543', '2023-03-20', 2000.00, 8, 'Awtuy567', 2, 1, 1, NULL, NULL);
select * from empleados;
delete from empleados where id_empleado = 2100120;
SELECT user, host FROM mysql.user;

-------------------------------------------------------------------------------
-- 8) PRODUCTOS
-------------------------------------------------------------------------------
CREATE TABLE productos (
    Id_producto INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    tiempo_elaboracion INT NOT NULL,
    activo TINYINT NOT NULL
);

-------------------------------------------------------------------------------
-- 9) RECETAS
-------------------------------------------------------------------------------
CREATE TABLE recetas (
    Id_receta INT PRIMARY KEY,
    Id_producto INT NOT NULL,
    nombre_receta VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    tiempo_estimado INT NOT NULL
);

-------------------------------------------------------------------------------
-- 10) PROCESO DE ELABORACIÓN
-------------------------------------------------------------------------------
CREATE TABLE proceso_elaboracion (
    Id_proceso INT PRIMARY KEY,
    Id_receta INT NOT NULL,
    Id_producto INT NOT NULL,
    Id_empleado INT NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    tiempo_estimado INT NULL,
    nombre_operacion VARCHAR(100) NOT NULL,
    descripcion TEXT NULL,
    horas_trabajadas INT NOT NULL
);

-------------------------------------------------------------------------------
-- 2) VENTAS
-------------------------------------------------------------------------------
CREATE TABLE ventas (
    Id_venta INT PRIMARY KEY,
    Id_cliente INT NOT NULL,
    Id_empleado INT NOT NULL,
    tipo_cliente TINYINT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    total_neto DECIMAL(10,2) NOT NULL,
    descuento_aplicado DECIMAL(10,2) NULL,
    iva DECIMAL(10,2) NOT NULL
);

-------------------------------------------------------------------------------
-- 3) DETALLE_VENTAS
-------------------------------------------------------------------------------
CREATE TABLE detalle_ventas (
    Id_detalle_venta INT PRIMARY KEY,
    Id_venta INT NOT NULL,
    Id_producto INT NOT NULL,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    total_fila DECIMAL(10,2) NOT NULL
);

-------------------------------------------------------------------------------
-- 6) EMPLEADOS VENTAS
-------------------------------------------------------------------------------
CREATE TABLE empleados_ventas (
    Id_venta INT NOT NULL,
    Id_empleado INT NOT NULL
);

-------------------------------------------------------------------------------
-- 7) EMPLEADOS PROCESO ELABORACIÓN
-------------------------------------------------------------------------------
CREATE TABLE empleados_proceso_elaboracion (
    Id_empleado INT NOT NULL,
    Id_proceso INT NOT NULL
);

-------------------------------------------------------------------------------
-- 11) PRODUCCION
-------------------------------------------------------------------------------
CREATE TABLE produccion (
    Id_produccion INT PRIMARY KEY,
    Id_producto INT NOT NULL,
    fecha_produccion DATE NOT NULL,
    hora_salida TIME NOT NULL,
    cantidad_producida INT NOT NULL,
    costo DECIMAL(10,2) NOT NULL
);

-------------------------------------------------------------------------------
-- 12) PROVEEDORES
-------------------------------------------------------------------------------
CREATE TABLE proveedores (
    Id_proveedor INT PRIMARY KEY,
    nombre_proveedor VARCHAR(100) NOT NULL,
    direccion VARCHAR(150) NOT NULL,
    numero_telefono VARCHAR(20) NOT NULL
);

-------------------------------------------------------------------------------
-- 14) COMPRAS
-------------------------------------------------------------------------------
CREATE TABLE compras (
    Id_compra INT PRIMARY KEY AUTO_INCREMENT,
    Id_proveedor INT NOT NULL,
    fecha DATE NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    sub_total DECIMAL(10,2) NOT NULL,
    iva DECIMAL(10,2) NOT NULL,
    total DECIMAL(10,2) NOT NULL
);

DESCRIBE compras;
SHOW CREATE TABLE compras;
SELECT * FROM compras LIMIT 5;
-------------------------------------------------------------------------------
-- 13) PROVEEDORES COMPRAS
-------------------------------------------------------------------------------
CREATE TABLE proveedores_compras (
    Id_compra INT NOT NULL,
    Id_proveedor INT NOT NULL
);

-------------------------------------------------------------------------------
-- 16) INVENTARIO
-------------------------------------------------------------------------------
CREATE TABLE inventario (
    Id_inventario INT PRIMARY KEY,
    Id_compra INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    unidad_medida VARCHAR(20) NOT NULL,
    cantidad_disponible DECIMAL(10,2) NOT NULL,
    precio DECIMAL(10,2) NOT NULL
);

INSERT INTO inventario (Id_inventario, Id_compra, nombre, unidad_medida, cantidad_disponible, precio) VALUES
(01, 01, "Azucar", "Kilos", 10.0, 300);
select * from inventario;

-------------------------------------------------------------------------------
-- 15) DETALLE COMPRA
-------------------------------------------------------------------------------
CREATE TABLE detalle_compra (
    Id_detalle_compra INT PRIMARY KEY AUTO_INCREMENT,
    Id_compra INT NOT NULL,
    Id_inventario INT NOT NULL,
    cantidad DECIMAL(10,2) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    costo DECIMAL(10,2) NOT NULL
);

-------------------------------------------------------------------------------
-- 17) COMPONENTES
-------------------------------------------------------------------------------
CREATE TABLE componentes (
    Id_componentes INT PRIMARY KEY,
    Id_inventario INT NOT NULL,
    nombre_componente VARCHAR(100) NOT NULL,
    cantidad_requerida DECIMAL(10,2) NOT NULL
);

-------------------------------------------------------------------------------
-- 18) USO COMPONENTES
-------------------------------------------------------------------------------
CREATE TABLE uso_componentes (
    Id_producto INT NOT NULL,
    Id_proceso INT NOT NULL,
    Id_componente INT NOT NULL
);

-------------------------------------------------------------------------------
-- 19) MAQUINARIA
-------------------------------------------------------------------------------
CREATE TABLE maquinaria (
    Id_maquinaria INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    capacidad VARCHAR(100) NOT NULL,
    estado ENUM('Operativa','disponible','ocupada','mantenimiento','inactiva','averiada') NOT NULL,
    fecha_mantenimiento DATE NOT NULL
);

-------------------------------------------------------------------------------
-- 20) USO MAQUINARIA
-------------------------------------------------------------------------------
CREATE TABLE uso_maquinaria (
    Id_producto INT NOT NULL,
    Id_proceso INT NOT NULL,
    Id_maquinaria INT NOT NULL
);

-------------------------------------------------------------------------------
-- 🔗 FOREIGN KEYS
-------------------------------------------------------------------------------

ALTER TABLE empleados 
    ADD FOREIGN KEY (Id_cargo) REFERENCES cargos(Id_cargo),
    ADD FOREIGN KEY (Id_jefe_directo) REFERENCES empleados(Id_empleado);

ALTER TABLE ventas 
    ADD FOREIGN KEY (Id_cliente) REFERENCES clientes(Id_cliente),
    ADD FOREIGN KEY (Id_empleado) REFERENCES empleados(Id_empleado);

ALTER TABLE detalle_ventas 
    ADD FOREIGN KEY (Id_venta) REFERENCES ventas(Id_venta),
    ADD FOREIGN KEY (Id_producto) REFERENCES productos(Id_producto);

ALTER TABLE recetas 
    ADD FOREIGN KEY (Id_producto) REFERENCES productos(Id_producto);

ALTER TABLE proceso_elaboracion 
    ADD FOREIGN KEY (Id_receta) REFERENCES recetas(Id_receta),
    ADD FOREIGN KEY (Id_producto) REFERENCES productos(Id_producto),
    ADD FOREIGN KEY (Id_empleado) REFERENCES empleados(Id_empleado);

ALTER TABLE empleados_ventas 
    ADD FOREIGN KEY (Id_venta) REFERENCES ventas(Id_venta),
    ADD FOREIGN KEY (Id_empleado) REFERENCES empleados(Id_empleado);

ALTER TABLE empleados_proceso_elaboracion 
    ADD FOREIGN KEY (Id_empleado) REFERENCES empleados(Id_empleado),
    ADD FOREIGN KEY (Id_proceso) REFERENCES proceso_elaboracion(Id_proceso);

ALTER TABLE produccion 
    ADD FOREIGN KEY (Id_producto) REFERENCES productos(Id_producto);

ALTER TABLE compra 
    ADD FOREIGN KEY (Id_proveedor) REFERENCES proveedores(Id_proveedor);

ALTER TABLE proveedores_compras 
    ADD FOREIGN KEY (Id_compra) REFERENCES compra(Id_compra),
    ADD FOREIGN KEY (Id_proveedor) REFERENCES proveedores(Id_proveedor);

ALTER TABLE inventario 
    ADD FOREIGN KEY (Id_compra) REFERENCES compra(Id_compra);

ALTER TABLE detalle_compra 
    ADD FOREIGN KEY (Id_compra) REFERENCES compra(Id_compra),
    ADD FOREIGN KEY (Id_inventario) REFERENCES inventario(Id_inventario);

ALTER TABLE componentes 
    ADD FOREIGN KEY (Id_inventario) REFERENCES inventario(Id_inventario);

ALTER TABLE uso_componentes 
    ADD FOREIGN KEY (Id_producto) REFERENCES productos(Id_producto),
    ADD FOREIGN KEY (Id_proceso) REFERENCES proceso_elaboracion(Id_proceso),
    ADD FOREIGN KEY (Id_componente) REFERENCES componentes(Id_componentes);

ALTER TABLE uso_maquinaria 
    ADD FOREIGN KEY (Id_producto) REFERENCES productos(Id_producto),
    ADD FOREIGN KEY (Id_proceso) REFERENCES proceso_elaboracion(Id_proceso),
    ADD FOREIGN KEY (Id_maquinaria) REFERENCES maquinaria(Id_maquinaria);


