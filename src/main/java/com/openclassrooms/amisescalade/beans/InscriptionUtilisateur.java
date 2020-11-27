package com.openclassrooms.amisescalade.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class InscriptionUtilisateur {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;
    private boolean activer;
    private String email;
    private String motDePasse;

    public InscriptionUtilisateur() {
    }

            public String getNom () {
                return nom;
            }

            public void setNom (String nom){
                this.nom = nom;
            }

            public String getPrenom () {
                return prenom;
            }

            public void setPrenom (String prenom){
                this.prenom = prenom;
            }

            public boolean isEnabled () {
                return activer;
            }

            public void setEnabled ( boolean enabled){
                this.activer = enabled;
            }

            public String getEmail () {
                return email;
            }

            public void setEmail (String email){
                this.email = email;
            }

            public String getMotDePasse () {
                return motDePasse;
            }

            public void setMotDePasse (String motDePasse){
                this.motDePasse = motDePasse;
            }

            public void setId ( long id){
                this.id = id;
            }

            @Id
            public long getId () {
                return id;
            }

            @Override
            public String toString () {
                return "id : " + id + " nom : " + nom + " prenom : " + prenom + "activer" + activer + " email : " + email + " mot de passe : " + motDePasse;
            }
        }