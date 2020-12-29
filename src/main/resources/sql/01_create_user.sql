create table T_USER
(
    C_ID       int          not null auto_increment
        primary key,
    C_NAME     varchar(50)  null,
    C_LASTNAME varchar(100) null,
    C_EMAIL    varchar(50)  null,
    C_PASSWORD varchar(50)  null
);