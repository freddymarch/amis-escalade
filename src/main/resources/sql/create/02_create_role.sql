create table T_ROLE
(
    C_ID       int          not null auto_increment
        primary key,
    C_CODE     varchar(50)  not null,
    C_LABEL varchar(50) not null,
    UNIQUE (C_CODE)
);