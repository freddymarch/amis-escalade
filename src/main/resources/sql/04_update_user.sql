ALTER TABLE T_USER ADD C_ROLE_ID int;
ALTER TABLE T_USER ADD FOREIGN KEY (C_ROLE_ID) REFERENCES T_ROLE(C_ID);
