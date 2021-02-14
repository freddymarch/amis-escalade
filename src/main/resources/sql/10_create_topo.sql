create table T_TOPO
(
    C_ID          int auto_increment
        primary key,
    C_NAME        varchar (50)        null,
    C_DESCRIPTION varchar(500) null,
    C_PLACES     varchar (100)      null,
    C_RELEASE_DATE  varchar(10)        null,
    C_ID_USER_WITH_TOPO int,
    C_ID_USER_RESERVE int,
    C_STATUS varchar (100),
    C_AVAILABLE BOOLEAN,
    C_CONFIRM_RESERVATION BOOLEAN
);
