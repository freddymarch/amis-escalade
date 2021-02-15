package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositiory d'accès aux données d'un site en base de données.
 */
@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

    /**
     * Recherche d'un site à partir de son identifiant unique.
     *
     * @param id identifiant du site recherché.
     * @return site
     */
    Optional<Site> findById(long id);

    /**
     * Suppression d'un site à partir de son identifiant.
     *
     * @param id identifiant du site à supprimer.
     */
    @Modifying
    @Query("delete from Site s where s.id=:id")
    void deleteById(Long id);
}
