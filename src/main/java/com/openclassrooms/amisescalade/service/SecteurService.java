package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;
import java.util.Optional;

public interface SecteurService {

    List<Secteur> searchAllSecteur();

    Secteur siteId(Site site);

    Secteur searchSecteurId(Long id);

    Optional<String> addSecteur(Secteur secteur);

    void editSecteur(Secteur secteur);

    void deleteSecteur(Long id);
}
