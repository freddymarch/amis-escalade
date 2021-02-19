package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

public interface SecteurService {

    /**
     * Rechercher la liste de tous les secteurs.
     *
     * @return la liste des secteurs.
     */
    List<Secteur> findAll();

    /**
     * Rechercher un secteur à partir d'un identifiant.
     *
     * @param id identifiant du secteur.
     * @return Secteur ayant l'id.
     */
    Secteur findById(Long id);

    /**
     * Ajouter un nouveau secteur.
     *
     * @param secteur nouveau {@link Secteur} à ajouter.
     */
    void add(Secteur secteur);

    /**
     * Modifier un secteur.
     *
     * @param secteur {@link Secteur} à modifier.
     */
    void edit(Secteur secteur);

    /**
     * Supprimer un secteur.
     * @param id Id du secteur à supprimer.
     */
    void delete(Long id);
}
