INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0001", "laboratorio 1");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0002", "Laboratorio 2");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0003", "Aula 1");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0004", "Aula 2");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0005", "Aula 3");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0006", "Aula 4");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0007", "Aula 5");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0008", "Laboratorio 3");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0009", "Laboratorio 4");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0010", "la1");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0011", "la2");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0012", "la3");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0013", "la4");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0014", "la5");
INSERT INTO ambientes(codigo_patrimonial, nombre) VALUES("a0015", "la6");

INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m001", "mesa 1", 1);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m002", "mesa 1", 1);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m003", "mesa 1", 2);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m004", "mesa 1", 2);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m005", "mesa 1", 3);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m006", "mesa 1", 3);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m007", "mesa 1", 3);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m008", "mesa 1", 3);
INSERT INTO muebles(codigo_patrimonial, nombre, ambiente_id) VALUES("m009", "mesa 1", 3);

INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0001", "oculus quest 2", "General", true, 1);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0002", "oculus quest 2", "General", false, 2);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0003", "robot nao", "General", true, 2);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0004", "dron", "General", true, 1);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0005", "E-4", "General", false, 2);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0006", "E-4", "General", false, 2);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0007", "computadora core-i9", "Particular", true, 2);
INSERT INTO equipos(codigo_patrimonial, nombre, tipo, operabilidad, ambiente_id) VALUES("e0008", "Projector", "Particular", true, 3);

iNSERT INTO usuarios(nombre, apellido, cui, telefono_cell, direccion, correo) VALUES("Hetmith", "Hancco", "", "955042968", "Cayma, la tomilla, av. 28 de julio", "hhanccot@unsa.edu.pe");
iNSERT INTO usuarios(nombre, apellido, cui, telefono_cell, direccion, correo) VALUES("Eduardo", "Ruiz", "", "967895654", "Cerro Colorado, ", "eruizd@unsa.edu.pe");
iNSERT INTO usuarios(nombre, apellido, cui, telefono_cell, direccion, correo) VALUES("Milagros", "Elme", "", "99999999", "Cayma, Asequi alta", "melmec@unsa.edu.pe");


INSERT INTO solicitudes(docente, curso, usuario_id, equipo_id) VALUES("Eliana Adriazola", "IP", 1,1);
INSERT INTO solicitudes(docente, curso, usuario_id, equipo_id) VALUES("Eliana Adriazola", "IPO",1,2);
INSERT INTO solicitudes(docente, curso, usuario_id, equipo_id) VALUES("Manuel Loayza", "Desarrollo",2,1);
INSERT INTO solicitudes(docente, curso, usuario_id, equipo_id) VALUES("Juan Carlos Gutierrez", "IA",1,3);


INSERT INTO prestamos(fecha_prestamo, fecha_devolucion, solicitud_id) VALUES("2024-10-21T15:30:00", "2024-10-21T15:30:00", 2);
INSERT INTO prestamos(fecha_prestamo, fecha_devolucion, solicitud_id) VALUES("2024-10-21T15:30:00", "2024-10-21T15:30:00", 1);
