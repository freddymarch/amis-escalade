package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.Topo;
import com.openclassrooms.amisescalade.model.User;

import java.util.List;

public interface TopoService {

    List<Topo> searchAllTopo();

    Topo searchTopoid(Long id);

    void addTopo(Topo topo);

    void editTopo(Topo topo);

    void deleteTopo(Long topoId);

}
