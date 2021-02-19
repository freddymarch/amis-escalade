package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositiory d'accès aux données d'un utilisateur en base de données.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Recherche d'un utilisateur à partir de son identifiant name.
     *
     * @param name nom de l'utilisateur recherché.
     * @return site
     */
    Optional<User> findByName(@Param("name") String name);

    /**
     * Recherche d'un utilisateur à partir de son identifiant mail.
     *
     * @param email email de l'utilisateur recherché.
     * @return site
     */
    @Query("select u from User u left join fetch u.role where u.email =:email")
    Optional<User> findByEmail(@Param("email") String email);
}
