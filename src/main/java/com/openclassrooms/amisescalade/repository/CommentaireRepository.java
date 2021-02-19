package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    /**
     * Suppression d'un commentaire à partir de son identifiant.
     *
     * @param id identifiant du commentaire à supprimer.
     */
    @Modifying
    @Query("delete from Commentaire c where c.id=:id")
    void deleteById(Long id);

    /**
     * Suppression d'un site et du commentaire à partir de son identifiant.
     *
     * @param siteId identifiant du site et du commentaire à supprimer.
     */
    @Modifying
    @Query("delete from Commentaire c where c.site.id=:siteId")
    int deleteBySiteId(Long siteId);

}
