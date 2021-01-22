create table t_topo
(
    C_ID          int auto_increment
        primary key,
    C_NAME        varchar (50)        null,
    C_DESCRIPTION varchar(500) null,
    C_PLACES     varchar (100)      null,
    C_RELEASE_DATE  DATE        null,
    C_ID_USER_CREATE_TOPO int
    );