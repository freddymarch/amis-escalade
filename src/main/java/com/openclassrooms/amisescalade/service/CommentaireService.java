package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;
import java.util.Optional;

public interface CommentaireService {

    Commentaire siteId(Site site);

    Commentaire userId(User user);

    List<Commentaire> findAll();

    Commentaire findById(Long id);

    void add(Commentaire commentaire);

    void edit(Commentaire commentaire);

    void delete(Long Id);
}
