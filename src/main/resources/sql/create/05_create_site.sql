create table T_SITE
(
    C_ID       int          not null auto_increment
        primary key,
    C_SITE_NAME     varchar(50)  null,
    C_SITE_TAG varchar(100) null,
    C_SITE_LOC_PAYS    varchar(100)  null,
    C_SITE_ADRESSE varchar(100)  null
);