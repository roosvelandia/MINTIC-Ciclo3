CREATE TABLE `login`.`cliente` (
  `cedula` INT NOT NULL,
  `nombrecompleto` VARCHAR(60) NULL,
  `direccion` VARCHAR(60) NULL,
  `telefono` VARCHAR(17) NULL,
  `correo` VARCHAR(100) NULL,
  PRIMARY KEY (`cedula`));
  insert into cliente values(631245123, 'Luisa Fernanda Yepes', 'Carrera 23 # 12 -40', '323124512', 'lyepes@floresta.edu.co');