package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositiory d'accès aux données d'un role en base de données.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    /**
     * Recherche d'un role à partir de son identifiant unique.
     *
     * @param code code du role recherché.
     * @return secteur
     */
    Role findByCode(String code);
}
