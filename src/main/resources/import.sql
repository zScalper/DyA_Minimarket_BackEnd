INSERT INTO rol(id_rol, nombre, descripcion) VALUES
('1', 'Administrador', 'Acceso total al sistema'),
('2', 'Logistica', 'Acceso a logística y almacén'),
('3', 'Almacenero', 'Acceso solo a almacén');
INSERT INTO usuario (nombre, apellido, telefono, email, dni, password, cod_rol) VALUES 
('Juan', 'Pérez', '987654321', 'juan@upn.pe', '75418008', '$2a$10$GrgWePbCsIoRNaZDQ38gCONprzCCrGC1I5z6AY.PyPL0g5YQhoMs2', 1), 
('Pepe', 'Gonzales', '992394959', 'pepe@upn.pe', '75096279', '$10$NQ/YvCDPuLbtgKufo4k3hOuK/CWMfrUM5R0WWdp3spdBT93lIdf5y', 2), 
('Maria', 'Castro', '992345692', 'maria@upn.pe', '76578906', '$10$faC1nKUoDJdeSslyj6BGredL.1AqQ.j7cpyr8QwI2KKgl8abM4PxS', 3);
INSERT INTO estado (id_estado, estado, detalle_estado) VALUES
(1, 'Activo', 'Producto disponible en stock'),
(2, 'Quiebre en bodega', 'Sin stock en almacén'),
(3, 'Discontinuado', 'Producto fuera del catálogo'),
(4, 'Pendiente', 'En proceso de reposición'),
(5, 'Quiebre', 'Totalmente agotado'),
(6, 'Más vendido', 'Producto top en ventas'),
(7, 'PENDIENTE', 'Estado pendiente'),
(8, 'EN PROCESO', 'Estado en proceso'),
(9, 'FINALIZADO', 'Estado finalizado');
INSERT INTO tipo_proveedor (id_tipo, nombre, detalle) VALUES
(1, 'Mayorista', 'Distribuidor mayorista de productos de consumo masivo'),
(2, 'Fábrica', 'Proveedor directo desde planta de producción'),
(3, 'Importador', 'Importador de productos extranjeros'),
(4, 'Nacional', 'Distribuidor peruano de confianza');
INSERT INTO proveedor (id_proveedor, razon_social, direccion, cod_tipo, ruc) VALUES
(1, 'Distribuidora Lima SAC', 'Av. Venezuela 1234, Lima', 1, '20123456789'),
(2, 'Industrias Andinas SRL', 'Jr. Cusco 654, Huancayo', 2, '20456789123'),
(3, 'Importaciones Vizcarra EIRL', 'Calle Colón 202, Arequipa', 3, '20678912345');
INSERT INTO categoria (id_categoria, nombre_categoria, detalle_categoria) VALUES
(1, 'Abarrotes', 'Productos envasados de consumo básico'),
(2, 'Bebidas', 'Refrescos, jugos y gaseosas'),
(3, 'Limpieza', 'Productos de aseo del hogar y personal');
INSERT INTO unidad (id_unidad, unidad, detalle) VALUES
(1, 'Unidad', 'Unidad individual'),
(2, 'Caja', 'Caja con unidades empaquetadas'),
(3, 'Litro', 'Capacidad líquida de un litro');
INSERT INTO producto (id_producto, nombre, cantidad, precio, cod_categoria, cod_estado, cod_proveedor, cod_unidad, sku) VALUES
(1, 'Arroz Costeño 1kg', 80, 4.50, 1, 1, 1, 1, 'ABA-001'),
(2, 'Fideos Don Vittorio 500g', 60, 3.80, 1, 1, 1, 1, 'ABA-002'),
(3, 'Aceite Primor 1L', 45, 10.90, 1, 1, 2, 3, 'ABA-003'),
(4, 'Atún Florida 170g', 70, 5.10, 1, 1, 3, 1, 'ABA-004'),
(5, 'Sal Lobos 1kg', 50, 1.20, 1, 1, 2, 1, 'ABA-005'),
(6, 'Leche Gloria 400g', 90, 4.90, 1, 6, 2, 1, 'ABA-006'),
(7, 'Detergente Bolívar 1kg', 30, 9.50, 3, 1, 3, 1, 'LIM-001'),
(8, 'Jabón Bolívar 150g', 40, 2.80, 3, 1, 2, 1, 'LIM-002'),
(9, 'Shampoo Savital 400ml', 25, 7.30, 3, 4, 3, 3, 'LIM-003'),
(10, 'Inka Kola 1.5L', 55, 6.00, 2, 6, 1, 3, 'BEB-001'),
(11, 'Coca Cola 1.5L', 50, 6.20, 2, 6, 2, 3, 'BEB-002'),
(12, 'Agua San Luis 625ml', 70, 2.30, 2, 1, 1, 3, 'BEB-003'),
(13, 'Jugo Cifrut Naranja 500ml', 45, 3.50, 2, 1, 2, 3, 'BEB-004'),
(14, 'Cerveza Pilsen Botella 620ml', 80, 5.90, 2, 5, 3, 3, 'BEB-005'),
(15, 'Galletas Oreo 144g', 65, 3.80, 1, 1, 1, 1, 'ABA-007'),
(16, 'Café Altomayo 200g', 30, 11.50, 1, 4, 2, 1, 'ABA-008'),
(17, 'Azúcar Rubia 1kg', 75, 3.80, 1, 1, 3, 1, 'ABA-009'),
(18, 'Papel Higiénico Elite x4', 28, 8.90, 3, 1, 2, 2, 'LIM-004'),
(19, 'Desinfectante Sapolio 500ml', 35, 6.30, 3, 2, 1, 3, 'LIM-005'),
(20, 'Lavavajilla Ayudín 450ml', 32, 5.70, 3, 1, 3, 3, 'LIM-006');
INSERT INTO producto (id_producto, nombre, cantidad, precio, cod_categoria, cod_estado, cod_proveedor, cod_unidad, sku) VALUES
(21, 'Lavavajilla Ayudín 450ml', 5, 5.70, 3, 1, 3, 3, 'LIM-007');
INSERT INTO requerimiento (id_requerimiento, fecha, cod_estado, cod_usuario) VALUES
(1, '2025-06-01', 7, 1),
(2, '2025-06-02', 7, 2),
(3, '2025-06-03', 7, 3),
(4, '2025-06-04', 7, 1),
(5, '2025-06-05', 7, 2);
INSERT INTO detalle_requerimiento (id_detalle_requerimiento, cod_producto, cantidad, cod_requerimiento) VALUES
-- Requerimiento 1
(1, 1, 10, 1),
(2, 2, 5, 1),
-- Requerimiento 2
(3, 10, 8, 2),
(4, 11, 6, 2),
(5, 12, 4, 2),
-- Requerimiento 3
(6, 7, 12, 3),
(7, 8, 10, 3),
-- Requerimiento 4
(8, 3, 6, 4),
(9, 15, 9, 4),
(10, 16, 3, 4),
-- Requerimiento 5
(11, 17, 15, 5),
(12, 19, 10, 5),
(13, 20, 7, 5);

