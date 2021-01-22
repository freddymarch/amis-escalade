package com.openclassrooms.amisescalade.repository;

import com.openclassrooms.amisescalade.model.Topo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopoRepository extends JpaRepository<Topo,Long> {

}
