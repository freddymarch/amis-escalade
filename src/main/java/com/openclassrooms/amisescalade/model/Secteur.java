package com.openclassrooms.amisescalade.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_SECTEUR")
public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long id;

    @Column(name = "C_NAME_SECTEUR")
    private String nameSecteur;

    @Column(name = "C_VOIES")
    private String voies;

    @Column(name = "C_HEIGHT_MAX")
    private String heightMax;

    @Column(name = "C_EQUIPMENT")
    private String equipment;

    @Column(name = "C_TYPE_OF_SOCKETS")
    private String typeOfSockets;

    @Column(name = "C_ADDITIONAL_INFORMATION")
    private String additionalInformation;

    @ManyToOne
    @JoinColumn(name = "C_ID_SITE", nullable = false)
    private Site site;

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSecteur() {
        return nameSecteur;
    }

    public void setNameSecteur(String nameSecteur) {
        this.nameSecteur = nameSecteur;
    }

    public String getVoies() {
        return voies;
    }

    public void setVoies(String voies) {
        this.voies = voies;
    }

    public String getHeightMax() {
        return heightMax;
    }

    public void setHeightMax(String heightMax) {
        this.heightMax = heightMax;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getTypeOfSockets() {
        return typeOfSockets;
    }

    public void setTypeOfSockets(String typeOfSockets) {
        this.typeOfSockets = typeOfSockets;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nameSecteur='" + nameSecteur + '\'' +
                ", voies='" + voies + '\'' +
                ", heightMax='" + heightMax + '\'' +
                ", equipment='" + equipment + '\'' +
                ", heightMax='" + heightMax + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                '}';
    }
}