INSERT INTO moneda (id_moneda, detalle, nombre) VALUES
(1, 'Moneda oficial de Perú', 'Sol'),
(2, 'Moneda oficial de Estados Unidos', 'Dólar estadounidense'),
(3, 'Moneda oficial de la Unión Europea', 'Euro');

INSERT INTO forma_pago (id_forma_pago, detalle, forma_pago) VALUES
(1, 'Pago realizado en efectivo físico', 'Efectivo'),
(2, 'Pago con tarjeta de crédito bancaria', 'Tarjeta de crédito'),
(3, 'Pago directo desde cuenta de débito', 'Tarjeta de débito'),
(4, 'Pago mediante transferencia interbancaria', 'Transferencia bancaria'),
(5, 'Pago con cheque firmado', 'Cheque');
INSERT INTO cotizacion (fecha, fecha_vencimiento, cod_estado, cod_requerimiento)
VALUES 
('2025-06-30', '2025-07-10', 8, 1);

INSERT INTO detalle_cotizacion (cod_cotizacion, cod_producto, cantidad, precio_unitario, cod_moneda, cod_forma_pago)
VALUES 
  (1, 1, 10, 4.20, 1, 1),
  (1, 2,  5, 3.80, 1, 2);
  
INSERT INTO orden_compra (id_orden_compra, cod_cotizacion, fecha, monto_total)
VALUES
  (1, 1, '2025-07-01', 82.40),
  (2, 1, '2025-07-02', 135.60);
INSERT INTO departamento (id_departamento, nombre) VALUES
(1, 'Lima'),
(2, 'Arequipa'),
(3, 'Junín'),
(4, 'Cusco'),
(5, 'La Libertad'),
(6, 'Piura');

INSERT INTO provincia (id_provincia, nombre, cod_departamento) VALUES
(1, 'Lima Metropolitana', 1),
(2, 'San Borja', 1),
(3, 'Miraflores', 1),
(4, 'Arequipa', 2),
(5, 'Huancayo', 3),
(6, 'Cusco', 4),
(7, 'Trujillo', 5),
(8, 'Piura', 6),
(9, 'Chiclayo', 5),
(10, 'Callao', 1);

INSERT INTO distrito (id_distrito, nombre, cod_provincia) VALUES
(1, 'Miraflores', 3),
(2, 'San Borja', 2),
(3, 'Centro', 5),
(4, 'Yanahuara', 4),
(5, 'Wanchaq', 6),
(6, 'Centro Histórico', 7),
(7, 'Castilla', 8),
(8, 'La Victoria', 9),
(9, 'Bellavista', 10),
(10, 'Jesús María', 1),
(11, 'San Isidro', 1),
(12, 'Los Olivos', 1);

