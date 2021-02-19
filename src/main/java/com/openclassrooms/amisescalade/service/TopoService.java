package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.Topo;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;

/**
 * Contrat d'interface du service métier pour gérer les topos
 */
public interface TopoService {

    /**
     * Rechercher la liste de tous les topos.
     *
     * @return la liste des topos.
     */
    List<Topo> findAll();

    /**
     * Rechercher un topo à partir d'un identifiant.
     *
     * @param id identifiant du topo.
     * @return Topo ayant l'id.
     */
    Topo findById(Long id);

    /**
     * Ajouter un nouveau topo.
     *
     * @param topo nouveau {@link Topo} à ajouter
     */
    void add(Topo topo);

    /**
     * Modifier un topo.
     *
     * @param topo {@link Topo} à modifier.
     */
    void edit(Topo topo);

    /**
     * Supprimer un topo.
     * @param topoId Id du topo à supprimer
     */
    void delete(Long topoId);

    /**
     * Demande de reservation d'un topo.
     * @param
     */
    void requestReservation(Topo topo, User user);

    /**
     * Validation de la reservation d'un topo.
     * @param
     */
    void validationReservation(Topo topo);

    /**
     * Refuser la reservation d'un topo.
     * @param
     */
    void refusReservation(Topo topo);

}
