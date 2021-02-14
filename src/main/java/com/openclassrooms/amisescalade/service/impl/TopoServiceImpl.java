package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.enums.StatusTopo;
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
    public List<Topo> findAll() {
        return topoRepository.findAll();
    }

    @Override
    public Topo findById(Long id) {
        Optional<Topo> optionalTopo = topoRepository.findById(id);
        return optionalTopo.isPresent() ? optionalTopo.get() : null;
    }

    @Override
    public void add(Topo topo) {
        topoRepository.save(topo);
    }

    @Override
    public void edit(Topo topo) {
        topoRepository.save(topo);
    }

    @Override
    public void delete(Long topoId) {
        topoRepository.deleteById(topoId);
    }

    @Override
    public void requestReservation(Topo topo, User user) {
        topo.setUserReserve(user);
        topo.setStatus(StatusTopo.IN_PROGRESS.getLabel());
        topo.setAvailable(false);
        topoRepository.save(topo);
    }

    @Override
    public void validationReservation(Topo topo) {
        topo.setStatus(StatusTopo.VALIDATE.getLabel());
        //topo.setAvailable(false);
        topo.setConfirmReservation(true);
        topoRepository.save(topo);
    }

    @Override
    public void refusReservation(Topo topo) {
        topo.setStatus(StatusTopo.REFUSE.getLabel());
        topo.setAvailable(true);
        topo.setConfirmReservation(false);
        topoRepository.save(topo);
    }
}
