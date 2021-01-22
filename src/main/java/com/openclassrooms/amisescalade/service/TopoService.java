package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.Topo;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;

public interface TopoService {

    List<Topo> findAll();

    Topo findById(Long id);

    void add(Topo topo);

    void edit(Topo topo);

    void delete(Long topoId);

}
