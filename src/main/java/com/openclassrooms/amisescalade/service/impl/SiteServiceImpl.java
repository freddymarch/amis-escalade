package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Secteur;
import com.openclassrooms.amisescalade.model.Site;
import com.openclassrooms.amisescalade.repository.CommentaireRepository;
import com.openclassrooms.amisescalade.repository.SiteRepository;
import com.openclassrooms.amisescalade.repository.UserRepository;
import com.openclassrooms.amisescalade.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CommentaireRepository commentaireRepository;

    @Override
    public List<Site> findAll() {
        return siteRepository.findAll();
    }

    @Override
    public Site findById(Long id) {
        Optional<Site> optionalSite = siteRepository.findById(id);
        return optionalSite.isPresent() ? optionalSite.get() : null;
    }

    @Override
    public void add(Site site)  {
        siteRepository.save(site);
    }

    @Override
    public void edit(Site site) {
        siteRepository.save(site);
    }

    @Override
    public void delete(Long id) {
        siteRepository.deleteById(id);
    }

}
