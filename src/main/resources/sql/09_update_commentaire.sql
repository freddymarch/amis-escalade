ALTER TABLE T_COMMENTAIRE ADD FOREIGN KEY (C_ID_SITE) REFERENCES T_SITE(C_ID);

ALTER TABLE T_COMMENTAIRE ADD FOREIGN KEY (C_ID_USER) REFERENCES T_USER(C_ID);