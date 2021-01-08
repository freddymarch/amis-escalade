package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {

    Optional<Commentaire> findById(long id);
}
