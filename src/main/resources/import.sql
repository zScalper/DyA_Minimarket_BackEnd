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
INSERT INTO proveedor (id_proveedor, razon_social, direccion, cod_tipo) VALUES
(1, 'Distribuidora Lima SAC', 'Av. Venezuela 1234, Lima', 1),
(2, 'Industrias Andinas SRL', 'Jr. Cusco 654, Huancayo', 2),
(3, 'Importaciones Vizcarra EIRL', 'Calle Colón 202, Arequipa', 3);
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