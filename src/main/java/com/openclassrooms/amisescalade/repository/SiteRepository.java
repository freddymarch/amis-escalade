package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {

    Optional<Site> findById(long id);

    @Modifying
    @Query("delete from Site s where s.id=:id")
    void deleteById(Long id);
}