INSERT INTO tienda (id_tienda, nombre, direccion, telefono, cod_departamento, cod_provincia, cod_distrito) VALUES
(1, 'Dya Miraflores', 'Av. Larco 101, Miraflores', '987654321', 1, 3, 1),
(2, 'Dya San Borja', 'Av. Aviación 2020, San Borja', '987654322', 1, 2, 2),
(3, 'Dya Huancayo', 'Jr. Puno 300, Huancayo', '987654323', 3, 5, 3),
(4, 'Dya Arequipa', 'Calle Melgar 110, Arequipa', '987654324', 2, 4, 4),
(5, 'Dya Cusco', 'Av. El Sol 500, Cusco', '987654325', 4, 6, 5),
(6, 'Dya Trujillo', 'Jr. Independencia 305, Trujillo', '987654326', 5, 7, 6),
(7, 'Dya Piura', 'Av. Grau 220, Piura', '987654327', 6, 8, 7),
(8, 'Dya Chiclayo', 'Av. Bolognesi 120, Chiclayo', '987654328', 5, 9, 8),
(9, 'Dya Callao', 'Av. Sáenz Peña 450, Bellavista', '987654329', 1, 10, 9),
(10, 'Dya Jesús María', 'Av. San Felipe 780, Jesús María', '987654330', 1, 1, 10),
(11, 'Dya San Isidro', 'Av. Javier Prado 300, San Isidro', '987654331', 1, 1, 11),
(12, 'Dya Los Olivos', 'Av. Universitaria 1200, Los Olivos', '987654332', 1, 1, 12),
(13, 'Dya Wanchaq', 'Av. La Cultura 400, Cusco', '987654333', 4, 6, 5),
(14, 'Dya Yanahuara', 'Av. Ejército 650, Arequipa', '987654334', 2, 4, 4),
(15, 'Dya Castilla', 'Av. Grau 999, Piura', '987654335', 6, 8, 7),
(16, 'Dya La Victoria', 'Av. Balta 321, Chiclayo', '987654336', 5, 9, 8),
(17, 'Dya Centro Lima', 'Jr. de la Unión 500, Lima', '987654337', 1, 1, 10),
(18, 'Dya Santa Anita', 'Av. Los Ruiseñores 510, Lima', '987654338', 1, 1, 12),
(19, 'Dya Trujillo Este', 'Av. Mansiche 800, Trujillo', '987654339', 5, 7, 6),
(20, 'Dya Surco', 'Av. Caminos del Inca 430, Lima', '987654340', 1, 1, 11);

INSERT INTO despacho (id_despacho, fecha, cod_estado, cod_tienda, cod_usuario) VALUES
(1, '2025-07-01', 8, 1, 1),
(2, '2025-07-02', 9, 2, 2),
(3, '2025-07-02', 9, 3, 2),
(4, '2025-07-03', 7, 4, 1),
(5, '2025-07-03', 8, 5, 2),
(6, '2025-07-04', 9, 6, 1),
(7, '2025-07-05', 7, 7, 2),
(8, '2025-07-05', 9, 8, 1),
(9, '2025-07-06', 8, 9, 2),
(10, '2025-07-06', 9, 10, 1),
(11, '2025-07-07', 9, 11, 1),
(12, '2025-07-08', 8, 12, 2),
(13, '2025-07-08', 7, 13, 2),
(14, '2025-07-09', 9, 14, 1),
(15, '2025-07-09', 8, 15, 2);

INSERT INTO detalle_despacho (id_detalle_despacho, cantidad, cod_producto, cod_despacho) VALUES
(1, 10, 1, 1),
(2, 5, 2, 1),
(3, 20, 1, 2),
(4, 10, 2, 2),
(5, 15, 2, 3),
(6, 7, 1, 3),
(7, 12, 2, 4),
(8, 8, 1, 4),
(9, 10, 1, 5),
(10, 6, 2, 5),
(11, 18, 1, 6),
(12, 9, 2, 6),
(13, 14, 2, 7),
(14, 10, 1, 7),
(15, 13, 1, 8),
(16, 5, 2, 8),
(17, 16, 1, 9),
(18, 7, 2, 9),
(19, 11, 2, 10),
(20, 9, 1, 10),
(21, 12, 1, 11),
(22, 4, 2, 11),
(23, 17, 2, 12),
(24, 10, 1, 12),
(25, 10, 1, 13),
(26, 8, 2, 13),
(27, 20, 1, 14),
(28, 5, 2, 14),
(29, 18, 1, 15),
(30, 9, 2, 15);