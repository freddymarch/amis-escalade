package com.openclassrooms.amisescalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "T_SITE")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long id;

    @Column(name = "C_SITE_NAME",length = 50, nullable = false)
    private String nom;

    @Column(name = "C_SITE_TAG",length = 100, nullable = false)
    private String tag;

    @Column(name = "C_SITE_LOC_PAYS",length = 100, nullable = false)
    private String pays;

    @Column(name = "C_SITE_ADRESSE",length = 100, nullable = false)
    private String adresse;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", tag='" + tag + '\'' +
                ", pays='" + pays + '\'' +
                ", adresse='" + adresse + '\'' +
                '}';
    }
}
