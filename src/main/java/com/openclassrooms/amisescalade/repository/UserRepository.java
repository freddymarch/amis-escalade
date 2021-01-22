package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(@Param("name") String name);

    @Query("select u from User u left join fetch u.role where u.email =:email")
    Optional<User> findByEmail(@Param("email") String email);
}
