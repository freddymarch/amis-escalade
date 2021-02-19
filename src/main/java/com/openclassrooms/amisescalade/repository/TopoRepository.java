package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositiory d'accès aux données d'un topo en base de données.
 */
@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {

    /**
     * Suppression d'un topo à partir de son identifiant.
     *
     * @param id identifiant du topo à supprimer.
     */
    void deleteById(Long id);
}
