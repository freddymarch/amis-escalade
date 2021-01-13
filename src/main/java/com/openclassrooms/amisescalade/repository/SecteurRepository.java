package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {

    Optional<Secteur> findById(long id);

    void deleteById(Long id);
}
