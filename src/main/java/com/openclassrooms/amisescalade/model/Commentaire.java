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
@Table(name = "T_COMMENTAIRE")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "C_ID")
    private long id;

    @Column(name = "C_DATE", length = 50, nullable = false)
    private Date date;

    @Column(name = "C_COMMENTAIRE")
    private String commentaireText;

    @ManyToOne
    @JoinColumn(name = "C_ID_SITE", nullable = false)
    private Site site;

    @ManyToOne
    @JoinColumn(name = "C_ID_USER", nullable = false)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentaireText() {
        return commentaireText;
    }

    public void setCommentaireText(String commentaire) {
        this.commentaireText = commentaire;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
