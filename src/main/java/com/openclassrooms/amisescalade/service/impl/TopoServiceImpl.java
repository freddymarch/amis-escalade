package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.model.Topo;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.repository.TopoRepository;
import com.openclassrooms.amisescalade.service.TopoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TopoServiceImpl implements TopoService {

    @Autowired
    private TopoRepository topoRepository;

    @Override
    public List<Topo> searchAllTopo() {
        return topoRepository.findAll();
    }

    @Override
    public Topo searchTopoid(Long id) {
        Optional<Topo> optionalTopo = topoRepository.findById(id);
        if (optionalTopo.isPresent()) {
            return optionalTopo.get();
        }
        return null;
    }

    @Override
    public void addTopo(Topo topo) {
        topoRepository.save(topo);
    }

    @Override
    public void editTopo(Topo topo) {
        topoRepository.save(topo);
    }

    @Override
    public void deleteTopo(Long topoId) {
        topoRepository.deleteById(topoId);
    }

}
