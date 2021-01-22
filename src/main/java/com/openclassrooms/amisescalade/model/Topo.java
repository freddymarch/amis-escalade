package com.openclassrooms.amisescalade.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "T_TOPO")
public class Topo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long id;

    @Column(name = "C_NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "C_DESCRIPTION", length = 500, nullable = false)
    private String description;

    @Column(name = "C_PLACES",length = 100, nullable = false)
    private String places;

    @Column(name = "C_RELEASE_DATE",length = 50, nullable = false)
    private Date releaseDate;

//    @Column(name = "C_REQUEST_RESERVATION")
//    private boolean requestReservation;
//
//    @Column(name = "C_BOOKING")
//    private String booking;

    @ManyToOne
    @JoinColumn(name = "C_ID_USER_CREATE_TOPO")
    private User userWithTopo;

    public User getUserWithTopo() {
        return userWithTopo;
    }

    public void setUserWithTopo(User userWithTopo) {
        this.userWithTopo = userWithTopo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Topo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", places='" + places + '\'' +
                ", releaseDate=" + releaseDate +
                ", userWithTopo=" + userWithTopo +
                '}';
    }
}
