package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.Site;
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
    public Secteur siteId(Site site) {
        Secteur secteur = new Secteur();
        secteur.setSite(site);
        return secteur;
    }

    @Override
    public List<Secteur> searchAllSecteur() {
        return secteurRepository.findAll();
    }

    @Override
    public Secteur searchSecteurId(Long id) {
        Optional<Secteur> optionalSecteur = secteurRepository.findById(id);
        if (optionalSecteur.isPresent()) {
            return optionalSecteur.get();
        }
        return null;
    }

    @Override
    public Optional<String> addSecteur(Secteur secteur) {
        secteurRepository.save(secteur);
        return Optional.empty();
    }

    @Override
    public void editSecteur(Secteur secteur) {
        secteurRepository.save(secteur);
    }

    @Override
    public void deleteSecteur(Long id) {
        secteurRepository.deleteById(id);
    }
}
