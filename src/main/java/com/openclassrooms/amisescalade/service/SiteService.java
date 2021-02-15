package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;

import java.util.List;

/**
 * Contrat d'interface du service métier pour gérer les sites
 */
public interface SiteService {

    /**
     * Rechercher la liste de tous les sites.
     *
     * @return la liste des sites
     */
    List<Site> findAll();

    /**
     * Rechercher un site à partir d'un identifiant.
     *
     * @param id identifiant du site.
     * @return Site ayant l'id
     */
    Site findById(Long id);

    /**
     * Ajouter un nouveau site.
     *
     * @param site nouveau {@link Site} à ajouter
     */
    void add(Site site);

    /**
     * Modifier un site.
     *
     * @param site {@link Site} à modifier.
     */
    void edit(Site site);

    /**
     * Supprimer un site
     * @param siteId Id du site à supprimer
     */
    void delete(Long siteId);
}
