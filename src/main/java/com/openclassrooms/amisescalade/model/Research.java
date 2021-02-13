package com.openclassrooms.amisescalade.model;

public class Research {

    private String pays;
    private String cotation;
    private Integer nbSecteurs;

    public Research() {
    }

    public Research(String pays, String cotation, Integer nbSecteurs) {
        this.pays = pays;
        this.cotation = cotation;
        this.nbSecteurs = nbSecteurs;
    }


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public Integer getNbSecteurs() {
        return nbSecteurs;
    }

    public void setNbSecteurs(Integer nbSecteurs) {
        this.nbSecteurs = nbSecteurs;
    }

}
