package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopoRepository extends JpaRepository<Topo, Long> {

    void deleteById(Long id);
}
