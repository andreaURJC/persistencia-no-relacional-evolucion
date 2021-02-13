create table if not exists hibernate_sequence
(
    next_val bigint
) engine = InnoDB;

create table if not exists aeropuerto
(
    iata   varchar(3) not null,
    ciudad varchar(255),
    nombre varchar(255),
    pais   varchar(255),
    primary key (iata)
) engine = InnoDB;


create table if not exists avion
(
    matricula   varchar(255) not null,
    fabricante  varchar(255),
    horas_vuelo integer,
    modelo      varchar(255),
    primary key (matricula)
) engine = InnoDB;

create table if not exists mecanico
(
    codigo_empleado   bigint  not null,
    apellidos         varchar(255),
    nombre            varchar(255),
    ano_incorporacion integer not null,
    empresa           varchar(255),
    formacion         varchar(255),
    primary key (codigo_empleado)
) engine = InnoDB;

create table if not exists revision
(
    id           bigint  not null,
    descripcion  varchar(255),
    fecha_fin    datetime(6),
    fecha_inicio datetime(6),
    horas        integer not null,
    tipo         varchar(255),
    aeropuerto   varchar(3),
    avion        varchar(255),
    mecanico     bigint,
    primary key (id),
    constraint FK_avion FOREIGN KEY (`avion`) references avion (`matricula`),
    constraint FK_aeropuerto FOREIGN KEY (`aeropuerto`) references aeropuerto (`iata`),
    constraint FK_mecanico FOREIGN KEY (`mecanico`) references mecanico (`codigo_empleado`)
) engine = InnoDB;

create table if not exists tripulante
(
    codigo_empleado bigint not null,
    apellidos       varchar(255),
    nombre          varchar(255),
    compania        varchar(255),
    puesto          varchar(255),
    primary key (codigo_empleado)
) engine = InnoDB;

create table if not exists vuelo
(
    codigo_vuelo       bigint not null,
    compania           varchar(255),
    duracion           double precision,
    fecha_hora         datetime(6),
    aeropuerto_destino varchar(3),
    aeropuerto_origen  varchar(3),
    avion              varchar(255),

    constraint FK_vuelo_aeropuerto_destino FOREIGN KEY (`aeropuerto_destino`) references aeropuerto (`iata`),
    constraint FK_vuelo_avion FOREIGN KEY (`avion`) references avion (`matricula`),
    constraint FK_vuelo_aeropuerto_origen FOREIGN KEY (`aeropuerto_origen`) references aeropuerto (`iata`),
    primary key (codigo_vuelo)
) engine = InnoDB;

create table if not exists vuelo_tripulante
(
    tripulante_codigo_empleado bigint not null,
    vuelo_codigo_vuelo         bigint not null,

    constraint FK_tripulante_codigo_empleado FOREIGN KEY (`tripulante_codigo_empleado`) references tripulante (`codigo_empleado`),
    constraint FK_vuelo_codigo_vuelo FOREIGN KEY (`vuelo_codigo_vuelo`) references vuelo (`codigo_vuelo`),
    primary key (tripulante_codigo_empleado, vuelo_codigo_vuelo)
) engine = InnoDB;

insert into mecanico (nombre, apellidos, empresa, ano_incorporacion, formacion, codigo_empleado)
values ('Dionisio', 'Alvarez', 'Mecatron', 1995, 'Modulo FP', 1),
       ('Antonio', 'Gutierrez', 'SuperAviones', 2003, 'Grado en Aeronautica', 2);

insert into avion (matricula, fabricante, modelo, horas_vuelo)
values ('B-0747', 'Boeing', '747', 200),
       ('A-0380', 'Airbus Group', 'A380', 550);

insert into aeropuerto (nombre, ciudad, pais, iata)
values ('Aeropuerto de Leon', 'Leon', 'ESP', 'LEO'),
       ('Aeropuerto de Alicante', 'Alicante', 'ESP', 'ALC');

insert into revision (aeropuerto, avion, descripcion, fecha_fin, fecha_inicio, horas, mecanico, tipo, id)
values ('LEO', 'A-0380', 'descripcion de la revision 1', '2021-01-06 20:00:00.000000', '2021-01-06 10:00:00.000000', 10,
        1,
        'anual', 1),
       ('ALC', 'B-0747', 'descripcion de la revision 2', '2021-01-01 00:00:00.000000', '2021-01-01 20:00:00.000000', 20,
        2,
        'mensual', 2),
       ('LEO', 'A-0380', 'descripcion de la revision 3', '2020-11-06 20:00:00.000000', '2020-11-06 10:00:00.000000', 10,
        2, 'mensual', 3);
insert into vuelo (aeropuerto_destino, aeropuerto_origen, avion, compania, duracion, fecha_hora, codigo_vuelo)
values ('LEO', 'ALC', 'A-0380', 'IBERIA', 2, '2021-01-03 04:10:00.000000', 0100),
       ('ALC', 'LEO', 'B-0747', 'EMIRATES', 3, '2021-03-04 06:45:00.000000', 0200);
insert into tripulante (nombre, apellidos, compania, puesto, codigo_empleado)
values ('Rafael', 'Santos', 'Iberia', 'Azafato', 3),
       ('Ane', 'Colina', 'Emirates', 'Azafata', 4),
       ('Angel', 'Ramirez', 'Iberia', 'Azafato', 5),
       ('Andrea', 'Fernandez', 'Emirates', 'Azafata', 6);
insert into vuelo_tripulante (vuelo_codigo_vuelo, tripulante_codigo_empleado)
values (0100, 3),
       (0200, 4),
       (0100, 5),
       (0200, 6);
