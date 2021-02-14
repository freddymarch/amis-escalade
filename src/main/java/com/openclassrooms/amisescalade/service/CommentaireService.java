package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

public interface CommentaireService {

    Commentaire siteId(Site site);

    List<Commentaire> findAll();

    Commentaire findById(Long id);

    void add(Commentaire commentaire);

    void edit(Commentaire commentaire);

    void delete(Long id);
}
