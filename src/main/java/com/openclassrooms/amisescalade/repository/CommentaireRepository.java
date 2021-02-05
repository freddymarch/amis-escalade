package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

    void deleteById(Long id);

}
