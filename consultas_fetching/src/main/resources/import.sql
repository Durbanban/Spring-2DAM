INSERT INTO categoria (id, nombre) VALUES (1, 'MacBook')
INSERT INTO categoria (id, nombre) VALUES (2, 'Dell')


INSERT INTO producto (id, nombre, precio, categoria) VALUES (1, 'MacBook Pro 14" M1', 1999, 1)
INSERT INTO producto (id, nombre, precio, categoria) VALUES (2, 'MacBook Pro 16" M1', 2499, 1)

INSERT INTO imagen_producto (id, url, producto_id) VALUES (1, 'https://blabla.com/1', 2)
INSERT INTO imagen_producto (id, url, producto_id) VALUES (2, 'https://blabla.com/2', 1)