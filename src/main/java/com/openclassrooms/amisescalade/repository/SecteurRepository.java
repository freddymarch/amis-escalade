package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositiory d'accès aux données d'un secteur en base de données.
 */
@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {

    /**
     * Recherche d'un secteur à partir de son identifiant unique.
     *
     * @param id identifiant du secteur recherché.
     * @return secteur
     */
    Optional<Secteur> findById(long id);

    /**
     * Suppression d'un secteur à partir de son identifiant.
     *
     * @param id identifiant du secteur à supprimer.
     */
    @Modifying
    @Query("delete from Secteur s where s.id=:id")
    void deleteById(Long id);

    /**
     * Suppression d'un site et du secteur à partir de son identifiant.
     *
     * @param siteId identifiant du site et du secteur à supprimer.
     */
    @Modifying
    @Query("delete from Secteur s where s.site.id=:siteId")
    void deleteBySiteId(Long siteId);
}
