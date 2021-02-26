create table T_SECTEUR
(
    C_ID       int          not null auto_increment
        primary key,
    C_NAME_SECTEUR     varchar(50)  null,
    C_VOIES varchar(100) null,
    C_COTATION varchar(100) null,
        C_HEIGHT_MAX    varchar(100)  null,
    C_EQUIPMENT varchar(100)  null,
    C_TYPE_OF_SOCKETS varchar(100) null ,
    C_ADDITIONAL_INFORMATION varchar(100) null
);