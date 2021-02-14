package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Integer> {

    Optional<Secteur> findById(long id);

    @Modifying
    @Query("delete from Secteur s where s.id=:id")
    void deleteById(Long id);

    @Modifying
    @Query("delete from Secteur s where s.site.id=:siteId")
    void deleteBySiteId(Long siteId);
}
