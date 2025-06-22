INSERT INTO rol ( nombre, descripcion) VALUES
('ADMINISTRADOR', 'Acceso total al sistema'),
('LOGISTICA', 'Acceso a logística y almacén'),
('ALMACENERO', 'Acceso solo a almacén');

INSERT INTO usuario (nombre, apellido, telefono, email, dni, password, cod_rol) VALUES 
('Juan', 'Pérez', '987654321', 'juan@upn.pe', '75418008', '$2a$10$GrgWePbCsIoRNaZDQ38gCONprzCCrGC1I5z6AY.PyPL0g5YQhoMs2', 1), 
('Pepe', 'Gonzales', '992394959', 'pepe@upn.pe', '75096279', '$10$NQ/YvCDPuLbtgKufo4k3hOuK/CWMfrUM5R0WWdp3spdBT93lIdf5y', 2), 
('Maria', 'Castro', '992345692', 'maria@upn.pe', '76578906', '$10$faC1nKUoDJdeSslyj6BGredL.1AqQ.j7cpyr8QwI2KKgl8abM4PxS', 3);
