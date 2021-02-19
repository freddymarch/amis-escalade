package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

public interface CommentaireService {

    /**
     * Rechercher la liste des commentaire correspondante au site.
     *
     * @return la liste des commentaires.
     */
    Commentaire siteId(Site site);

    /**
     * Rechercher la liste de tous les commentaires.
     *
     * @return la liste des commentaires
     */
    List<Commentaire> findAll();

    /**
     * Rechercher un commentaire à partir d'un identifiant.
     *
     * @param id identifiant du commentaire.
     * @return commentaire ayant l'id
     */
    Commentaire findById(Long id);

    /**
     * Ajouter un nouveau commentaire.
     *
     * @param commentaire nouveau {@link Commentaire} à ajouter
     */
    void add(Commentaire commentaire);

    /**
     * Modifier un commentaire.
     *
     * @param commentaire {@link Commentaire} à modifier.
     */
    void edit(Commentaire commentaire);

    /**
     * Supprimer un commentaire
     * @param id Id du commentaire à supprimer
     */
    void delete(Long id);
}
