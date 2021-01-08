create table t_commentaire
(
    C_ID          int auto_increment
        primary key,
    C_DATE        date         null,
    C_COMMENTAIRE varchar(500) null,
    C_ID_SITE     int          null,
    C_ID_USER     int          null
    );