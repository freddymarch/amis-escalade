package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Commentaire;
import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.repository.SecteurRepository;
import com.openclassrooms.amisescalade.service.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SecteurServiceImpl implements SecteurService {

    @Autowired
    SecteurRepository secteurRepository;

    @Override
    public Secteur userId(User user) {
        Secteur secteur = new Secteur();
        secteur.setUser(user);
        return secteur;
    }

    @Override
    public List<Secteur> findAll() {
        return secteurRepository.findAll();
    }

    @Override
    public Secteur findById(Long id) {
        Optional<Secteur> optionalSecteur = secteurRepository.findById(id);
        return optionalSecteur.isPresent() ? optionalSecteur.get() : null;
    }

    @Override
    public void add(Secteur secteur)  {
        secteurRepository.save(secteur);
    }

    @Override
    public void edit(Secteur secteur) {
        secteurRepository.save(secteur);
    }

    @Override
    public void delete(Long id) {
        secteurRepository.deleteById(id);
    }
}
