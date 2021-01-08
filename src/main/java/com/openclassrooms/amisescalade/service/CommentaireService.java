package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;
import java.util.Optional;

public interface CommentaireService {

    Commentaire siteId(Site site);

    Commentaire userId(User user);

    List<Commentaire> searchAllCommentaire();

    Commentaire searchCommentaireid(Long id);

    Optional<String> addCommentaire(Commentaire commentaire);

    void editCommentaire(Commentaire commentaire);

    void deleteCommentaire(Long Id);
}
