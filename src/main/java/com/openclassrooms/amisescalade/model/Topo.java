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

    @Column(name = "C_PLACES", length = 100, nullable = false)
    private String places;

    @Column(name = "C_RELEASE_DATE", length = 10, nullable = false)
    private String releaseDate;

    @Column(name = "C_CONFIRM_RESERVATION")
    private boolean confirmReservation;

    @Column(name = "C_AVAILABLE")
    private boolean available;

    @Column(name = "C_STATUS", length = 255, nullable = true)
    private String status;

    @ManyToOne
    @JoinColumn(name = "C_ID_USER_RESERVE")
    private User userReserve;

    @ManyToOne
    @JoinColumn(name = "C_ID_USER_WITH_TOPO")
    private User userWithTopo;

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getUserReserve() {
        return userReserve;
    }

    public void setUserReserve(User userReserve) {
        this.userReserve = userReserve;
    }

    public boolean isConfirmReservation() {
        return confirmReservation;
    }

    public void setConfirmReservation(boolean requestReservation) {
        this.confirmReservation = requestReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String booking) {
        this.status = booking;
    }

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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
