create table reserva (
 id int(11) not null auto_increment,
 tipo_reserva varchar(10) not null,
 fecha_inicio datetime not null,
 fecha_fin datetime not null,
 hora_inicio datetime not null,
 hora_fin datetime not null,
 tipo_tarifa varchar(10) not null,
 valor_total_reserva double (10,0) not null,
 datos_cliente varchar(250) not null,
 primary key (id)
);